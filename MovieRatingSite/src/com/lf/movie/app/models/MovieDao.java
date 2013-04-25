package com.lf.movie.app.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lf.movie.app.dto.Movie;
import com.lf.movie.auth.dto.User;

public class MovieDao {
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "db_movie";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "";

	public MovieDao() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Movie> getLatestMovies(int number) {
		//Movie movie = null;
		ArrayList<Movie> movies = new ArrayList<Movie>();
		String selectLatestMovie = "SELECT * " +
				"FROM ( SELECT id, name , datediff(NOW(),release_date) dayOld FROM movie ) m " +
				"WHERE dayOld >=0 " +
				"ORDER BY dayOld DESC " +
				"LIMIT ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectLatestMovie);
			ps.setInt(1, number);
			ResultSet rs = ps.executeQuery();
			
			Movie movie = new Movie();
			while(rs.next()){
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setAgeInDay(rs.getInt("dayOld"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	public ArrayList<Movie> getRankMovies(int number) {
		//Movie movie = null;
		ArrayList<Movie> movies = new ArrayList<Movie>();
		String selectRankMovie = "SELECT id, name, avg_rating " +
				"FROM ( SELECT id, name, rel_avg_rating*5 avg_rating , EXP(-(dayOld+1)/(rel_avg_rating+rel_user_num_rating+rel_view)) rankValue " +
				"FROM ( SELECT id,name, " +
				"(total_rating/user_num_rating)/5 rel_avg_rating, " +
				"user_num_rating/MAX(user_num_rating) rel_user_num_rating, " +
				"view/MAX(view) rel_view, " +
				"datediff(NOW(),release_date) dayOld " +
				"FROM movie) m " +
				"WHERE dayOld>=0 " +
				") rm " +
				"WHERE rankValue IS NOT NULL " +
				"ORDER BY rankValue DESC " +
				"LIMIT 10";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectRankMovie);
			ps.setInt(1, number);
			ResultSet rs = ps.executeQuery();
			
			Movie movie = new Movie();
			while(rs.next()){
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setAgeInDay(rs.getInt("dayOld"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

}

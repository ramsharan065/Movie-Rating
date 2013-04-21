package com.lf.movie.auth.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lf.movie.auth.dto.User;

public class UserDao {
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "db_movie";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "";

	public UserDao() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addUser(String name, String username, String password) {
		String insertUser = "INSERT INTO user(name,username, password) VALUES(?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(insertUser);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User getUser(String username, String password) {
		User user = null;
		String selectUser = "SELECT u.id,u.name,u.username,r.role "
				+ "FROM user u " + "JOIN role r ON (u.role_id=r.id) "
				+ "WHERE username=? AND password=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectUser);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"),
						rs.getString("name"), rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}

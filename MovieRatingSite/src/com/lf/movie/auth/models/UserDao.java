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
		String insertUser = "INSERT INTO user(name,username, password,role_id) VALUES(?,?,?,1)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(insertUser);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.executeUpdate();
		} catch (SQLException e) {
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
			e.printStackTrace();

		}
		return user;
	}

	public void setToken(User user) {
		String insertToken = "INSERT INTO auth_token(user_id, token) VALUES(?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(insertToken);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getToken());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeToken(User user){
		String deleteToken = "DELETE FROM auth_token WHERE token =?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(deleteToken);
			ps.setString(1, user.getToken());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getUserFromToken(String token) {
		User user = null;
		String selectUser = "select u.id,u.name,u.username,r.role "
				+ "from user u "
				+ "join (select a.user_id from auth_token a where a.token=?) t on (t.user_id=u.id) "
				+ "join role r on (r.id=u.role_id)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(selectUser);
			ps.setString(1, token);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"),
						rs.getString("name"), rs.getString("role"));
				user.setToken(token);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}

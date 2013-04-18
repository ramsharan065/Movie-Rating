package com.lf.movie.auth.user.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "db_movie";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "";
    int userId;
    
    public UserDao(){
    	try{
    	Class.forName(driver).newInstance();
    	conn = DriverManager.getConnection(url+dbName,userName,password);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    public boolean isValidUser(String username, String password) throws SQLException{
		String selectUser = "SELECT id FROM user WHERE username=? and password=?";
		PreparedStatement ps = conn.prepareStatement(selectUser);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			userId = rs.getInt("id");
			return true;
		}
		return false;
	}
    
	public int getUserId(){
		return userId;
	}
	
	public boolean addUser(String name, String username, String password){
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
}

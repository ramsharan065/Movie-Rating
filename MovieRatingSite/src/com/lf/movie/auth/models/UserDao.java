package com.lf.movie.auth.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "movie_rating";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "";
    Statement stat = null;
    int userId;
    
    public UserDao(){
    	try{
    	Class.forName(driver).newInstance();
    	conn = DriverManager.getConnection(url+dbName,userName,password);
	    stat = conn.createStatement();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    public boolean isValidUser(String username, String password) throws SQLException{
		String query = "Select id FROM user_login " +
				"WHERE username='"+username+"' and password='"+password+"'";
		ResultSet rs = stat.executeQuery(query);
		if(rs.next()){
			userId = rs.getInt("id");
			return true;
		}
		return false;
	}
    
	public int getUserId(){
		return userId;
	}
}

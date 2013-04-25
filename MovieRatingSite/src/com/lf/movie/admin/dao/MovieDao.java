package com.lf.movie.admin.dao;







import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.lf.movie.admin.dto.Director;
import com.lf.movie.admin.dto.Movie;
import com.lf.movie.auth.models.UserDao;

public class MovieDao  extends UserDao{
	 Director director = new Director();
	public void addMovie(Movie movie) throws Exception {
		int directorid = 0;
		int movieid=0;
		int writerid=0;
		int producerid=0;
        String query = "insert into movie(name,release_date,description,image,director,producer,writer) values (?,?,?,?,?,?,?)";

        
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, movie.getname());
            preparedStatement.setString(2, movie.getrelease_date());
            preparedStatement.setString(3, movie.getdesc());
            preparedStatement.setString(4, movie.getimage());
            preparedStatement.setString(5, movie.getdirector());
            preparedStatement.setString(6, movie.getproducer());
            preparedStatement.setString(7, movie.getwriter());
          

            preparedStatement.executeUpdate();
              
                 
            
            //inserting into director table
            String query1= "insert into director(name) values(?)";
            preparedStatement =conn.prepareStatement(query1);
            preparedStatement.setString(1, movie.getdirector());
          preparedStatement.executeUpdate();
            System.out.println(preparedStatement.executeUpdate());
            
            
 //getting director id
            
            String queryid="select id from director where name=?";
            preparedStatement = conn.prepareStatement(queryid);
            preparedStatement.setString(1,movie.getdirector());
           
            ResultSet resultSet = preparedStatement.executeQuery();
            

            if(resultSet.next()){

              directorid=resultSet.getInt("id");
              System.out.println("Gettingdirectorid"+directorid);
            }
            else{
            	System.out.println("cannot get director id from director table");
            }
            
            
            
         
            //inserting into producer table
            String querypro= "insert into producer(name) values(?)";
            preparedStatement =conn.prepareStatement(querypro);
            preparedStatement.setString(1, movie.getproducer());
          preparedStatement.executeUpdate();
            System.out.println(preparedStatement.executeUpdate());
            
            //inserting into writer table
            String querywrit= "insert into writer(name) values(?)";
            preparedStatement =conn.prepareStatement(querywrit);
            preparedStatement.setString(1, movie.getwriter());
          preparedStatement.executeUpdate();
            System.out.println(preparedStatement.executeUpdate());
            
            
            
           
            //getting writer id
            
            String queryidwriter="select id from writer where name=?";
            preparedStatement = conn.prepareStatement(queryidwriter);
            preparedStatement.setString(1,movie.getwriter());
           
             resultSet = preparedStatement.executeQuery();
            

            if(resultSet.next()){

              writerid=resultSet.getInt("id");
              System.out.println("GettingWriterid"+writerid);
            }
            else{
            	System.out.println("cannot get writer id from writer table");
            }
            
            
            //getting movieid
            String movquery="select id from movie where name=?";
            preparedStatement = conn.prepareStatement(movquery);
            preparedStatement.setString(1,movie.getname());
           
             resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            //	Movie movie = new Movie();
             movieid=resultSet.getInt("id");
             System.out.println("Gettingmovieid"+movieid);
            } 
            
            //getting producerid
            String prodquery="select id from producer where name=?";
            preparedStatement = conn.prepareStatement(prodquery);
            preparedStatement.setString(1,movie.getproducer());
           
             resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            //	Movie movie = new Movie();
             producerid=resultSet.getInt("id");
             System.out.println("Gettingmovieid"+producerid);
            } 
            
            
            
            
            
            
            
            String query2= "insert into movie_director(movie_id,director_id) values(?,?)";
            preparedStatement =conn.prepareStatement(query2);
            preparedStatement.setInt(1, movieid);
           // System.out.println("TEstststs"+movie.getid());
           preparedStatement.setInt(2,directorid);
           preparedStatement.executeUpdate();
            
           String query3= "insert into movie_producer(movie_id,producer_id) values(?,?)";
           preparedStatement =conn.prepareStatement(query3);
           preparedStatement.setInt(1, movieid);
          // System.out.println("TEstststs"+movie.getid());
          preparedStatement.setInt(2,producerid);
          preparedStatement.executeUpdate();
          
          
          
          String query4= "insert into movie_writer(movie_id,writer_id) values(?,?)";
          preparedStatement =conn.prepareStatement(query4);
          preparedStatement.setInt(1, movieid);
         // System.out.println("TEstststs"+movie.getid());
         preparedStatement.setInt(2,writerid);
         preparedStatement.executeUpdate();
          
           
           
	}
	
	
	
	public List<Movie> getMovie() throws SQLException {
        List<Movie> movies = new ArrayList<Movie>();
      String  query = "Select * from movie";
        
            preparedStatement = conn.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	Movie movie = new Movie();
            	movie.setid(resultSet.getInt("id"));
            	movie.setname(resultSet.getString(2));
            	movies.add(movie);
            }
            return movies;
	}
	
	public List<Director> getdirectorid() throws SQLException{
		List<Director> directorlist=new ArrayList<Director>();
		String query="select * from director";
		preparedStatement = conn.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		 while(resultSet.next()){
			
			 director.setid(resultSet.getInt("id"));
			 directorlist.add(director);
		 }
		 return directorlist;
	}
	
	

	
	public Movie editmovie(int movieId) throws SQLException{
		
		String query = "select * from movie where id=?";
		 preparedStatement = conn.prepareStatement(query);
         preparedStatement.setInt(1,movieId);
         ResultSet resultSet = preparedStatement.executeQuery();
        Movie movie=new Movie();
         while (resultSet.next()){
         	movie.setid(resultSet.getInt("id"));
         	movie.setname(resultSet.getString(2));
         	movie.setrelease_date(resultSet.getString("release_date"));
         	movie.setdesc(resultSet.getString("description"));
         	movie.setimage(resultSet.getString("image"));
         	movie.setproducer(resultSet.getString("producer"));
         	movie.setdirector(resultSet.getString("director"));
         	movie.setwriter(resultSet.getString("writer"));
         }
         return movie;
	}
	
	
	
	
	
	public  void updateMovie(Movie movie) throws Exception {

     String   query = "update movie set name =? ,release_date =?,description = ?,writer=?,producer=?,director=? where id=?";

       
           
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, movie.getname());
            preparedStatement.setString(2, movie.getrelease_date());
            preparedStatement.setString(3, movie.getdesc());
            preparedStatement.setString(4,movie.getwriter());
            preparedStatement.setString(5, movie.getproducer());
            preparedStatement.setString(6, movie.getdirector());
            preparedStatement.setInt(7, movie.getid());
            preparedStatement.executeUpdate();
	
	}
	
	
	public void deleteMovie(Movie movie) throws Exception {

      String  query = "delete from movie where id=?";

        
      
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, movie.getid());
           

          

            preparedStatement.executeUpdate();
	


}
	}


           
        



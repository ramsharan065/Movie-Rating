package com.lf.movie.admin.dto;

public class Movie {
private int id;
private String name;
private String release_date;
private String desc;
private String image;
private String director;
private String writer;
private String producer;
  

public String getproducer(){
	  return producer;
}
public void setproducer(String producer){
	  this.producer=producer;
}


public String getwriter(){
	  return writer;
}
public void setwriter(String writer){
	  this.writer=writer;
}


public String getdirector(){
	  return director;
  }
  public void setdirector(String director){
	  this.director=director;
  }

 public int getid(){
	return id;
	
 }
 public void setid(int id){
	 this.id=id;
 }
 
 public String getname(){
		return name;
		
	 }
	 public void setname(String name){
		 this.name=name;
	 }
	 
	 public String getrelease_date(){
			return release_date;
			
		 }
		 public void setrelease_date( String release){
			 release_date=release;
		 }
		 
		 public String getdesc(){
				return desc;
				
			 }
			 public void setdesc(String desc){
				 this.desc=desc;
			 }
			 public String getimage(){
					return image;
					
				 }
				 public void setimage(String image){
					 this.image=image;
				 }
 
}

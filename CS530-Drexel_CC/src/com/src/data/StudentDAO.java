package com.src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.src.base.Student;

public class StudentDAO {
	
	Student student = new Student();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:1433/Drexel_CC";
	   static final String USER = "SA";
	   static final String PASS = "Password@1";
	    
	   Connection conn = null;
	   public int Authenticate(String id){
		
		   //Statement stmt = null;
		try {
			
			//System.out.println("class.forname");
			Class.forName("com.mysql.jdbc.Driver");
			  System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      System.out.println("Creating statement...");
		     Statement  stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT Count(Name) as count from dbo.Student where Id ="+id;
		      ResultSet rs = stmt.executeQuery(sql);
		      if(rs.findColumn("count")==0)return 1;
		      else return 0; 
			
		}
		 catch(SQLException E){
			 
			 return 0;		
	 }
		catch(Exception e){
			System.out.println("NOT SQL");
			return 0;
		}
	finally{
		
		 
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	      System.out.println("Goodbye!");
	   }//end try
	
	}
	
  @SuppressWarnings("null")
public String[] myGroups()
  {
	String [] myGroups = null;
	int i=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	  System.out.println("Connecting to database...");
    try {
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    System.out.println("Creating statement...");
   Statement stmt = null;
try {
	stmt = conn.createStatement();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
    String sql;
    sql = "SELECT NAME FROM STUDY_GROUP WHERE ID IN(SELECT STUDY_GROUP_ID FROM STUDENT_STUDY_GROUP WHERE STUDENT_ID = " +student.getID()+")";
    try {
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			myGroups[i]=rs.getString(0);
			i++;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	  
	return myGroups;  
  }
		
	}



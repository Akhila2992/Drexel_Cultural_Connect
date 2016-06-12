package com.src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.src.base.StudyGroup;

public class StudyGroupDAO {
	StudyGroup studyGrp = new StudyGroup();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:1433/Drexel_CC";
	   static final String USER = "SA";
	   static final String PASS = "Password@1";
	    
	   Connection conn = null;
	
	   public void loadStudyGroup(String StudyGroupId)
	   {
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  System.out.println("Connecting to database...");
		      try {
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Creating statement...");
		     Statement stmt = null;
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      String sql;
		      sql = "SELECT ID, Name, Description, Content from STUDY_GROUP WHERE ID="+StudyGroupId;
		      try {
				ResultSet rs = stmt.executeQuery(sql);
				studyGrp.setID(StudyGroupId);
				studyGrp.setName(rs.getString(1));
				studyGrp.setDescription(rs.getString(2));
				studyGrp.setContent(rs.getString(4));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	   }
	   
	   
}

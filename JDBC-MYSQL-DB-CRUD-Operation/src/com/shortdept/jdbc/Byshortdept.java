package com.shortdept.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Byshortdept {

	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	// short by dept, gender, location
		public static void main(String[] args) throws Exception {
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Dept:: ");
			String dept = s.next();
			
			System.out.println("Enter Location:: ");
			String location = s.next();
			
			System.out.println("Enter Gender");
			String gender = s.next();
			
			StringBuilder sql = new StringBuilder("SELECT * FROM EMPLOYEE WHERE 1=1");// For all data showing type null all value
			
			if(dept != null && !dept.equals("null")){
				sql.append(" AND Emp_Dept = ?");
			}
			if(location != null && !location.equals("null")){
				sql.append(" AND Emp_Work_Location = ?");
			}
			if(gender != null && !gender.equals("null")) {
				sql.append(" AND Emp_Gender=?");
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);// step 2
			
			PreparedStatement psmt = con.prepareStatement(sql.toString());// step 3
			
			int index = 1;
			if(dept!=null && !dept.equals("null")) {
				psmt.setString(index, dept);
					index++;
			}
			
			if(location!=null && !location.equals("null")) {
				psmt.setString(index, location);
					index++;
			}
			
			if(gender != null && !gender.equals("null")) {
				psmt.setString(index, gender);
				
			}
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"------"+rs.getString(2)+"--------"+rs.getString(3)+"---------"+rs.getString(4)+"-------"+rs.getString(5));
				
			}
			
		con.close();	
		}
	
}

package EmployeeAddress.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAddress {
	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String EMP_INSERT ="INSERT INTO EMP VALUES(?,?,?)";
	private static final String EMP_ADDR_INSERT="INSERT INTO EMP_ADDRESS VALUES(?,?,?,?)";
	
	public static void main(String[] args) throws SQLException {
	
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		con.setAutoCommit(false);
		
		try {
			  PreparedStatement pstmt = con.prepareStatement(EMP_INSERT);
			  pstmt.setInt(1, 1023);
			  pstmt.setString(2, "John");
			  pstmt.setInt(3, 545);
			  
			  pstmt.executeUpdate();
			  
			   pstmt = con.prepareStatement(EMP_ADDR_INSERT);
			   pstmt.setString(1,"Hydrabad");
			   pstmt.setString(2, "AP");
			   pstmt.setString(3, "India");
			   pstmt.setInt(4, 1023);
			   
//			   pstmt.addBatch();
			   pstmt.executeUpdate();
			   
			   con.commit();
			  
			  System.out.println("Record Inserted:: ");
			  
		}catch(Exception e) {
			System.out.println("Transcation Rolled Back....");
			con.rollback();
		}
	
		   
		   con.close();
		   
	}

}

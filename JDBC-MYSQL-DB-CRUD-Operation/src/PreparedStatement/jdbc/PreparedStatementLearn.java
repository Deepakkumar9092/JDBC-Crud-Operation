package PreparedStatement.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class PreparedStatementLearn {
	
	
	private static final String DB_URl="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String INSERT_SQL = "INSERT INTO Books VALUES(?,?,?)";
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book_Id");
		int B_id = sc.nextInt();
		
		System.out.println("Enter Book_Name");
		String B_name = sc.next();
		
		System.out.println("Enter Book_Price");
		double B_price = sc.nextDouble();
		
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1 st Step
		
		Connection co = DriverManager.getConnection(DB_URl, DB_UNAME, DB_PWD); // 2nd Step
		
		PreparedStatement psmt = co.prepareStatement(INSERT_SQL); // 3rd Step
		psmt.setInt(1, B_id);
		psmt.setString(2, B_name);
		psmt.setDouble(3, B_price);
		
		int cnt = psmt.executeUpdate(); // 4th Step
		
		System.out.println("Rows Effected :: " + cnt);// 5th Step
		
		co.close();// 6th Step
		
	}

}

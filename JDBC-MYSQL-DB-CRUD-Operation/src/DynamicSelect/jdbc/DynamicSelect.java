package DynamicSelect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class DynamicSelect {
	/**
	 * Q1. Develop user Registration and user login Functionality.
	 Note - For registration and login read the data from Keyboard.
	 Note - We should not insert user record with duplicate email. If any user trying to register with duplicate email application should show error message.
	 */

	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
   // private static final String DB_SELECT = "Select * FROM BOOKS";
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Price ");
		int prices = s.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection co = DriverManager.getConnection(DB_URL, DB_UNAME ,DB_PWD);
		
		StringBuilder sql = new StringBuilder("SELECT * FROM BOOKS");//Space is mandatory to call the database value.
		
		if(prices > 0) {
			sql.append(" WHERE BOOKS_PRICE <= ?");
		}
		
		PreparedStatement psmt = co.prepareStatement(sql.toString());// From you use StringBuilder so you use toString()method.
		// For shorting the values of our requirement
		if(prices > 0)
			psmt.setInt(1, prices);
			
		
		
			
		ResultSet rs = psmt.executeQuery();		
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "-------" + rs.getString(2) + "-------" + rs.getInt(3));
		}
		
		co.close();
		
	}
}

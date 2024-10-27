package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Assignment {
	
	
	
	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String DB_SELECT = "Select * FROM BOOKS";// If you don't know this which operation is printed then we will go for.
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		
//		Statement statement = connection.createStatement();
		
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		//Both Sensitive and Insensitive are scrollable.
		
		
		ResultSet rs = stmt.executeQuery(DB_SELECT);
//		rs.getFetchSize();
//		rs.deleteRow();
//		rs.last();
//		while(rs.next()) {
//			System.out.println(rs.getInt(1)+"------"+ rs.getString(2)+"---------"+ rs.getDouble(3));
//			
//				Thread.sleep(1000);// For waiting 1second and printing per second 
//		}
		
		
		 
		rs.absolute(2);// absolute method - Moves the cursor to the given row number in this ResultSet object.
		// To move the cursor directly specific row.
		/* * 
//		******* There is a issue to run the code to get update */
		rs.updateString(2, "JDBdfhksdjf");// 3 is a row number to update the value.
		rs.updateRow();
		
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
			rs.previous();
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
			

		connection.close();
}
}
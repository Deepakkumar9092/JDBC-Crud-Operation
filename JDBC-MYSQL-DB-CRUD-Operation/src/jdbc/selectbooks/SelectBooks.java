package jdbc.selectbooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectBooks {
	
	/*
	 		============SELECT OPERATION USING JDBC =====================
	 	
	 	-> When we execute Select query using JDBC then we will get data from database in the form of ResultSet Object.
	 	-> ResultSet object will maintain a cursor which will point to current row.
	 	
	 	Note:-  Initially ResultSet cursor will point before first row. We need to move the cursor to next position by calling next() method.
	 	
	 	Syntax -
	 	 		boolean next()
	 	 		
	    -> When record is present next() method we will return true otherwise it will return false.
	    
	    if(rs.next()) {// It has row then it go to if condition
			// THis is checking the row this is available or not
			int Books_id = rs.getInt("Books_id");
			String b_name = rs.getString("Books_Name");
			double b_price = rs.getDouble("Books_price");
			
			System.out.println(Books_id);
			System.out.println(b_name);
			System.out.println(b_price);
		}
		else {// There is no row it will go for false value.
			System.out.println("No Record Found");
		}
	 	
	 * */
	
	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String DB_SELECT = "Select * FROM BOOKS WHERE BOOKS_ID = 13";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(DB_SELECT);// For Select Operation we use stm.executeQuery.
		// ResultSet -> It is used to store the data which has given by select query it will retrieve some data from the database table it will store into resultset object.
		// Cursor is pointing before 1st record.
		
		// By default ResultSet cursor will move only in Forward Direction.
		
		while(rs.next()) {// It has row then it go to if condition
			// THis is checking the row this is available or not
			//1st approach you can write like this
//			int Books_id = rs.getInt("Books_id");
//			String b_name = rs.getString("Books_Name");
//			double b_price = rs.getDouble("Books_price");
			
			
			//2nd approach you can write like this
			System.out.println(rs.getInt("Books_id"));
			System.out.println(rs.getString("Books_name"));
			System.out.println(rs.getString("Books_price"));
			
			//3rd approach you can write like this
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		System.out.println("Record Not Found");
		
		connection.close();
		
		
		/*
		 	============ResultSet Query Type=============
		 	ResultSet will represent data given by our select query.
		 	ResultSet will maintain cursor to point in row.
		 	Initially ResultSet will available before first record.
		 	We need to move the rs cursor to next position by calling next() method.
		 	By default resultset is in forward direction.
		 	
		 	Types- 
		 	1. Forward ResultSet : By default cursor will be available i 
		 	1. Sensitive ResultSet : Bi-Directional ResultSet and it will react for every changes.
		 	2. InSensitive ResultSet : Bi-Directional ResultSet and it won't react for changes.
		 	
		 	* ResultSet Concurrency will represent changes of ResultSet Data.
		 	
		 	   1. ResultSet.CONCUR_UPDATABLE -> It allows to update the resultset.
		 	   
		 	 *  code -  connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		      
		 	   
		 	   2. ResultSet.CONCUR_READ_ONLY -> It allows only read from resultset.
		 	    *  code-  connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		       
		        *  code - Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 	   
		 	   
		 	
		 * */
	}

}

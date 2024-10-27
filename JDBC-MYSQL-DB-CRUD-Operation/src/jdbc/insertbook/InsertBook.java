package jdbc.insertbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBook {

		private static final String DB_URl="jdbc:mysql://localhost:3306/advjava";
		private static final String DB_UNAME = "root";
		private static final String DB_PWD = "Deepak@9092";
		
		private static final String INSERT_SQL = "INSERT INTO Books VALUES(17,'JPA',329)";// create statement
		
		public static void main(String[] args) throws Exception {
			// Step 1: LoadDriver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: get Database Connection
			
			Connection con = DriverManager.getConnection(DB_URl, DB_UNAME, DB_PWD);

			
			// step 3 : Create Statement
			Statement st = con.createStatement();
			
			//step 4 - Execute Query
			int rowsEffected = st.executeUpdate(INSERT_SQL);
			
			//step 5 - Process the result
			System.out.println("Record Inserted Count:: " + rowsEffected);
			
			//step 6 - close connection
			con.close();
			
		}
}

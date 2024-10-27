package BatchOperationLearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchOperationLearn {
	/*
	 ===============JDBC Batch Operation=========================
	   -> Batch means Bulk Operations.
	   -> When we want to perform Bulk Operations then we can use JDBC Batch Operations.
	   
	    Eg - Insert 100 records in a table.
	   
	 * */
	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	
	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		Statement stmt = con.createStatement();
		
		 stmt.addBatch("INSERT INTO BOOKS VALUES(1113, 'AId', 430)");
		 stmt.addBatch("INSERT INTO BOOKS VALUES(1112, 'MLd', 439)");
		 stmt.addBatch("INSERT INTO BOOKS VALUES(1111, 'DJs', 433)");
		 stmt.addBatch("INSERT INTO BOOKS VALUES(1199, 'RBd', 435)");
		int[] cnt = stmt.executeBatch();// For calling 
		
		System.out.println("Record Effected :: "+cnt.length);
//		for(int i : cnt) {
//			System.out.println(i);
//		}
		
		con.close();
		System.out.println("Execution Completed");
	}
}

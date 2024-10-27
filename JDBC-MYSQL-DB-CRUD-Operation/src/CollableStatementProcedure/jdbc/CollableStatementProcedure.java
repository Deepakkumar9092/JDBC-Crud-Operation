package CollableStatementProcedure.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CollableStatementProcedure {
	
	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
//	private static final String PROCEDURE = "call getBooksById(12)";
	private static final String PROCEDURE = "call getBooksById(?)";
	
	public static void main(String[] args) throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Books id:: ");
		int Bookid = s.nextInt();
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		CallableStatement call = con.prepareCall(PROCEDURE);
		call.setInt(1, Bookid);// For set the value to call for positional parameter
		
		ResultSet rs = call.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"-------"+rs.getString(2)+"-------"+rs.getInt(3));
		}
		con.close();
	}

}

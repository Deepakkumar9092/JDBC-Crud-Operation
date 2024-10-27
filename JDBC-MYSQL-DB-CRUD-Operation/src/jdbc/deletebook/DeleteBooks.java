package jdbc.deletebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBooks {
	
	private static final String DB_URl="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String Delete_SQL = "DELETE FROM Books WHERE Books_id = 17 ";
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(DB_URl,DB_UNAME,DB_PWD);
		
		Statement stm = con.createStatement();
		
		int executeUpdate = stm.executeUpdate(Delete_SQL);
		
		System.out.println("Record Deleted :: " + executeUpdate);
		
		con.close();
	}

}

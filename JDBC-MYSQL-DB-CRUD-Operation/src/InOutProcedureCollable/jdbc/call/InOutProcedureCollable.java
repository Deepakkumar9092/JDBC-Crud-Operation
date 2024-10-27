package InOutProcedureCollable.jdbc.call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class InOutProcedureCollable {

	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String PROCEDURE = "call getBooksByPrice(?,?)";// For taking input(first ? is for input and second ? is for output)
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book Price:: ");
		int price = s.nextInt();
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		CallableStatement call = con.prepareCall(PROCEDURE);
		call.setInt(1, price);// For taking input 
		call.registerOutParameter(2, Types.VARCHAR);// For taking output value to first take registerOutParameter(Types.Varchar)
		
		ResultSet rs = call.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		con.close();
	}
}

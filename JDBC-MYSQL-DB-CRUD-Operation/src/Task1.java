import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Task1 {

	/*
	 Q.  Requirement : Develop JDBC application to read EMP_ID from Keyboard and then 
	       retrieve emp data along with address based on given emp_id from Database table.
	 * */
	private static final String DB_URL ="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Deepak@9092";
	
	private static final String EMP_SELECT = "SELECT * FROM EMP e, EMP_ADDRESS a WHERE e.emp_id = a.emp_id and e.emp_id = ?";
	public static void main(String[] args) throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("ENter emp id");
		int nextInt = s.nextInt();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement(EMP_SELECT);

		pstmt.setInt(1, nextInt);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
		}
		System.out.println("Record Printed");
		con.close();
	}
	}



package ConnectionPooling.jdbc;

public class ConnectionPooling {
	
	/*
	 
	 Connection Pooling is the process of getting fixed no.of connections from database and store them into a pool for re-usability.

	=> If we don't use Connection Pooling concept then our project will run into Connections Exhausted Problem (No connections available to communicate with db)


	=> If we use DriverManager.getConnection ( ) it will give physical connection with database. It is not at all recommended to use Physical Connections.

	=> Always we need to use Logical Connections to perform DB operations. To use Logical connections we need to setup Connection Pool.


	Note: With the connection pooling we can improve performance of the application.


		===========================
		How to setup Connection Pool
		==========================

		=> We can setup Connection Pool in 2 ways

		1) Client Side Connection Pool

			Ex: DBCP, C3P0, Hikari etc....

		2) Server Managed Connection Pool

			Ex: Tomcat, JBoss, WebLogic etc...
			
			
	===============================================
	Steps to develop JDBC app with Hikari Connection Pool
	===============================================

		1) Create Java Project in IDE

		2) Add below jars to project build path

		a) Hikar-CP.jar
		b) SLF4J-api.jar
		c) mysql-connector.java
	
		3) Create Java class to setup  connection pool like below


			
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "ashokit";

	private static final String DB_PWD = "AshokIT@123";

	public static void main(String[] args) throws Exception {

		HikariConfig config = new HikariConfig();

		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_UNAME);
		config.setPassword(DB_PWD);

		config.setMaximumPoolSize(20);
		config.setMinimumIdle(5);

		HikariDataSource datasource = new HikariDataSource(config);

		Connection con = datasource.getConnection();

		String sql = "INSERT INTO BOOKS VALUES (202, 'Django', 4500.00)";

		Statement stmt = con.createStatement();

		stmt.executeUpdate(sql);

		System.out.println("RECORD INSERTED.....");
		con.close();
	}
	
	========================.Properies FIle============
	private static DataSource datasource = null;

	static {

		try {

			File f = new File("DB.properties");
			FileInputStream fis = new FileInputStream(f);

			Properties p = new Properties();
			p.load(fis);

			String url = p.getProperty("db.url");
			String uname = p.getProperty("db.uname");
			String pwd = p.getProperty("db.pwd");
			String poolSize = p.getProperty("db.poolSize");

			HikariConfig config = new HikariConfig();

			config.setJdbcUrl(url);
			config.setUsername(uname);
			config.setPassword(pwd);
			config.setMaximumPoolSize(Integer.parseInt(poolSize));

			datasource = new HikariDataSource(config);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection() throws Exception {
		return datasource.getConnection();
	}
	 * */

}

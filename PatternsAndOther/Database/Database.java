
public class Database {
	
	private static ConnectionPool connectionPool = null;
	
	protected static class ConnectionPool {
		
		private static ConnectionPool instance = null;
		
		private String host;
		private int port;
		private String db;
		
		protected static DBConnection[] connPool = null;
		
		private ConnectionPool(final String host, final int port, final String dbName) {
			//Create persistent DB-connections...
			this.host = host;
			this.port = port;
			this.db = dbName;
		}
		public static void create(String host, int port, final String dbName) {
			
			if (instance == null) {
				
				instance = new ConnectionPool(host, port, dbName);
			}
			else {
				
				throw new Exception("Connection Pool is created already!");
			}
		}
		public static getInstance() {
			
			return instance;
		}
		public DBConnection get() {
			
			//return pool
		}
		public void close() {
			
			instance = null;
		}
	}
	/*
	public static void init() {
		ConnectionPool.create("10.10.10.98", 5000, "TestDB");
		//ConnectionPool connPool = ConnectionPool.getInstance();
		connPool.get();
		connPool.close();
	}
	*/
}

//Database.init();

//Database.DBConnection dbConn = Database.getConnection();
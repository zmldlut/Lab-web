package cn.edu.dlut.chuangxin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;


public class ConnectionPool {

	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://192.168.9.69:3306/lab";
	//private static String URL = "jdbc:mysql://127.0.0.1:3306/lab";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	
	private String _testTable = ""; // ���������Ƿ���õĲ��Ա�����Ĭ��û�в��Ա�
	private int initialConnections = 20; // ���ӳصĳ�ʼ��С
	private int incrementalConnections = 5;// ���ӳ��Զ����ӵĴ�С
    private int maxConnections = 50; // ���ӳ����Ĵ�С
    private Vector<PooledConnection> connectionVector = null; // ������ӳ������ݿ����ӵ����� , ��ʼʱΪ null
    
	//�������ӳس�ʼ��С
	public int getInitialConnections() {
		return this.initialConnections;
	}
	
	
	public void setInitialConnections(int initialConnections) {
		this.initialConnections=initialConnections;
	}
	
	//��ȡ���ӳ��Զ�����Ĵ�С
	public int getIncrementalConnections() {
		return this.incrementalConnections;
	}
	
	public void setIncrementalConnections(int incrementalConnections) {
		this.incrementalConnections = incrementalConnections;
	}
	
	//�������ӳ��е�����������
	public int getMaxConnections() {
		return this.maxConnections;
	}
	
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
	
	private static class ConnectionPoolHolder{
    	/** ��������  */
		private static ConnectionPool instance = new ConnectionPool();
    }
    
    private ConnectionPool() {
    	try {
			createPool();
		} catch (Exception e) {
			e.printStackTrace();
		}//�������ݿ����ӳ�
    }
    public static ConnectionPool getInstance() {
    	return ConnectionPoolHolder.instance;
    }
	
	//�������ݿ����ӳ�
	public synchronized void createPool()throws Exception{
		if(connectionVector!=null) {
			return;//����Ѿ�����
		}
		
		//ʵ����JDBC Driver��ָ����������ʵ��
		Driver driver =(Driver)(Class.forName(DRIVER).newInstance());
		
		DriverManager.registerDriver(driver);
		connectionVector = new Vector<PooledConnection>();
		
		createConnections(this.initialConnections);
		System.out.println("���ݿⴴ���ɹ�");
	}
	
	private void createConnections(int numConnections)throws SQLException{
		for(int x = 0;x<numConnections;x++)
		{
			if (this.maxConnections >0 && this.connectionVector.size() >= this.maxConnections) {
	            break;
			}

			try {
				connectionVector.addElement(new PooledConnection(createConnection()));
			} catch (SQLException e){
				System.out.println("�������ݿ�����ʧ��"+e.getMessage());
			}
			System.out.println("���ݿ������Ѿ��ܹ�����");
		}
	}
	
	private Connection createConnection() throws SQLException{
		Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		if (connectionVector.size()==0) {
			DatabaseMetaData metaData = (DatabaseMetaData) conn.getMetaData();
			int driverMaxConnections = metaData.getMaxConnections();
			if (driverMaxConnections>0&& this.maxConnections>driverMaxConnections) {
				this.maxConnections = driverMaxConnections;
			}
		}
		return conn;
	}
	
	public synchronized Connection getConnection() throws SQLException{
		int i=0;
		//ȷ�����ӳ��Ѿ�������
		if(connectionVector == null) {
			return null;
		}
		Connection conn = getFreeConnection();
		
		while(conn == null&&i<5){   ///��ȴ�5*50milliseconds,���ѭ��5��
			try {
				wait(50);//�ȴ�50 milliseconds
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = getFreeConnection();
			i++;
		}
		return conn;
	}
	
	private Connection getFreeConnection()throws SQLException{
		return findFreeConnection();
	}
	
	private Connection findFreeConnection()throws SQLException{
		Connection conn =null;
		PooledConnection pConn=null;
		Enumeration<PooledConnection> enumerate = connectionVector.elements();
		while(enumerate.hasMoreElements()) {
			pConn = (PooledConnection)enumerate.nextElement();
		 	if (!pConn.isBusy()) {
			    conn = pConn.getConnection();
			    pConn.setBusy(true);
			    // ���Դ������Ƿ����
			    if (!testConnection(conn)) {
			    	try {	
			    		conn = createConnection();
			    	} catch (SQLException e) {
			    		System.out.println(" �������ݿ�����ʧ�ܣ� " + e.getMessage());
			    		return null;
			    	}
			  		pConn.setConnection(conn);
			    }
			    break; // �����ҵ�һ�����õ����ӣ��˳�
			}
		}
		return conn;
	}
	
	/*
	 * �˺�������һ�����ݿ����ӵ����ӳ��У����Ѵ�������Ϊ����
	 * ����ʹ�����ӳػ�õ����ݿ����Ӿ�Ӧ���ڲ�ʹ����ʱ������
	 */
	public synchronized void returnConnection(Connection conn)
	{
		if(connectionVector == null) {
			System.out.println("���ӳز�����");
			return;
		}
		PooledConnection pConn = null;
		Enumeration<PooledConnection> enumerate = connectionVector.elements();
		while(enumerate.hasMoreElements()){
			pConn = (PooledConnection)enumerate.nextElement();
			//���ҵ����ӳ��е�Ҫ���ص����Ӷ���
			if(conn == pConn.getConnection()) {
				pConn.setBusy(false);//��Ϊ����״̬
				break;
			}
		}	
	}
	
    //����һ�������Ƿ����
    private boolean testConnection(Connection conn) {
    	try {
            if (_testTable.equals("")) {
               conn.setAutoCommit(true);
            } else {// �в��Ա��ʱ��ʹ�ò��Ա����
            	Statement stmt = (Statement) conn.createStatement();
            	stmt.execute("select count(*) from " + _testTable);
            }
       } catch (SQLException e) {
           closeConnection(conn);
           return false;
       }
       return true;
    }

    //�ر����ӳ������е����ӣ���������ӳء�
    public synchronized void closeConnectionPool() throws SQLException {
    	// ȷ�����ӳش��ڣ���������ڣ�����
        if (connectionVector == null) {
        	System.out.println(" ���ӳز����ڣ��޷��ر� !");
            return;
        }
        PooledConnection pConn = null;
        Enumeration<PooledConnection> enumerate = connectionVector.elements();
        while (enumerate.hasMoreElements()) {
        	pConn = (PooledConnection) enumerate.nextElement();
        	// ���æ���� 5 ��
            if (pConn.isBusy()) {
            	try {
					wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            closeConnection(pConn.getConnection());
            connectionVector.removeElement(pConn);
        }
        connectionVector = null;
   }

   	//�ر�һ�����ݿ�����
	private void closeConnection(Connection conn) {
		try{
			conn.close();
		}catch(SQLException e){
			System.out.println("�ر����ݿ����ӳ���:"+e.getMessage());
		}
	}
    
    class PooledConnection {
    	private Connection connection = null;// ���ݿ�����
	    private boolean busy = false; // �������Ƿ�����ʹ�õı�־��Ĭ��û������ʹ��
	    // ���캯��������һ�� Connection ����һ�� PooledConnection ����
        public PooledConnection(Connection connection) {
        	this.connection = connection;
        }
        // ���ش˶����е�����
        public Connection getConnection() {	
        	return connection;
        }
	
        // ���ô˶���ģ�����
        public void setConnection(Connection connection) {
        	this.connection = connection;	
        }

        // ��ö��������Ƿ�æ
        public boolean isBusy() {	
            return busy;
        }
        
       // ���ö������������æ
       public void setBusy(boolean busy) {
           this.busy = busy;
       }
	}	
}

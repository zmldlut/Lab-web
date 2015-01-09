package cn.edu.dlut.chuangxin.dao.proxy;

import java.sql.Connection;
import java.sql.SQLException;

import cn.edu.dlut.chuangxin.dao.impl.BaseDaoImpl;
import cn.edu.dlut.chuangxin.db.ConnectionPool;


public class BaseDaoProxy {
	
	protected ConnectionPool connPool = null;
	protected Connection conn = null;
	protected BaseDaoImpl dao = null;
	
	BaseDaoProxy() {
		this.connPool = ConnectionPool.getInstance();
		try {
			this.conn = connPool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	BaseDaoProxy(Class<? extends BaseDaoImpl> daoClass) {
		this.connPool = ConnectionPool.getInstance();
		try {
			this.conn = connPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dao = daoClass.newInstance();
			dao.setConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

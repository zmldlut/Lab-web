package cn.edu.dlut.chuangxin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseDaoImpl {
	//��������
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	
}

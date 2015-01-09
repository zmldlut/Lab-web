package cn.edu.dlut.chuangxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.AdminDao;
import cn.edu.dlut.chuangxin.model.Admin;


public class AdminDaoImpl extends BaseDaoImpl implements AdminDao{
	
	public AdminDaoImpl() {}
	
	public AdminDaoImpl(Connection conn) {
		super.conn = conn;
	}

	@Override
	public ArrayList<String> getNames() {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		String sql = "select name from admin";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public String getPasswordFromName(String name) {
		// TODO Auto-generated method stub
		String result = null;
		String sql = "select password from admin where name = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, name);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public boolean doCreate(Admin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin findDao(Admin obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

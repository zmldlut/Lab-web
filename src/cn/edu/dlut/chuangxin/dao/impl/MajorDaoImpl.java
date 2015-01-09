package cn.edu.dlut.chuangxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.MajorDao;
import cn.edu.dlut.chuangxin.model.Major;


public class MajorDaoImpl extends BaseDaoImpl implements MajorDao{
	
	public MajorDaoImpl() {}
	
	public MajorDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ArrayList<Major> getMajors() {
		// TODO Auto-generated method stub
		ArrayList<Major> result = new ArrayList<Major>();
		String sql = "select id,major_name from major ORDER BY id asc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Major major = new Major();
				major.setId(rs.getInt(1));
				major.setMajor_name(rs.getString(2));
				result.add(major);
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
	public String getNameFromID(int id) {
		// TODO Auto-generated method stub
		String result = null;
		String sql = "select major_name from major where id = ?";
		System.out.println(sql);
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
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
	public int getIDFromName(String name) {
		// TODO Auto-generated method stub
		int result = -1;
		String sql = "select id from major where major_name = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, name);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
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
	public int getMajorsSize() {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select COUNT(*) from major";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
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
	public boolean doCreate(Major obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Major findDao(Major obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

package cn.edu.dlut.chuangxin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.GradeDao;
import cn.edu.dlut.chuangxin.model.Grade;

public class GradeDaoImpl extends BaseDaoImpl implements GradeDao{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public GradeDaoImpl() {}
	
	public GradeDaoImpl(Connection conn) {
		super.conn = conn;
	}

	@Override
	public ArrayList<Grade> getGrades() {
		// TODO Auto-generated method stub
		ArrayList<Grade> result = new ArrayList<Grade>();
		String sql = "select id,grade_name from grade ORDER BY id asc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Grade grade = new Grade();
				grade.setId(rs.getInt(1));
				grade.setGrade_name(rs.getString(2));
				result.add(grade);
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
		String sql = "select grade_name from grade where id = ?";
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
		String sql = "select id from grade where grade_name = ?";
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
	public int getGradesSize() {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select COUNT(*) from grade";
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
	public boolean doCreate(Grade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grade findDao(Grade obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

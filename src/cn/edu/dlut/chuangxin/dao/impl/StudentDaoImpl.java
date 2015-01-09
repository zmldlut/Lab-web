package cn.edu.dlut.chuangxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.StudentDao;
import cn.edu.dlut.chuangxin.model.Student;


public class StudentDaoImpl extends BaseDaoImpl implements StudentDao{
	
	public StudentDaoImpl() {}
	
	public StudentDaoImpl(Connection conn) {
		super.conn = conn;
	}

	@Override
	public String getPasswordFromStdnum(String stdnum) {
		// TODO Auto-generated method stub
		String result = null;
		String sql = "select password from student where stdnum = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stdnum);
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
	public ArrayList<Student> getStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> result = new ArrayList<Student>();
		String sql = "select stdnum,cardID,name,password,major_id,grade_id,phone,email,qq,is_here from student ORDER BY stdnum asc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStdnum(rs.getString(1));
				student.setCardID(rs.getString(2));
				student.setName(rs.getString(3));
				student.setPassword(rs.getString(4));
				student.setMajor_id(rs.getInt(5));
				student.setGrade_id(rs.getInt(6));
				student.setPhone(rs.getString(7));
				student.setEmail(rs.getString(8));
				student.setQQ(rs.getString(9));
				student.setIs_here(rs.getBoolean(10));
				result.add(student);
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
	public ArrayList<Student> getStudents(int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Student> result = new ArrayList<Student>();
		String sql = "select stdnum,cardID,name,password,major_id,grade_id,phone,email,qq,is_here from student ORDER BY stdnum asc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, page * pageCount - pageCount);
			this.pstmt.setInt(2, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStdnum(rs.getString(1));
				student.setCardID(rs.getString(2));
				student.setName(rs.getString(3));
				student.setPassword(rs.getString(4));
				student.setMajor_id(rs.getInt(5));
				student.setGrade_id(rs.getInt(6));
				student.setPhone(rs.getString(7));
				student.setEmail(rs.getString(8));
				student.setQQ(rs.getString(9));
				student.setIs_here(rs.getBoolean(10));
				result.add(student);
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
	public int getStudentsSize() {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select COUNT(*) from student";
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
	public boolean doCreate(Student studentInfo) {
		// TODO Auto-generated method stub
		boolean result = true;
		String sql = "insert into student (stdnum, cardID, name, password, major_id, grade_id, phone, email, qq, is_here) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, studentInfo.getStdnum());
			this.pstmt.setString(2, studentInfo.getCardID());
			this.pstmt.setString(3, studentInfo.getName());
			this.pstmt.setString(4, studentInfo.getPassword());
			this.pstmt.setInt(5, studentInfo.getMajor_id());
			this.pstmt.setInt(6, studentInfo.getGrade_id());
			this.pstmt.setString(7, studentInfo.getPhone());
			this.pstmt.setString(8, studentInfo.getEmail());
			this.pstmt.setString(9, studentInfo.getQQ());
			this.pstmt.setBoolean(10, false);
			int rs = this.pstmt.executeUpdate();
			System.out.println(rs);
			if(rs < 1) result = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
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
	public Student findDao(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

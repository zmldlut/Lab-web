package cn.edu.dlut.chuangxin.dao.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.StudentDao;
import cn.edu.dlut.chuangxin.dao.impl.StudentDaoImpl;
import cn.edu.dlut.chuangxin.db.ConnectionPool;
import cn.edu.dlut.chuangxin.model.Student;

public class StudentDaoProxy implements StudentDao{

	private ConnectionPool connPool = null;
	private StudentDaoImpl dao = null;
	private Connection conn = null;
	
	public StudentDaoProxy() {
		try {
			this.connPool = ConnectionPool.getInstance();
			this.conn = connPool.getConnection();
			this.dao = new StudentDaoImpl(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPasswordFromStdnum(String stdnum) {
		// TODO Auto-generated method stub
		String result = null;
		result = this.dao.getPasswordFromStdnum(stdnum);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Student> getStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> result = null;
		result = this.dao.getStudents();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Student> getStudents(int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Student> result = null;
		result = this.dao.getStudents(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getStudentsSize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = this.dao.getStudentsSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Student studentInfo) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = this.dao.doCreate(studentInfo);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Student findDao(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

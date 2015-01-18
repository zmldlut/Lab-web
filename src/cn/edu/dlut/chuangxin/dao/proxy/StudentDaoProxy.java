package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.StudentDao;
import cn.edu.dlut.chuangxin.dao.impl.StudentDaoImpl;
import cn.edu.dlut.chuangxin.model.Student;

public class StudentDaoProxy extends BaseDaoProxy implements StudentDao{
	
	public StudentDaoProxy() {
		super(StudentDaoImpl.class);
	}

	@Override
	public String getPasswordFromStdnum(String stdnum) {
		// TODO Auto-generated method stub
		String result = null;
		result = ((StudentDao) super.dao).getPasswordFromStdnum(stdnum);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Student> getStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> result = null;
		result = ((StudentDao) super.dao).getStudents();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Student> getStudents(int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Student> result = null;
		result = ((StudentDao) super.dao).getStudents(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getStudentsSize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((StudentDao) super.dao).getStudentsSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Student studentInfo) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = ((StudentDao) super.dao).doCreate(studentInfo);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Student findDao(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> getStudents(Student student, int page,
			int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Student> result = null;
		result = ((StudentDao) super.dao).getStudents(student, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getStudentsSize(Student student) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((StudentDao) super.dao).getStudentsSize(student);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Student getStudentInfoFromStdnum(String stdnum) {
		// TODO Auto-generated method stub
		Student result = null;
		result = ((StudentDao) super.dao).getStudentInfoFromStdnum(stdnum);
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override 
	public boolean delStudent(String stdnum) {
		boolean result = false;
		result = ((StudentDao) super.dao).delStudent(stdnum);
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override
	public boolean updateStudent(Student student) {
		boolean result = false;
		result = ((StudentDao) super.dao).updateStudent(student);
		connPool.returnConnection(conn);
		return result;
	}
}

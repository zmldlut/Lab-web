package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.model.Student;


public interface StudentDao extends BaseDao<Student>{
	ArrayList<Student> getStudents();
	ArrayList<Student> getStudents(int page, int pageCount);
	ArrayList<Student> getStudents(Student student, int page, int pageCount);
	String getPasswordFromStdnum(String stdnum);
	Student getStudentInfoFromStdnum(String stdnum);
	int getStudentsSize();
	int getStudentsSize(Student student);
	
	boolean delStudent(String stdnum);
	boolean updateStudent(Student std);
}

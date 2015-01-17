package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.StudentDaoProxy;
import cn.edu.dlut.chuangxin.model.Student;

import com.opensymphony.xwork2.ActionSupport;

public class GetStudentsInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private JSONArray result = null;
	private int page = 1;
	private int pageCount = 10;
	private int maxPage = -1;
	private Student studentInfo = null;
	
	public Student getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(Student studentInfo) {
		this.studentInfo = studentInfo;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	private JSONArray getJSONArray(ArrayList<Student> dataList){
		JSONArray result = new JSONArray();
		if(dataList == null) return result;
		for(Student student : dataList){
			JSONObject obj = new JSONObject();
			obj.put("stdnum", student.getStdnum());
			obj.put("cardID", student.getCardID());
			obj.put("name", student.getName());
			obj.put("password", student.getPassword());
			obj.put("major_id", student.getMajor_id());
			obj.put("grade_id", student.getGrade_id());
			obj.put("phone", student.getPhone());
			obj.put("email", student.getEmail());
			obj.put("qq", student.getQQ());
			obj.put("is_here", student.getIs_here());
			result.add(obj);
			System.out.println(obj.toString());
		}
		return result;
	}
	
	public String execute(){
		System.out.println(studentInfo.toString());
		ArrayList<Student> dataList = null;
		try {
			if(studentInfo == null){
				dataList = ( (StudentDaoProxy) DaoFactory.getDaoInstance(StudentDaoProxy.class)).getStudents(page, pageCount);
			}
			else{
				dataList = ( (StudentDaoProxy) DaoFactory.getDaoInstance(StudentDaoProxy.class)).getStudents(studentInfo, page, pageCount);
			}
			int sz = 0;
			if(studentInfo == null){
				sz = ( (StudentDaoProxy) DaoFactory.getDaoInstance(StudentDaoProxy.class)).getStudentsSize() + pageCount - 1;
			}
			else{
				sz = ( (StudentDaoProxy) DaoFactory.getDaoInstance(StudentDaoProxy.class)).getStudentsSize(studentInfo) + pageCount - 1;
			}
			setMaxPage(sz / pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonData = getJSONArray(dataList);
		setResult(jsonData);
        // page= page.getDatas();  
		return SUCCESS;
	}
}

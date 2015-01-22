package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.GradeDaoProxy;
import com.zml.dao.proxy.MajorDaoProxy;
import com.zml.dao.proxy.StudentDaoProxy;
import com.zml.model.Student;

public class UserInfoAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private int page = 1;
	private int pageCount = 10;
	private Student studentInfo = null;
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(StudentDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Student getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(Student studentInfo) {
		this.studentInfo = studentInfo;
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
	
	public String getStudentsInfoAction(){
		//System.out.println(studentInfo.toString());
		ArrayList<Student> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			int sz = 0;
			if(studentInfo == null){
				dataList = ((StudentDaoProxy) daoProxy).getStudents(page, pageCount);
				sz = ((StudentDaoProxy) daoProxy).getStudentsSize() + pageCount - 1;
			}
			else{
				dataList = ((StudentDaoProxy) daoProxy).getStudents(studentInfo, page, pageCount);
				sz = ((StudentDaoProxy) daoProxy).getStudentsSize(studentInfo) + pageCount - 1;
			}
			resultMsg.put("maxPage", (sz + pageCount - 1) / pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
        // page= page.getDatas();  
		return SUCCESS;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean matchPattern(String patternString, String matchString){
		return Pattern.matches(patternString, matchString);
	}
	
	boolean checkStdnum(String stdnum) throws Exception{
		if(stdnum == null)
			return false;
		if(((StudentDaoProxy)daoProxy).getPasswordFromStdnum(stdnum) != null)
			return false;
		return matchPattern("^[0-9]{8,9}$", stdnum);
	}
	
	boolean checkCardID(String cardID){
		if(cardID == null) return false;
		return matchPattern("^[0-9A-Z]{8}$", cardID);
	}
	
	boolean checkName(String name){
		System.out.println(name);
		if(name == null) return false;
		return matchPattern("^[\\u4e00-\\u9fa5|a-z]{1,10}$", name);
	}
	
	boolean checkMajor(int major_id) throws Exception{
		if(((MajorDaoProxy) DaoFactory.getDaoInstance(MajorDaoProxy.class)).getNameFromID(major_id) == null)
			return false;
		return true;
	}
	
	boolean checkGrade(int grade_id) throws Exception{
		if(((GradeDaoProxy) DaoFactory.getDaoInstance(GradeDaoProxy.class)).getNameFromID(grade_id) == null)
			return false;
		return true;
	}
	
	boolean checkPhone(String phone) {
		if(phone == null) return false;
		return matchPattern("^[0-9]{11,13}$", phone);
	}
	
	boolean checkEmail(String email){
		if(email == null) return false;
		return matchPattern("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", email);
	}
	
	boolean checkQQ(String qq){
		if(qq == null) return false;
		return matchPattern("^[0-9]{6,11}$", qq);
	}
	
	boolean checkPassword(String password){
		if(password == null) return false;
		return matchPattern("^[\\w]{6,100}$", password);
	}
	
	boolean checkStudentInfo(Student studentInfo) throws Exception{
		if(checkStdnum(studentInfo.getStdnum()) == false){
			resultMsg.put("result","学号已经注册");
			return false;
		}
		if(checkCardID(studentInfo.getCardID()) == false){
			resultMsg.put("result","卡号非法");
			return false;
		}
		if(checkName(studentInfo.getName()) == false){
			resultMsg.put("result","姓名不合法");
			return false;
		}
		if(checkMajor(studentInfo.getMajor_id()) == false){
			resultMsg.put("result","专业不合法");
			return false;
		}
		if(checkGrade(studentInfo.getGrade_id()) == false){
			resultMsg.put("result","年级不合法");
			return false;
		}
		if(checkPhone(studentInfo.getPhone()) == false){
			resultMsg.put("result","电话不合法");
			return false;
		}
		if(checkEmail(studentInfo.getEmail()) == false){
			resultMsg.put("result","邮箱不合法");
			return false;
		}
		if(checkQQ(studentInfo.getQQ()) == false){
			resultMsg.put("result","QQ不合法");
			return false;
		}
		if(checkPassword(studentInfo.getPassword()) == false){
			resultMsg.put("result","密码长度不合法");
			return false;
		}
		return true;
	}
	
	public String checkStudentRegisterInfoAction(){
		System.out.println("尝试插入数据：：" + studentInfo.toString());
		resultMsg = new HashMap<String, Object>();
		resultMsg.put("result","true");
		try {
			if(checkStudentInfo(getStudentInfo())){
				if(((StudentDaoProxy)daoProxy).doCreate(getStudentInfo()) == false){
					resultMsg.put("result","数据库错误");
				}
			}
		} catch (Exception e) {
			resultMsg.put("result","数据库错误");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getStudentInfoFromStdnumAction(){
		System.out.println("stdnum : " + studentInfo.getStdnum());
		resultMsg = new HashMap<String, Object>();
		if(studentInfo.getStdnum() == null) 
			return SUCCESS;
		Student data = null;
		try {
			data = ((StudentDaoProxy)daoProxy).getStudentInfoFromStdnum(studentInfo.getStdnum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMsg.put("result",data);
		return SUCCESS;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String delStudent() {
		System.out.println(studentInfo.getStdnum());
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		if(studentInfo.getStdnum() == null) {
			return SUCCESS;
		}
		try {
			result = ((StudentDaoProxy)daoProxy).delStudent(studentInfo.getStdnum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	public String updateStudent() {
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		if (studentInfo == null) {
			return SUCCESS;
		}
		try {
			result = ((StudentDaoProxy) daoProxy).updateStudent(studentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
}

package cn.edu.dlut.chuangxin.action;

import java.util.regex.Pattern;

import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.GradeDaoProxy;
import cn.edu.dlut.chuangxin.dao.proxy.MajorDaoProxy;
import cn.edu.dlut.chuangxin.dao.proxy.StudentDaoProxy;
import cn.edu.dlut.chuangxin.model.Student;

import com.opensymphony.xwork2.ActionSupport;

public class CheckStudentRegisterInfoAction extends ActionSupport{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Student studentInfo = null;
	private String result = null;
	
	public Student getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(Student studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	private boolean matchPattern(String patternString, String matchString){
		return Pattern.matches(patternString, matchString);
	}
	
	boolean checkStdnum(String stdnum) throws Exception{
		if(stdnum == null)
			return false;
		if(((StudentDaoProxy) DaoFactory.getDaoInstance(StudentDaoProxy.class)).getPasswordFromStdnum(stdnum) != null)
			return false;
		return matchPattern("^[0-9]{8,9}$", stdnum);
	}
	
	boolean checkCardID(String cardID){
		if(cardID == null) return false;
		return matchPattern("^[0-9A-Z]{8}$", cardID);
	}
	
	boolean checkName(String name){
		if(name == null) return false;
		return matchPattern("^[\\u4e00-\\u9fa5]{1,10}$", name);
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
			setResult("学号已经注册");
			return false;
		}
		if(checkCardID(studentInfo.getCardID()) == false){
			setResult("卡号非法");
			return false;
		}
		if(checkName(studentInfo.getName()) == false){
			setResult("姓名不合法");
			return false;
		}
		if(checkMajor(studentInfo.getMajor_id()) == false){
			setResult("专业不合法");
			return false;
		}
		if(checkGrade(studentInfo.getGrade_id()) == false){
			setResult("年级不合法");
			return false;
		}
		if(checkPhone(studentInfo.getPhone()) == false){
			setResult("电话不合法");
			return false;
		}
		if(checkEmail(studentInfo.getEmail()) == false){
			setResult("邮箱不合法");
			return false;
		}
		if(checkQQ(studentInfo.getQQ()) == false){
			setResult("QQ不合法");
			return false;
		}
		if(checkPassword(studentInfo.getPassword()) == false){
			setResult("密码长度不合法");
			return false;
		}
		return true;
	}
	
	public String execute(){
		System.out.println("尝试插入数据：：" + studentInfo.toString());
		setResult("OK");
		try {
			if(checkStudentInfo(getStudentInfo())){
				if(((StudentDaoProxy)DaoFactory.getDaoInstance(StudentDaoProxy.class)).doCreate(getStudentInfo()) == false){
					setResult("数据库错误");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			setResult("数据库错误");
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}

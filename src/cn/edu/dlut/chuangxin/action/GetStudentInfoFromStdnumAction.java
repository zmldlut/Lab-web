package cn.edu.dlut.chuangxin.action;

import net.sf.json.JSONObject;
import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.StudentDaoProxy;
import cn.edu.dlut.chuangxin.model.Student;

import com.opensymphony.xwork2.ActionSupport;

public class GetStudentInfoFromStdnumAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private JSONObject result = new JSONObject();
	private String stdnum;
	
	public String getStdnum() {
		return stdnum;
	}

	public void setStdnum(String stdnum) {
		this.stdnum = stdnum;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	private JSONObject getJSONObject(Student data){
		if(data == null) return result;
		JSONObject obj = new JSONObject();
		obj.put("stdnum", data.getStdnum());
		obj.put("cardID", data.getCardID());
		obj.put("name", data.getName());
		obj.put("password", data.getPassword());
		obj.put("major_id", data.getMajor_id());
		obj.put("grade_id", data.getGrade_id());
		obj.put("phone", data.getPhone());
		obj.put("email", data.getEmail());
		obj.put("qq", data.getQQ());
		obj.put("is_here", data.getIs_here());
		System.out.println(obj.toString());
		return obj;
	}
	
	public String execute(){
		System.out.println("stdnum : " + stdnum);
		if(stdnum == null) return SUCCESS;
		Student data = null;
		try {
			data = ( (StudentDaoProxy) DaoFactory.getDaoInstance(StudentDaoProxy.class)).getStudentInfoFromStdnum(stdnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonData = getJSONObject(data);
		setResult(jsonData);
        // page= page.getDatas();  
		return SUCCESS;
	}
}

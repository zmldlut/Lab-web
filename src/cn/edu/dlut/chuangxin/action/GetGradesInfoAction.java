package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.model.Grade;

import com.opensymphony.xwork2.ActionSupport;

public class GetGradesInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private JSONArray result = null;
	
	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	private JSONArray getJSONArray(ArrayList<Grade> dataList){
		JSONArray result = new JSONArray();
		if(dataList == null) return result;
		for(Grade grade : dataList){
			JSONObject obj = new JSONObject();
			obj.put("id", grade.getId());	
			obj.put("grade_name", grade.getGrade_name());
			result.add(obj);
			System.out.println(obj.toString());
		}
		return result;
	}
	
	public String execute(){
		ArrayList<Grade> dataList = null;
		try {
			dataList = (DaoFactory.getGradeDaoInstance().getGrades());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonData = getJSONArray(dataList);
		setResult(jsonData);
		return SUCCESS;
	}
}

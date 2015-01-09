package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.MajorDaoProxy;
import cn.edu.dlut.chuangxin.model.Major;

import com.opensymphony.xwork2.ActionSupport;

public class GetMajorsInfoAction extends ActionSupport{

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

	private JSONArray getJSONArray(ArrayList<Major> dataList){
		JSONArray result = new JSONArray();
		if(dataList == null) return result;
		for(Major major : dataList){
			JSONObject obj = new JSONObject();
			obj.put("id", major.getId());	
			obj.put("major_name", major.getMajor_name());
			result.add(obj);
			System.out.println(obj.toString());
		}
		return result;
	}
	
	public String execute(){
		ArrayList<Major> dataList = null;
		try {
			dataList = ((MajorDaoProxy) DaoFactory.getDaoInstance(MajorDaoProxy.class)).getMajors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonData = getJSONArray(dataList);
		setResult(jsonData);
		return SUCCESS;
	}
}

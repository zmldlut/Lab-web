package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.GradeDaoProxy;
import com.zml.model.Grade;

public class GradeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(GradeDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String execute(){
		ArrayList<Grade> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			dataList = (((GradeDaoProxy) daoProxy).getGrades());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
		return SUCCESS;
	}
}

package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.MajorDaoProxy;
import cn.edu.dlut.chuangxin.model.Major;

public class MajorAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	public String execute(){
		ArrayList<Major> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			dataList = ((MajorDaoProxy) daoProxy).getMajors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
		return SUCCESS;
	}
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(MajorDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

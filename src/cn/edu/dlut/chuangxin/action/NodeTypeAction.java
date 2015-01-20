package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.NodeTypeDaoProxy;
import cn.edu.dlut.chuangxin.model.NodeType;

public class NodeTypeAction extends BaseAction {
	
	private static final long serialVersionUID = 8774670225255914135L;

	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(NodeTypeDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getNodeTypes(){
		ArrayList<NodeType> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			dataList = (((NodeTypeDaoProxy) daoProxy).getTypes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
		return SUCCESS;
	}
}

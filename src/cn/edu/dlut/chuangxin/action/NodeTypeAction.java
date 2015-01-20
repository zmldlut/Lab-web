package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.NodeTypeDaoProxy;
import com.zml.model.NodeType;

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

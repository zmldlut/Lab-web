package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.NodeTypeDao;
import cn.edu.dlut.chuangxin.dao.impl.NodeTypeDaoImpl;
import cn.edu.dlut.chuangxin.model.NodeType;

public class NodeTypeDaoProxy extends BaseDaoProxy implements NodeTypeDao{
	
	public NodeTypeDaoProxy() {
		super(NodeTypeDaoImpl.class);
	}

	@Override
	public boolean doCreate(NodeType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NodeType findDao(NodeType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NodeType> getTypes() {
		ArrayList<NodeType> result = null;
		result = ((NodeTypeDaoImpl) super.dao).getTypes();
		connPool.returnConnection(conn);
		return result;
	}
}

package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.NodeDao;
import cn.edu.dlut.chuangxin.dao.impl.NodeDaoImpl;
import cn.edu.dlut.chuangxin.model.Node;

public class NodeDaoProxy extends BaseDaoProxy implements NodeDao{
	
	public NodeDaoProxy() {
		super(NodeDaoImpl.class);
	}

	@Override
	public Node findDao(Node obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Node> getNodes(int type, int page, int pageCount) {
		ArrayList<Node> result = null;
		result = ((NodeDaoImpl) super.dao).getNodes(type, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getNodeSize(int type) {
		int result = 0;
		result = ((NodeDaoImpl) super.dao).getNodeSize(type);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Node node) {
		boolean result = false;
		result = ((NodeDaoImpl) super.dao).doCreate(node);
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override
	public boolean delNode(int id) {
		boolean result = false;
		result = ((NodeDaoImpl) super.dao).delNode(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean updateNode(Node node) {
		boolean result = false;
		result = ((NodeDaoImpl) super.dao).updateNode(node);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Node getNode(int id) {
		Node result = new Node();
		result = ((NodeDaoImpl) super.dao).getNode(id);
		connPool.returnConnection(conn);
		return result;
	}
}

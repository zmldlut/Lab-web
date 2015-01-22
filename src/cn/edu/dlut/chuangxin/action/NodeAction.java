package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.NodeDaoProxy;
import com.zml.model.Node;

public class NodeAction extends BaseAction {

	private static final long serialVersionUID = 6891398674378080252L;

	private int type;
	private int page = 1;
	private int pageCount = 10;
	private Node node;
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public String info(){
		return "nodes_info";
	}
	
	public String register(){
		return "nodes_register";
	}
	
	public String success(){
		return "register_success";
	}
	
	public String update(){
		return "nodes_update";
	}

	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(NodeDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getNodes(){
		ArrayList<Node> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			dataList = (((NodeDaoProxy) daoProxy).getNodes(type, page, pageCount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sz = ((NodeDaoProxy) daoProxy).getNodeSize(type);
		resultMsg.put("maxPage", (sz + pageCount - 1) / pageCount);
		resultMsg.put("result", dataList);
		return SUCCESS;
	}
	
	public String getNodeFromId(){
		Node result = new Node();
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((NodeDaoProxy) daoProxy).getNode(node.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	public String addNode(){
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((NodeDaoProxy) daoProxy).doCreate(node));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	public String delNode(){
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((NodeDaoProxy) daoProxy).delNode(node.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	public String updateNode(){
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((NodeDaoProxy) daoProxy).updateNode(node));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
}

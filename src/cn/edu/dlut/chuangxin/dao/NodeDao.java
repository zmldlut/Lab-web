package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.model.Node;

public interface NodeDao extends BaseDao<Node>{
	ArrayList<Node> getNodes(int type, int page, int pageCount);
	int getNodeSize(int type);

	boolean delNode(int id);
	boolean updateNode(Node node);
	Node getNode(int id);
}
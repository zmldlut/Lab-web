package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.model.NodeType;


public interface NodeTypeDao extends BaseDao<NodeType>{
	ArrayList<NodeType> getTypes();
}

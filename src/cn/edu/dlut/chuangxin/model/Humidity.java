package cn.edu.dlut.chuangxin.model;

import java.util.Date;

public class Humidity {
	
	private int id = -1;
	private int node_id = -1;
	private Date acq_time = null;
	private int humidity_value = -1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public Date getAcq_time() {
		return acq_time;
	}
	public void setAcq_time(Date acq_time) {
		this.acq_time = acq_time;
	}
	public int getHumidity_value() {
		return humidity_value;
	}
	public void setHumidity_value(int humidity_value) {
		this.humidity_value = humidity_value;
	}
}

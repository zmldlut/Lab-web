package cn.edu.dlut.chuangxin.model;

import java.util.Date;

import net.sf.json.JSONObject;

public class Temperature {
	
	private int id = -1;
	private int node_id = -1;
	private Date acq_time = null;
	private int temperature_value = -1;
	
	
	
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

	public int getTemperature_value() {
		return temperature_value;
	}

	public void setTemperature_value(int temperature_value) {
		this.temperature_value = temperature_value;
	}

	public String toString(){
		JSONObject obj = new JSONObject();
		obj.put("id", getId());
		obj.put("node_id", getNode_id());
		obj.put("acq_time", getAcq_time().toString());
		obj.put("temperature_value", getTemperature_value());
		return obj.toString();
	}
}

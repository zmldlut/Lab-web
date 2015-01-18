package cn.edu.dlut.chuangxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.edu.dlut.chuangxin.dao.HumidityDao;
import cn.edu.dlut.chuangxin.model.Humidity;

public class HumidityDaoImpl extends BaseDaoImpl implements HumidityDao{

	public HumidityDaoImpl() {}
	
	public HumidityDaoImpl(Connection conn) {
		super.conn = conn;
	}
	
	@Override
	public boolean doCreate(Humidity obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Humidity findDao(Humidity obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Humidity> getHumidity() {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = new ArrayList<Humidity>();
		String sql = "select id,node_id,acq_time,humidity_value from humidity ORDER BY acq_time desc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Humidity Humidity = new Humidity();
				Humidity.setId(rs.getInt(1));
				Humidity.setNode_id(rs.getInt(2));
				Humidity.setAcq_time(rs.getDate(3));
				Humidity.setHumidity_value(rs.getInt(4));
				result.add(Humidity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidity(int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = new ArrayList<Humidity>();
		String sql = "select id,node_id,acq_time,humidity_value from humidity ORDER BY acq_time desc LIMIT ? ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, page * pageCount - pageCount + 1);
			this.pstmt.setInt(2, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Humidity Humidity = new Humidity();
				Humidity.setId(rs.getInt(1));
				Humidity.setNode_id(rs.getInt(2));
				Humidity.setAcq_time(new Date(rs.getDate(3).getTime()) );
				Humidity.setHumidity_value(rs.getInt(4));
				result.add(Humidity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidity(Date start, Date end,
			int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = new ArrayList<Humidity>();
		String sql = "select id,node_id,acq_time,Humidity_value from Humidity " + 
				"where acq_time between ? and ? " + 
				"ORDER BY acq_time desc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setInt(3, page * pageCount - pageCount + 1);
			this.pstmt.setInt(4, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date acq_time = new Date();
				try {
					acq_time = date.parse(date.format((new Date(rs.getDate(3).getTime() + (rs.getTime(3).getTime())))));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Humidity Humidity = new Humidity();
				Humidity.setId(rs.getInt(1));
				Humidity.setNode_id(rs.getInt(2));
				Humidity.setAcq_time(acq_time);
				Humidity.setHumidity_value(rs.getInt(4));
				result.add(Humidity);
			}
			System.out.println(result.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidityFromNodeID(int nodeID,
			int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = new ArrayList<Humidity>();
		String sql = "select id,node_id,acq_time,Humidity_value from humidity where acq_time between ? and ? ORDER BY acq_time desc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, nodeID);
			this.pstmt.setInt(2, page * pageCount - pageCount + 1);
			this.pstmt.setInt(3, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Humidity Humidity = new Humidity();
				Humidity.setId(rs.getInt(1));
				Humidity.setNode_id(rs.getInt(2));
				Humidity.setAcq_time(rs.getDate(3));
				Humidity.setHumidity_value(rs.getInt(4));
				result.add(Humidity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int getHumiditySize() {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select count(*) from humidity";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int getHumiditySize(Date start, Date end) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select count(*) from humidity " + 
				"where UNIX_TIMESTAMP(acq_time) >  UNIX_TIMESTAMP(?) and " + 
				"UNIX_TIMESTAMP(acq_time) < UNIX_TIMESTAMP(?) ";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()) );
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int getHumiditySize(Humidity Humidity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHumiditySizeFromNodeID(int nodeID) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select count(*) from humidity where node_id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, nodeID);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
}

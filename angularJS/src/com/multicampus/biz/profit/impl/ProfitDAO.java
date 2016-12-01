package com.multicampus.biz.profit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.multicampus.biz.profit.vo.ProfitVO;
import com.multicampus.common.JDBCUtils;

public class ProfitDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public HashMap<String, ArrayList<ProfitVO>> profitList(){
		ArrayList<ProfitVO> profitList = null;
		HashMap<String, ArrayList<ProfitVO>> map = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from profit";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			profitList = new ArrayList<ProfitVO>();
			map = new HashMap<String, ArrayList<ProfitVO>>();
			ProfitVO profit = null;
			
			while(rs.next()){
				profit = new ProfitVO();
				profit.setYear(rs.getString("year"));
				profit.setMonth(rs.getString("month"));
				profit.setProfit(rs.getInt("profit"));
				profit.setExpenses(rs.getInt("expenses"));
				profit.setAmount(rs.getInt("amount"));
				profit.setComment(rs.getString("comment"));
				profitList.add(profit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		
		map.put("profit", profitList);
		return map;
	}
	
	public HashMap<String, ArrayList<ProfitVO>> profitYearList(ProfitVO vo){
		ArrayList<ProfitVO> profitList = null;
		HashMap<String, ArrayList<ProfitVO>> map = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from profit where year = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getYear());
			rs = stmt.executeQuery();
			
			profitList = new ArrayList<ProfitVO>();
			map = new HashMap<String, ArrayList<ProfitVO>>();
			ProfitVO profit = null;
			
			while(rs.next()){
				profit = new ProfitVO();
				profit.setYear(rs.getString("year"));
				profit.setMonth(rs.getString("month"));
				profit.setProfit(rs.getInt("profit"));
				profit.setExpenses(rs.getInt("expenses"));
				profit.setAmount(rs.getInt("amount"));
				profit.setComment(rs.getString("comment"));
				profitList.add(profit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		
		map.put("profit", profitList);
		return map;
	}
	
	
	// 여기서 부터는 Test 용. year와 profit의 조건 검출
	public HashMap<String, ArrayList<ProfitVO>> getCall(ProfitVO vo){
		ArrayList<ProfitVO> profitList = null;
		HashMap<String, ArrayList<ProfitVO>> map = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from profit where year = ? and profit >= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getYear());
			stmt.setInt(2, vo.getAmount());
			rs = stmt.executeQuery();
			
			profitList = new ArrayList<ProfitVO>();
			map = new HashMap<String, ArrayList<ProfitVO>>();
			ProfitVO profit = null;
			
			while(rs.next()){
				profit = new ProfitVO();
				profit.setYear(rs.getString("year"));
				profit.setMonth(rs.getString("month"));
				profit.setProfit(rs.getInt("profit"));
				profit.setExpenses(rs.getInt("expenses"));
				profit.setAmount(rs.getInt("amount"));
				profit.setComment(rs.getString("comment"));
				profitList.add(profit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		
		map.put("profit", profitList);
		return map;
	}
}

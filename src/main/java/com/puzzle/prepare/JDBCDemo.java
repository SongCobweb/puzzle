package com.puzzle.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JDBCDemo {
	
	public static final String URL = "jdbc:mysql://192.168.0.225:3306/mdap";
	
	public static final String USERNAME = "root";
	
	public static final String PASSWORD = "root";
	
	public static void main(String[] args) {
		
		List<Map<String, Object>> resultList = new ArrayList<>();
		
		Connection conn = null;
		
		PreparedStatement stmt = null; 
		
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM sys_dict where type like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "sensor_typ%");
			rs = stmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()){
				Map<String, Object> map = new HashMap<>();
				for(int i=0; i <= count - 1; i++){
					String columnName = rsmd.getColumnName(i + 1);
					map.put(columnName, rs.getString(columnName));
				}
				resultList.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs == null){
					rs.close();
				}
				if(stmt == null){
					stmt.close();
				}
				if(conn == null){
					conn.close();
				}
			}catch(Exception e){
				e.getMessage();
			}
		}
		
		if(resultList != null && resultList.size() > 0){
			for(Map<String, Object> resultMap : resultList){
				if(resultMap != null && resultMap.size() > 0){
					for(Entry<String, Object> entry : resultMap.entrySet()){
						System.out.println(entry.getKey() + ":" + entry.getValue());
					}
				}
				System.err.println("================");
			}
		}
	}
	

}

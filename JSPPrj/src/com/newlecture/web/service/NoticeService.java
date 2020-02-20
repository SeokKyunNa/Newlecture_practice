package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {

	public List<Notice> getNoticeList(){
		
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page){
		
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field /*TITLE, WRITER_ID*/, String query/*%A%*/, int page){
		
		List<Notice> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (" + 
				"SELECT ROWNUM NUM, N.* " + 
				"FROM (SELECT * FROM NOTICE WHERE " + field + " LIKE ? ORDER BY REGDATE DESC) N" + 
				") " + 
				"WHERE NUM BETWEEN ? AND ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "tjrrbs89!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page * 10);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){ 
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID"); 
				Date regdate = rs.getDate("REGDATE");
				int hit = rs.getInt("HIT");
				String files = rs.getString("files");
				String content = rs.getString("content");
			
				Notice notice = new Notice(
						id,
						title,
						writerId,
						regdate,
						hit,
						files,
						content
				);
				
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getNoticeCount() {
		
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		String sql = "SELECT COUNT(*) FROM (" + 
				"SELECT ROWNUM NUM, N.* FROM (" + 
				"SELECT * FROM NOTICE ORDER BY REGDATE DESC) N" + 
				") " + 
				"WHERE NUM BETWEEN ? AND ?";
		return 0;
	}
	
	public Notice getNotice(int id) {
		String sql = "SELECT * ROM NOTICE WHERE ID=?";
		return null;
	}
	
	public Notice getNextNotice(int id) {
		String sql = "SELECT * FROM NOTICE " + 
				"WHERE ID = (" + 
				"SELECT ID FROM NOTICE " + 
				"WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID = ?) AND ROWNUM = 1)";
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		String sql = "SELECT ID FROM " + 
				"(SELECT * FROM NOTICE ORDER BY REGDATE DESC) " + 
				"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?) AND ROWNUM = 1";
		return null;
	}
}

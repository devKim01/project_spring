package com.example.productVue.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;




public class PostgresqlBoardRepository {
	private final DataSource dataSource;
	
	public PostgresqlBoardRepository(DataSource dataSource) {
		System.out.println("repo 생성자");
		 this.dataSource = dataSource;
		 }
	
//	@Override
	public List<BoardEntity> dbfindAll() {
		String sql = "select * from board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("repo 시작");
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BoardEntity> members = new ArrayList<>();
			System.out.println("리스트 시작");
			
			while (rs.next()) {
				System.out.println(rs.getLong("idx"));
				
				BoardEntity member = new BoardEntity();
				
				member.setIdx(rs.getLong("idx"));
				member.setTitle(rs.getString("title"));
				member.setContents(rs.getString("contents"));
				member.setAuthor(rs.getString("author"));
				member.setCreatedAt(stringToDateTime(rs.getString("created_at")));
				members.add(member);
			}
			System.out.println("리스트 끝");
			return members;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			System.out.println("repo 끝");
			close(conn, pstmt, rs);
		}
	}
	private Connection getConnection() {
		return DataSourceUtils.getConnection(dataSource);
	}
	private void close(Connection conn) throws SQLException {
		DataSourceUtils.releaseConnection(conn, dataSource);
	}
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				close(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public LocalDateTime stringToDateTime(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime datetime = LocalDateTime.parse(str, formatter);
		return datetime;
	}
}

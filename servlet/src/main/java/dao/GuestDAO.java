package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.GuestDTO;
import dto.StudentDTO;

public class GuestDAO extends JdbcDAO{
	
	private static GuestDAO _dao = new GuestDAO();
	
	private GuestDAO() {
		
	}
	
	public static GuestDAO getInstacne() {
		return _dao;
	}
	
	// 방명록 게시글정보를 전달받아 Guest 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	
	public int insertGuest(GuestDTO guest) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			String sql = "insert into guest values(guest_seq.nextval,?,?,?,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());                                                                                                                                                                                                                                                                                                                                                                                                       
			
			result = pstmt.executeUpdate();
			
//			if(result > 0) {
//				System.out.println(result + "개 삽입 되었습니다");
//			}
			
			
		} catch(SQLException e) {
			System.out.println("insertGuest 메소드의 실행오류 = " + e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
	
	// 방명록 게시글정보를 전달받아 Guest 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	
	public int updateGuest(GuestDTO guest) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			String sql = "update guest set writer= ?, subject= ? , content = ? where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());
			pstmt.setInt(4, guest.getNum());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("updateGuest메소드 오류 = " + e.getMessage());
		} finally {
			close(conn, pstmt);
			
		}
		
		

		return result;
	}
	
	public int deleteGuest(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			String sql = "delete from guest where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("updateGuest메소드 오류 = " + e.getMessage());
		} finally {
			close(conn, pstmt);
			
		}
		
		return result;
	}
	
	public GuestDTO selectGuest(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GuestDTO guest = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from guest where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				guest = new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
			}
			
		}catch(SQLException e) {
			e.getMessage();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return guest;
		
	}
	
	public List<GuestDTO> selectGuestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<GuestDTO> guestList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String sql = "select * from guest";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
				
				guestList.add(guest);
			}
			
			
		}catch(SQLException e) {
			System.out.println("selectGuestList 메소드 오류 = " + e.getMessage());
			
		} finally {
			close(conn, pstmt, rs);
		}
		return guestList;
	}
	
	
}

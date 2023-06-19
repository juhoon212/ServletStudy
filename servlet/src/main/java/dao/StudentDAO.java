package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import dto.StudentDTO;

public class StudentDAO extends JdbcDAO{
	
	private static StudentDAO studentDAO = new StudentDAO();
	
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		return studentDAO;
	}
	
	// Student 테이블에 저장된 모든 학생정보를 검색
	
	
	public List<StudentDTO> selectStudentList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDTO> studentList = new ArrayList<>();
		try {
			conn = getConnection();
			
			String sql = "select * from student order by no";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setNo(rs.getInt("no"));
				studentDTO.setName(rs.getString("name"));
				studentDTO.setPhone(rs.getString("phone"));
				studentDTO.setAddress(rs.getString("address"));
				studentDTO.setDate(rs.getString("birthday"));
				
				studentList.add(studentDTO);
			}
		}catch(SQLException e) {
			System.out.println("[에러] selectStudentList 메소드의 SQL오류 = " + e.getMessage());
		} finally {
			close(conn, pstmt, rs);
		}
		
		return studentList;
	}
}

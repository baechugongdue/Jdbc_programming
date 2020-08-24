package Jdbc_programming.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import Jdbc_programming.conn.JdbcUtil;
import Jdbc_programming.dao.TitleDao;
import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Employee;
import Jdbc_programming.dto.Title;

public class TitleDaoImpl implements TitleDao {
	private static final TitleDaoImpl instance = new TitleDaoImpl();

	// 싱글 턴 패턴
	// 외부에서 호출 못하게 private으로 바꿈
	private TitleDaoImpl() {

	}

	public static TitleDaoImpl getInstance() {
		return instance;
	}

	//
	@Override
	public List<Title> selectTitleByAll() {
		// 1번
		String sql = "SELECT TITLE_NO, TITLE_NAME FROM TITLE";
		// 2번
		try (Connection con = JdbcUtil.getConnection();) {
			// 4번
			PreparedStatement pstmt = con.prepareStatement(sql);
			{
				ResultSet rs = pstmt.executeQuery(); // 쿼리가 끝나고 res로 받았다
				if (rs.next()) {
					List<Title> list = new ArrayList<Title>();
					do {
						list.add(getTitle(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			// 3번
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "SELECT TITLE_NO, TITLE_NAME FROM TITLE WHERE TITLE_NO = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, title.getNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getTitle(rs);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		String sql = "INSERT INTO TITLE values(?,?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, title.getNo());
			pstmt.setString(2, title.getName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "UPDATE TITLE SET TITLE_NAME = ? WHERE TITLE_NO=? ";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title.getName());
			pstmt.setInt(2, title.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteTitle(Title title) {
		String sql = "DELETE FROM TITLE WHERE TITLE_NO = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, title.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int no = rs.getInt("TITLE_NO");
		String name = rs.getString("TITLE_NAME");
		return new Title(no, name);
	}
	
	public Title selectSameTitleEmployeeByTitleNo(Title title) {
		String sql = " SELECT TITLE_NO, TITLE_NAME, EMP_NO, EMP_NAME, E.DNO " + 
				        "  FROM TITLE T JOIN EMPLOYEE E ON T.TITLE_NO=E.TNO " + 
				        " WHERE TNO=?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			    pstmt.setInt(1, title.getNo());
			    try(ResultSet rs = pstmt.executeQuery()){
			    	if(rs.next()) {
			    		Title item = getTitle(rs);
			    		if(rs.getInt("EMP_NO")!=0) {
			    			List<Employee> list =  new ArrayList<>();
			    			do {
			    				list.add(getEmployee(rs));
			    			}while(rs.next());
			    			item.setList(list);
			    		}
			    		return item;
			    	}
			    }
			    	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return title;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setNo(rs.getInt("EMP_NO"));
		emp.setName(rs.getString("EMP_NAME"));
		emp.setDno(new Department(rs.getInt("DNO")));
		return emp;
	}

}

package Jdbc_programming.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import Jdbc_programming.conn.JdbcUtil;
import Jdbc_programming.conn.JdbcUtilTest;
import Jdbc_programming.dao.DepartmentDao;
import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Title;

public class DepartmentDaoImpl implements DepartmentDao {
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	private DepartmentDaoImpl() {

	}

	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	public List<Department> selectDepartmentByAll() {
		String sql = "SELECT DEPT_NO, DEPT_NAME, FLOOR FROM DEPARTMENT";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				List<Department> list = new ArrayList<Department>();
				do {
					list.add(getDepartment(res));
				} while (res.next());
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Department selectDepartmentByNo(Department department) {
		String sql = "SELECT DEPT_NO, DEPT_NAME, FLOOR FROM DEPARTMENT WHERE DEPT_NO=?";
		try(Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, department.getNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public int insertDepartment(Department department) {
		String sql = "INSERT INTO DEPARTMENT VALUES(?,?,?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, department.getNo());
			pstmt.setString(2, department.getName());
			pstmt.setInt(3, department.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateDepartment(Department department) {
		String sql = "UPDATE DEPARTMENT SET DEPT_NAME = ? WHERE DEPT_NO=? ";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, department.getName());
			pstmt.setInt(2, department.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteDepartment(Department department) {
		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_NO = ?";
		try(Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, department.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Department getDepartment(ResultSet res) throws SQLException {
		int no = res.getInt("DEPT_NO");
		String name = res.getString("DEPT_NAME");
		int floor = res.getInt("FLOOR");
		return new Department(no, name, floor);
	}

	@Override
	public Title selectSameTitleEmployeeByTitleNo(Title title) {
		// TODO Auto-generated method stub
		return null;
	}
}

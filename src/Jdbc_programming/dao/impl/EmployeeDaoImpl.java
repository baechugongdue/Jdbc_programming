package Jdbc_programming.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import Jdbc_programming.conn.JdbcUtil;
import Jdbc_programming.dao.EmployeeDao;
import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Employee;
import Jdbc_programming.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	private EmployeeDaoImpl(){
			
	}
	public static EmployeeDaoImpl getinstance() {
		return instance;
	}
	
	@Override
	public List<Employee> SelectEmployeeByAll() {
		String sql = "SELECT EMP_NO, EMP_NAME, MANAGER, MGR_NAME, SALARY, TNO, TITLE_NAME, DNO, DEPT_NAME, FLOOR FROM VW_EMPLOYEE";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery()){
			if(res.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(res));
				}while(res.next());
				return list;
			}
	} catch (SQLException e) {
		e.printStackTrace();
			throw new RuntimeException(e);
	}
		return null; 		
	}
	
	@Override
	public Employee SelectEmployeeByNo(Employee emp) {
		String sql = "SELECT EMP_NO, EMP_NAME, MANAGER, MGR_NAME, SALARY, TNO, TITLE_NAME, DNO, DEPT_NAME, FLOOR FROM VW_EMPLOYEE WHERE EMP_NO = ?";
		try(Connection con = JdbcUtil.getConnection();PreparedStatement pstmt =con.prepareStatement(sql);){
			pstmt.setInt(1, emp.getNo());
			try(ResultSet res = pstmt.executeQuery()){
				if(res.next()) {
					return getEmployee(res);
				}
			}
		}
		 catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	@Override
	public int insertEmployee(Employee emp) {
		String sql ="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
		try(Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, emp.getNo());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(4, emp.getManager().getNo());
			pstmt.setInt(5,emp.getSalary());
			pstmt.setInt(3, emp.getTno().getNo());
			pstmt.setInt(6, emp.getDno().getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//sreturn 0;
	}
	@Override
	public int updateEmployee(Employee emp) {
		String sql = "UPDATE EMPLOYEE SET EMP_NAME = ?,TNO=?,MANAGER=?,SALARY=?,DNO=? WHERE EMP_NO=?";
		try(Connection con=JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(6, emp.getNo());
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getTno().getNo());
			pstmt.setInt(3, emp.getManager().getNo());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setInt(5, emp.getDno().getNo());
			return pstmt.executeUpdate();
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		 }
	}
	@Override
	public int deleteEmployee(Employee emp) {
		String sql = "DELETE FROM employee WHERE emp_no= ?";
		try(Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return 0;
	}
	private Employee getEmployee(ResultSet res) throws SQLException {
		// String sql = "SELECT EMP_NO, EMP_NAME,MANAGER, MGR_NAME,
		// SALARY, TNO, TITLE_NAME, DNO, DEPT_NAME, FLOOR FROM VW_EMPLOYEE";
		
		int no = res.getInt("EMP_NO");
		String name = res.getString("EMP_NAME");
		
		Title tno = new Title(res.getInt("TNO"));
		tno.setName(res.getString("TITLE_NAME"));
		
		Employee manager = new Employee(res.getInt("MANAGER"));
		manager.setName(res.getString("MGR_NAME"));
		
		int salary = res.getInt("SALARY");
		Department dno = new Department(res.getInt("DNO"));
		dno.setName(res.getString("DEPT_NAME"));
		dno.setFloor(res.getInt("FLOOR"));
		
		return new Employee(no, name, tno, manager, salary, dno);
	}
}

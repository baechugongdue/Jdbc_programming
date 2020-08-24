package Jdbc_programming.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Jdbc_programming.conn.JdbcUtil;
import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Title;

public class TransactionService {
	
	// 직책, 부서 추가
	public void transAddTitleAndDepartment(Title title, Department department) {
		String tSql = "INSERT INTO TITLE values(?,?)";
		String dSql = "INSERT INTO DEPARTMENT VALUES(?,?,?)";
		Connection con = null; // 마지막
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false); // 롤백이 안되게 오토 커밋 안함
			System.out.println(con.getAutoCommit());
			try (PreparedStatement tpstmt = con.prepareStatement(tSql)) {
				tpstmt.setInt(1, title.getNo());
				tpstmt.setString(2, title.getName());
				tpstmt.executeUpdate();
			}
			try (PreparedStatement dpstmt = con.prepareStatement(dSql)) {
				dpstmt.setInt(1, department.getNo());
				dpstmt.setString(2, department.getName());
				dpstmt.setInt(3, department.getFloor());
				dpstmt.executeUpdate();

				// System.out.println("예외발생");
				// throw new SQLException("예외 발생 되었음");
			}
			con.commit();
			con.setAutoCommit(true);
			System.out.println(con.getAutoCommit());
		} catch (SQLException e) {
			System.out.println("rollback");
			processRollback(con, e);
		}
	}

	// 직책, 부서 삭제
	public void transRemoveTitleAndDepartment(Title title, Department department) {
		String dSql = "DELETE FROM DEPARTMENT WHERE DEPT_NO = ?";
		String TSql = "DELETE FROM TITLE WHERE TITLE_NO = ?";
		Connection con = null; // 마지막
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false); // 롤백이 안되게 오토 커밋 안함
			System.out.println(con.getAutoCommit());
			try (PreparedStatement tpstmt = con.prepareStatement(TSql)) {
				tpstmt.setInt(1, title.getNo());
				tpstmt.executeUpdate();
			}
			try (PreparedStatement dpstmt = con.prepareStatement(dSql)) {
				dpstmt.setInt(1, department.getNo());
				dpstmt.setString(2, department.getName());
				dpstmt.executeUpdate();

				// System.out.println("예외발생");
				// throw new SQLException("예외 발생 되었음");
			}
			con.commit();
			con.setAutoCommit(true);
			System.out.println(con.getAutoCommit());
		} catch (SQLException e) {
			System.out.println("rollback");
			processRollback(con, e);
		}
	}

	private void processRollback(Connection con, SQLException e) {
		try {
			con.rollback();
			con.setAutoCommit(true);
			System.out.println(con.getAutoCommit());
		} catch (SQLException ee) {
			throw new RuntimeException(ee);
		}
		;
		throw new RuntimeException(e);
	}
}

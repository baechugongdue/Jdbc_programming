package Jdbc_programming.dao;

import java.util.List;

import Jdbc_programming.dto.Employee;
import Jdbc_programming.dto.Title;

public interface EmployeeDao {
	List<Employee> SelectEmployeeByAll();
	Employee SelectEmployeeByNo(Employee emp);
	int insertEmployee(Employee emp);
	int updateEmployee(Employee emp);
	int deleteEmployee(Employee emp);
}

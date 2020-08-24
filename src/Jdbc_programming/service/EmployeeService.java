package Jdbc_programming.service;

import java.util.List;

import Jdbc_programming.dao.EmployeeDao;
import Jdbc_programming.dao.impl.EmployeeDaoImpl;
import Jdbc_programming.dto.Employee;

public class EmployeeService {
	private EmployeeDao dao = EmployeeDaoImpl.getinstance();
	
	public List<Employee> getEmployeeList() {
		return dao.SelectEmployeeByAll();
	}
}

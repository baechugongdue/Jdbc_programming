package Jdbc_programming.dao;

import java.util.List;

import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Title;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
	Department selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	
	int updateDepartment(Department department);
	
	int deleteDepartment(Department department);
	
	Title selectSameTitleEmployeeByTitleNo(Title title);
	}


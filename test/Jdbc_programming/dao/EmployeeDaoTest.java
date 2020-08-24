package Jdbc_programming.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Jdbc_programming.dao.impl.EmployeeDaoImpl;
import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Employee;
import Jdbc_programming.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private EmployeeDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = EmployeeDaoImpl.getinstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testSelectEmployeeByAll() {
		System.out.printf("%s()%n","testselectEmployeeByAll");
		List<Employee> list = dao.SelectEmployeeByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectEmployeeByNo() {
		System.out.printf("%s()%n","testSelectEmployeeByNo");
		Employee selectEmp = dao.SelectEmployeeByNo(new Employee(1003));
		Assert.assertNotNull(selectEmp);
		System.out.println(selectEmp);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n","testInsertEmployee");
		Employee newEmp = new Employee(1000,"배규리",new Title(3),new Employee(4377),5000000,new Department(2));
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		System.out.println(newEmp);
	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n","testUpdateEmployee");
		Employee updatedEmp = new Employee(1000,"배규리",new Title(2),new Employee(4377),5000000,new Department(1));
		int res = dao.updateEmployee(updatedEmp);
		Assert.assertEquals(1, res);
		System.out.println(updatedEmp);
	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf("%s()%n","testDeleteEmployee");
	}

}

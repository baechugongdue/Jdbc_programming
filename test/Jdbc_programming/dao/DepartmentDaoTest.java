package Jdbc_programming.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Jdbc_programming.dao.impl.DepartmentDaoImpl;
import Jdbc_programming.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	private DepartmentDao dao;

	@Before
	public void setUp() throws Exception {
		dao = DepartmentDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testSelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectdepartment");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectDepartmentByNo() {
		System.out.printf("testSelectDepartmentByNo");
		Department selectDepartment = dao.selectDepartmentByNo(new Department(4));
		Assert.assertNotNull(selectDepartment);
		System.out.println(selectDepartment);
	}

	@Test
	public void test01InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department newDepartment = new Department(5, "인사", 8);
		int res = dao.insertDepartment(newDepartment);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateDepartment() {
		System.out.printf("%s()%n", "testUpdate");
		Department updateDepartment = new Department(5, "안녕", 8);
		int res = dao.updateDepartment(updateDepartment);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03DeleteDepartment() {
		System.out.printf("%s()%n", "testDelete");
		Department DeleteDepartment = new Department(5);
		int res = dao.deleteDepartment(DeleteDepartment);
		Assert.assertEquals(1, res);
	}

}

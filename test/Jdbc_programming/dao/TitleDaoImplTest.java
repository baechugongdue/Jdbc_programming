package Jdbc_programming.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Jdbc_programming.dao.impl.TitleDaoImpl;
import Jdbc_programming.dto.Employee;
import Jdbc_programming.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoImplTest {
	private TitleDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = TitleDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test04SelectTitleByAll() {
			System.out.printf("%s()%n","testSelectTitleByAll");
			List<Title> list = dao.selectTitleByAll();
		      Assert.assertNotNull(list);
			list.stream().forEach(System.out::println);
	}

	@Test
	public void test05SelectTitleByNo() {
		System.out.printf("%s()%n","testSelectTitleByNo");
		Title selectTitle = dao.selectTitleByNo(new Title(5));
		Assert.assertNotNull(selectTitle);
		System.out.println(selectTitle);
	}

	@Test
	public void test01InsertTitle() {
		System.out.printf("%s()%n","testInsertTitle");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateTitle() {
		System.out.printf("%s()%n","testUpdateTitle");
		Title updateTitle = new Title(6, "계약직");
		int res = dao.updateTitle(updateTitle);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03DeleteTitle() {
		System.out.printf("%s()%n","testDeleteTitle");
		Title DeleteTitle = new Title(6);
		int res = dao.deleteTitle(DeleteTitle);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void test06selectSameTitleEmployeeByTitleNo() {
		System.out.printf("%s()%n","selectSameTitleEmployeeByTitleNo");
		Title title3 =dao.selectSameTitleEmployeeByTitleNo(new Title(3));
		List<Employee> list = title3.getList();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

}

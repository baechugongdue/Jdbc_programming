package Jdbc_programming.conn;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class JdbcUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");

	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp()");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown()");

	}

	@Test
	public void testGetConnection() {
		System.out.println("testGetConnection()");
		Connection con  = JdbcUtil.getConnection();
		System.out.println(con);
		Assert.assertNotNull(con);
		fail("Not yet implemented");
	}
	/*
	 * @Test public void testGetConnection2() {
	 * System.out.println("testGetConnection2()"); fail("Not yet implemented"); }
	 */

}

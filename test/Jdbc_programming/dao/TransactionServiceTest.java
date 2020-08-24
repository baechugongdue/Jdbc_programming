package Jdbc_programming.dao;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Jdbc_programming.dto.Department;
import Jdbc_programming.dto.Title;
import Jdbc_programming.service.TransactionService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {
   private static TransactionService service;
   
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      service = new TransactionService();
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception {
      service = null;
   }

   @Test(expected = RuntimeException.class)
   public void test01TransAddTitleAndDepartment() {
      System.out.printf("%s() fail(Title) %n", "test01TransAddTitleAndDepartment");
      Title title = new Title(1, "인턴"); //예외발생
      Department dept = new Department(6, "마케팅", 20);
      
      service.transAddTitleAndDepartment(title, dept);
      
   }
   
   @Test(expected = RuntimeException.class)
   public void test02TransAddTitleAndDepartment() {
      System.out.printf("%s() fail(Department) %n", "test02TransAddTitleAndDepartment");
      Title title = new Title(6, "인턴");
      Department dept = new Department(1, "마케팅", 20); //예외발생      
      service.transAddTitleAndDepartment(title, dept);
     
   }
  
   @Test
   public void test03TransAddTitleAndDepartment() {
      System.out.printf("%s() success %n", "test03TransAddTitleAndDepartment");
      Title title = new Title(6, "인턴");
      Department dept = new Department(5, "마케팅", 20); 
      service.transAddTitleAndDepartment(title, dept);
      
   }

   @Test
   public void test04TransRemoveTitleAndDepartment() {
      System.out.printf("%s()%n", "test04TransRemoveTitleAndDepartment");
      Title title = new Title(6);
      Department department = new Department(5, "마케팅", 20);
   }

}
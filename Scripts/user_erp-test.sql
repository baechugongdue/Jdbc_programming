-- 접속한 계정의 테이블 목록 조회
SELECT TABLE_NAME
  FROM USER_TABLES;

-- 접속한 계정의 테이블별 컬럼 조회
SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_PRECISION, DATA_LENGTH, NULLABLE, DATA_DEFAULT
  FROM USER_TAB_COLUMNS
 WHERE TABLE_NAME IN ('EMPLOYEE', 'DEPARTMENT', 'TITLE');

-- 접속한 계정의 테이블별 제약조건 조회
SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION, DELETE_RULE
  FROM USER_CONSTRAINTS
 WHERE TABLE_NAME IN ('EMPLOYEE', 'DEPARTMENT', 'TITLE');
 
SELECT * FROM DEPARTMENT;
SELECT * FROM TITLE;
SELECT * FROM EMPLOYEE;

SELECT DEPT_NO, DEPT_NAME, FLOOR FROM DEPARTMENT;
INSERT INTO DEPARTMENT VALUES(5,'똥',6);
UPDATE DEPARTMENT SET DEPT_NAME = '하이' WHERE DEPT_NO=5;
DELETE FROM DEPARTMENT WHERE DEPT_NO = 5;
SELECT DEPT_NO, DEPT_NAME, FLOOR FROM DEPARTMENT WHERE DEPT_NO=4;
----
SELECT TITLE_NO, TITLE_NAME FROM TITLE;

INSERT INTO TITLE values(6,'인턴');
DELETE FROM TITLE WHERE TITLE_NO = 6;

UPDATE title SET title_name = '계약직' WHERE title_no=6;

SELECT * FROM EMPLOYEE E JOIN TITLE T ON E.TNO = T.TITLE_NO
JOIN DEPARTMENT D ON E.DNO = D.DEPT_NO;

---같은 직책에 속하는 사원
SELECT TITLE_NO, TITLE_NAME, EMP_NO, EMP_NAME, E.DNO
FROM TITLE T JOIN EMPLOYEE E ON T.TITLE_NO=E.TNO
WHERE TNO=3;

SELECT * FROM department;

UPDATE EMPLOYEE

SELECT * FROM EMPLOYEE e;
DELETE FROM TITLE;
SELECT * FROM TITLE t ;

DELETE EMPLOYEE;

--EmployeeDao 작업
-- EMPLOYEE 작업
DROP VIEW VW_EMPLOYEE;

CREATE OR REPLACE VIEW VW_EMPLOYEE
(EMP_NO, EMP_NAME, TNO, TITLE_NAME,
MANAGER, MGR_NAME, SALARY, 
DNO, DEPT_NAME, FLOOR) 
AS 
SELECT e.EMP_NO, e.EMP_NAME, e.TNO, t.TITLE_NAME, m.EMP_NO, m.EMP_NAME, E.SALARY, D.DEPT_NO, D.DEPT_NAME, D.FLOOR
FROM EMPLOYEE e JOIN TITLE t ON e.TNO = t.TITLE_NO
LEFT OUTER JOIN EMPLOYEE m ON e.MANAGER = m.EMP_NO
JOIN DEPARTMENT d ON e.DNO = d.DEPT_NO;

SELECT EMP_NO, EMP_NAME, MANAGER, MGR_NAME, SALARY, TNO, TITLE_NAME, DNO, DEPT_NAME, FLOOR FROM VW_EMPLOYEE WHERE EMP_NO = 4377;
SELECT * FROM employee;

DELETE FROM employee WHERE emp_no=1000;
UPDATE EMPLOYEE SET EMP_NAME = '배성덕',TNO=2,MANAGER=3011,SALARY=5000000,DNO=4 WHERE EMP_NO=1000;

INSERT INTO EMPLOYEE VALUES(1004,'박규영',5,1003,2000000,3);
INSERT INTO DEPARTMENT 

SELECT * FROM VW_EMPLOYEE;

SELECT EMP_NO, EMP_NAME, MANAGER, SALARY, TNO, DNO FROM VW_EMPLOYEE;
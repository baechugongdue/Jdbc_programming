-- ERP 사용자 생성하기
CREATE USER USER_ERP IDENTIFIED BY rootroot;

-- GRANT 명령으로 접속, 사용 권한 주기
GRANT CONNECT, RESOURCE, CREATE VIEW TO USER_ERP;

-- ERP 사용자 확인
SELECT 
   username,
   default_tablespace,
   profile,
   authentication_type
  FROM
     dba_users
 WHERE
    USERNAME = 'USER_ERP';
  
 
 
    
    
    
  

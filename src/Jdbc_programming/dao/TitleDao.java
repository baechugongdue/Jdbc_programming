package Jdbc_programming.dao;

import java.util.List;

import Jdbc_programming.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	
	Title selectTitleByNo(Title title);
	
	int insertTitle(Title title);
	
	int updateTitle(Title title);
	
	int deleteTitle(Title title);

	Title selectSameTitleEmployeeByTitleNo(Title title);
	
	//같은 직책 속해있는 사원 
	
	
}

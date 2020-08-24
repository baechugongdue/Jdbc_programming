package Jdbc_programming.service;

import java.util.List;

import Jdbc_programming.dao.TitleDao;
import Jdbc_programming.dao.impl.TitleDaoImpl;
import Jdbc_programming.dto.Title;

public class TitleService {
	private TitleDao dao = TitleDaoImpl.getInstance();
	
	public void addTitle(Title title) {
		dao.insertTitle(title);
	}
	public List<Title> getTitleList(){
		return dao.selectTitleByAll();
	}
	public void deleteTitle(Title title) {
		dao.deleteTitle(title);
	}
	public void updateTitle(Title title) {
		dao.updateTitle(title);
	}
}

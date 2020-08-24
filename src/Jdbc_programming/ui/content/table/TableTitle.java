package Jdbc_programming.ui.content.table;

import javax.swing.SwingConstants;

import Jdbc_programming.dto.Title;

@SuppressWarnings("serial")
public class TableTitle extends AbstractItemTable<Title> {

	@Override
	Object[] getColName() {
		return new String[] {"직책 번호","직책명"};
		}

	@Override
	Object[] toArray(Title item) {
		return new Object[] {item.getNo(), item.getName()};
	}

	@Override
	void setWidthAndAlign() {
		tableSetWidth(150,200);
		tableCellAign(SwingConstants.CENTER,0,1);
	}

	/*
	 * public void addTitle(Title item) { addRow(item); }
	 * 
	 * public void removeTitle(int item) { removeRow(item);
	 * 
	 * } public void updateTitle(int idx, Title item) { updateRow(idx, item); }
	 */
	
}

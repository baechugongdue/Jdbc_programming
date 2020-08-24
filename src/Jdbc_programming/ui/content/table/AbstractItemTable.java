package Jdbc_programming.ui.content.table;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public abstract class AbstractItemTable<T> extends JTable {
	private CustomModel model;

	public AbstractItemTable() {
		initComponents();
	}

	private void initComponents() {
		setFont(new Font("인터파크고딕 L", Font.PLAIN, 14));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	void loadData(ArrayList<T> itemList) {
		model = new CustomModel(getRows(itemList), getColName());
		setModel(model);
	}

	abstract Object[] getColName();

	Object[][] getRows(ArrayList<T> itemList) {
		Object[][] rows = new Object[itemList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(itemList.get(i));
		}
		return rows;
	}

	abstract Object[] toArray(T item);

	public void setItems(ArrayList<T> itemList) {
		loadData(itemList);

		setWidthAndAlign();

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		setRowSorter(sorter);
	}

	/**
	 * //column width<br>
	 * tableSetWidth(150, 200, 100, 100, 100, 100, 100); <br>
	 * //column alignment<br>
	 * tableCellAign(SwingConstants.CENTER, 0, 1);<br>
	 * tableCellAign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);<br>
	 */
	abstract void setWidthAndAlign();

	void tableCellAign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel tcm = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	void tableSetWidth(int... width) {
		TableColumnModel tcm = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	private class CustomModel extends DefaultTableModel {

		public CustomModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;// 각 셀 수정 불가능하게
		}
	}

	public void addRow(T item) {
		model.addRow(toArray(item));
	}

	public void removeRow(int idx) {
		model.removeRow(idx);
	}

	public void updateRow(int idx, T updateItem) {
		model.removeRow(idx);
		model.insertRow(idx, toArray(updateItem));
	}

}

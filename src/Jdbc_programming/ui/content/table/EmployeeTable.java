package Jdbc_programming.ui.content.table;

import javax.swing.SwingConstants;

import Jdbc_programming.dto.Employee;

@SuppressWarnings("serial")
public class EmployeeTable extends AbstractItemTable<Employee> {

	@Override
	Object[] getColName() {
		return new String[] {"사원 번호","사원명", "직책 번호","관리자번호","월급","부서번호"};
		}

	@Override
	Object[] toArray(Employee item) {
		return new Object[] {item.getNo(),
				item.getName(), item.getDno(), item.getManager(), item.getSalary(), item.getTno()};
	}
	@Override
	void setWidthAndAlign() {
		tableSetWidth(400,400);
		tableCellAign(SwingConstants.CENTER,0,1);
	}

}

package Jdbc_programming.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Jdbc_programming.dto.Employee;
import Jdbc_programming.service.EmployeeService;
import Jdbc_programming.ui.content.panel.PanelEmployee;
import Jdbc_programming.ui.content.table.EmployeeTable;

@SuppressWarnings("serial")
public class EmployeeFrame extends JFrame {

	private JPanel contentPane;
	private PanelEmployee pEmployee;
	private JPanel pBtns;
	private JPanel pTable;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnAdd;
	private ArrayList<Employee> empList;
	private EmployeeTable emptable;
	private EmployeeService eService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeeFrame() {
		eService = new EmployeeService();
		empList = (ArrayList<Employee>) eService.getEmployeeList();
		initComponents();
	}
	private void initComponents() {
		setTitle("사원 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pEmployee = new PanelEmployee();
		contentPane.add(pEmployee);
		
		pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnAdd = new JButton("추가");
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		pBtns.add(btnCancel);
		
		pTable = new JPanel();
		contentPane.add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);
		
		emptable = new EmployeeTable();
		emptable.setItems(empList);
		
		scrollPane.setViewportView(emptable);
				
	}

}

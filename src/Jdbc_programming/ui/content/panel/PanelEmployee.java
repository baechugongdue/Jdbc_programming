package Jdbc_programming.ui.content.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelEmployee extends JPanel{
	private JLabel lblMgr;
	private JLabel lblNo;
	private JLabel lblName;
	private JLabel lblTno;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfTno;
	private JTextField tfSal;
	private JLabel lblSal;
	private JTextField tfMgr;
	private JLabel lblDno;
	private JTextField tfDno;
	public PanelEmployee() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lblNo = new JLabel("사원번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);
		
		lblName = new JLabel("사원이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
		
		lblTno = new JLabel("직책번호");
		lblTno.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTno);
		
		tfTno = new JTextField();
		add(tfTno);
		tfTno.setColumns(10);
		
		lblMgr = new JLabel("관리자번호");
		lblMgr.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMgr);
		
		tfMgr = new JTextField();
		add(tfMgr);
		tfMgr.setColumns(10);
		
		lblSal = new JLabel("월급");
		lblSal.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSal);
		
		tfSal = new JTextField();
		add(tfSal);
		tfSal.setColumns(10);
		
		lblDno = new JLabel("부서번호");
		lblDno.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDno);
		
		tfDno = new JTextField();
		tfDno.setColumns(10);
		add(tfDno);
	}

}

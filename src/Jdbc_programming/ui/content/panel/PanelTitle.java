package Jdbc_programming.ui.content.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Jdbc_programming.dto.Title;

@SuppressWarnings("serial")
public class PanelTitle extends JPanel {
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblName;
	private JTextField tfName;

	public PanelTitle() {

		initComponents();
	}

	private void initComponents() {
		setBorder(new TitledBorder(null, "직책 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));

		lblNo = new JLabel("직책 번호 ");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);

		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);

		lblName = new JLabel("직책명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);

	}
	
	public void setTitle(Title title) {
		tfNo.setText(title.getNo()+"");
		tfName.setText(title.getName());
		
	}
	
	public Title getTitle() {
		int no = Integer.parseInt(tfNo.getText().trim());
		String name = tfName.getText().trim();
		return new Title(no, name);
	}

	public void setTfEditable(boolean isEditable) {
		 tfNo.setEditable(isEditable);
	}

	public void clearTf() {
		tfNo.setText("");
        tfName.setText("");
	}

	public void setEditableNoTf(boolean isEditable) {
		tfNo.setEditable(isEditable);		
		tfName.setEditable(isEditable);		
	}

	public void setItem(Title item) {
		tfNo.setText(String.valueOf(item.getNo()));
		tfName.setText(item.getName());
	}
}

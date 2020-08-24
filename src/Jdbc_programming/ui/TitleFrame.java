package Jdbc_programming.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Jdbc_programming.dto.Title;
import Jdbc_programming.service.TitleService;
import Jdbc_programming.ui.content.CustomPopupMenu;
import Jdbc_programming.ui.content.TitleDetaildlg;
import Jdbc_programming.ui.content.panel.PanelTitle;
import Jdbc_programming.ui.content.table.TableTitle;

@SuppressWarnings("serial")
public class TitleFrame extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JPanel pContent;
	private JPanel pTable;
	private PanelTitle pTitle;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancel;
	private JScrollPane scrollPane;

	private TitleService tService;
	private ArrayList<Title> titleList;
	private TableTitle tableTitle;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleFrame frame = new TitleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TitleFrame() {
		tService = new TitleService();
		titleList = (ArrayList<Title>) tService.getTitleList();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));

		pTitle = new PanelTitle();
		pContent.add(pTitle);

		pBtns = new JPanel();
		pContent.add(pBtns);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pTable = new JPanel();
		contentPane.add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);

		tableTitle = new TableTitle();
		tableTitle.setItems(titleList);

		CustomPopupMenu popMenu = new CustomPopupMenu(this);
		tableTitle.setComponentPopupMenu(popMenu);
		scrollPane.setViewportView(tableTitle);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		try {
			if (e.getActionCommand().equals("추가")) {
				actionPerformedBtnAdd(e);
			}
			if (e.getActionCommand().equals("직책 수정")) {
				actionPerformedMenuUpdate();
			}
			if (e.getActionCommand().equals("삭제")) {
				actionPerformedMenuDelete();
			}
			if (e.getActionCommand().equals("세부정보")) {
				actionPerformedMenuDetail();
			}
			if (e.getActionCommand().equals("수정")) {
				actionPerformedBtnUpdate();
			}

		} catch (Exception ee) {
			JOptionPane.showMessageDialog(null, ee.getMessage());
			ee.printStackTrace();
		}
	}
	//수정
	private void actionPerformedBtnUpdate() {
		Title updatedTitle = pTitle.getTitle();
		int updateIdx = titleList.indexOf(updatedTitle);
		System.out.println(updatedTitle);
		tService.updateTitle(updatedTitle);
		tableTitle.updateRow(updateIdx, updatedTitle);
		titleList.set(updateIdx, updatedTitle);
		System.out.println(updateIdx);
		pTitle.clearTf();
		pTitle.setEditableNoTf(true);
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null,
				String.format("%s(%d) 수정 완료!!", updatedTitle.getName(), updatedTitle.getNo()));
	}    

	// 세부정보
	private void actionPerformedMenuDetail() {
		System.out.println("세부정보");
		int selIdx = tableTitle.getSelectedRow();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하시욧");
			return;
		}
		Title detailTitle = titleList.get(selIdx);
		System.out.println(detailTitle);
		TitleDetaildlg dlg = new TitleDetaildlg();
		dlg.setTitle(detailTitle);
		dlg.setTfNotEditable();
		dlg.setVisible(true);
	}

	// 삭제
	private void actionPerformedMenuDelete() {
		int selIdx = tableTitle.getSelectedRow();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하시욧");
			return;
		}
		Title deletedTitle = titleList.remove(selIdx);
		tableTitle.removeRow(selIdx);
		tService.deleteTitle(deletedTitle);
		
		JOptionPane.showMessageDialog(null, String.format("%s(%d) 삭제완료", deletedTitle.getName(), deletedTitle.getNo()));
	}

	// 직책 수정 
	private void actionPerformedMenuUpdate() {
		int selIdx = tableTitle.getSelectedRow();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하시욧");
			return;
		}
		Title selTitle = titleList.get(selIdx);
		pTitle.setTitle(selTitle);
		btnAdd.setText("수정");
		pTitle.setTfEditable(false);

	}

	// 추가
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Title newTitle = pTitle.getTitle();
		tService.addTitle(newTitle);
		titleList.add(newTitle);
		tableTitle.addRow(newTitle);
		JOptionPane.showMessageDialog(null, "추가 완료");
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		dispose();
	}

}
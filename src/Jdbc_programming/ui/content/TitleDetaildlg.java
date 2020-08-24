package Jdbc_programming.ui.content;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Jdbc_programming.dto.Title;
import Jdbc_programming.ui.content.panel.PanelTitle;

@SuppressWarnings("serial")
public class TitleDetaildlg extends JDialog implements ActionListener {
	private JPanel ContentPanel;
	private JPanel pBtns;
	private JButton okButton;
	private PanelTitle pTitle;
	
	public TitleDetaildlg() {
		initComponents();
	}

	private void initComponents() {
		setMinimumSize(new Dimension(300, 300));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
				
		ContentPanel = new JPanel();
		getContentPane().add(ContentPanel);
		
		pTitle = new PanelTitle();
		ContentPanel.add(pTitle);
		
		pBtns = new JPanel();
		getContentPane().add(pBtns);
		
		okButton = new JButton("확인");
		pBtns.add(okButton);
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}

	private void actionPerformedOkButton(ActionEvent e) {
		this.dispose();
	}

	public void setTfNotEditable() {
		pTitle.setEditableNoTf(false);
	}

	public void setTitle(Title title) {
		pTitle.setItem(title);
	}	    
}
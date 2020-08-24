package Jdbc_programming.ui.content;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class CustomPopupMenu extends JPopupMenu {
    public CustomPopupMenu(ActionListener listener) {
        JMenuItem updateMenu = new JMenuItem("직책 수정");
        updateMenu.addActionListener(listener);
        add(updateMenu);
        JMenuItem deleteMenu = new JMenuItem("삭제");
        deleteMenu.addActionListener(listener);
        add(deleteMenu);
        JMenuItem detailMenu = new JMenuItem("세부정보");
        detailMenu.addActionListener(listener);
        add(detailMenu);
    }
}

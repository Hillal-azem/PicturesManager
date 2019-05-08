package MenuBar;

import javax.swing.*;
import java.awt.*;

public class ToolsMenu extends JMenuBar{

    private Color bgColor = Color.WHITE;

    public ToolsMenu() {
        JMenu menuFile = new JMenu("File");
        this.add(menuFile);
        JMenu menuEdit = new JMenu("Edit");
        this.add(menuEdit);
        JMenu menuView = new JMenu("View");
        this.add(menuView);
        JMenu menuHelp = new JMenu("Help");
        this.add(menuHelp);

        ItemsAction.actionFile(new MenuItems(stringToArray("Import"),menuFile).getMenuItems());
        ItemsAction.actionEdit(new MenuItems(stringToArray("Rename","Delete"),menuEdit).getMenuItems());
        ItemsAction.actionView(new MenuItems(stringToArray("DisplayView","Undisplayed View"),menuView).getMenuItems());
        ItemsAction.actionHelp(new MenuItems(stringToArray("help ?"),menuHelp).getMenuItems());
    }

    private String[] stringToArray(String...array){
        return array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

}
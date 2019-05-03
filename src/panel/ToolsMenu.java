package panel;

import javax.swing.*;
import java.awt.*;

public class ToolsMenu extends JMenuBar{

    private Color bgColor = Color.WHITE;

    public ToolsMenu() {
        JMenu menu1 = new JMenu("File");
        this.add(menu1);
        JMenu menu2 = new JMenu("Edit");
        this.add(menu2);
        JMenu menu3 = new JMenu("View");
        this.add(menu3);
        JMenu menu4 = new JMenu("Help");
        this.add(menu4);

        MenuItems menu4Item = new MenuItems(,);

        menu4.add(menuItem);
        menu4.add(menuItem2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }




}

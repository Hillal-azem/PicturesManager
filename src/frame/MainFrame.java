package frame;

import panel.ToolsMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {

        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        ImageIcon favicon = new ImageIcon("Images/favicon.png");
        this.setIconImage(favicon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pictures Manager");

        ToolsMenu menuBar = new ToolsMenu();
        JMenuBar menu = menuBar.getMenuBar();

        this.setJMenuBar(menu);

        this.setVisible(true);
    }
}

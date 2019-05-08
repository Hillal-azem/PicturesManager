package frame;

import MenuBar.ToolsMenu;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {

        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        ImageIcon favicon = new ImageIcon("Images/favicon.png");
        this.setIconImage(favicon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pictures Manager");

        ToolsMenu menuBar = new ToolsMenu();
        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }
}

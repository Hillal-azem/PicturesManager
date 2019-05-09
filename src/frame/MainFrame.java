package frame;

import MenuBar.ToolsMenu;
import panel.DisplayImages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    private ImageIcon image;
    private JLabel label;

    public MainFrame() throws HeadlessException, IOException {

        this.setSize(1240, 800);
        this.setLocationRelativeTo(null);
        ImageIcon favicon = new ImageIcon("Images/favicon.png");
        this.setIconImage(favicon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pictures Manager");

        ToolsMenu menuBar = new ToolsMenu();
        this.setJMenuBar(menuBar);


        JPanel panel = new DisplayImages();
        panel.setBackground(Color.WHITE);

        this.add(panel);

        //JScrollPane scrollBar = new JScrollPane(panel);

        //this.getContentPane().add(scrollBar, BorderLayout.CENTER);

        this.setVisible(true);
    }


}


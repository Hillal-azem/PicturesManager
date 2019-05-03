package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("File");
    private JMenu menu2 = new JMenu("Edit");
    private JMenu menu3 = new JMenu("View");
    private JMenu menu4 = new JMenu("Help");
    private JMenuItem menuItem = new JMenuItem("Il n'y a aucune aide ici !");


    public MainFrame() throws HeadlessException {

        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        ImageIcon favicon = new ImageIcon("Images/favicon.png");
        this.setIconImage(favicon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pictures Manager");

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        menu4.add(menuItem);

        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }
}

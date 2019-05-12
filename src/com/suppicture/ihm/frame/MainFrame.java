package com.suppicture.ihm.frame;
import com.suppicture.ihm.menubar.ToolsMenu;
import com.suppicture.ihm.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    private int totalImages;
    private ToolsMenu menuBar = new ToolsMenu();
    private MainPanel panel = new MainPanel(menuBar);

    public MainFrame() throws HeadlessException, IOException {
        this.totalImages = MainPanel.getIcons().size();
        this.setSize(1240, 800);
        this.setLocationRelativeTo(null);
        ImageIcon favicon = new ImageIcon("Images/favicon.png");
        this.setIconImage(favicon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pictures Manager");
        this.setJMenuBar(menuBar);

        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(450 ,calculatePanelHeight()));
        JScrollPane scroll = new JScrollPane(panel);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        this.add(scroll);
        this.setVisible(true);

        /*
          Resizing window event manager.
          The panel height is managed automatically when Frame is resizing.
          The new panel height calculation is based on the total image and Frame height
         */
        this.getRootPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.setPreferredSize(new Dimension(450 ,calculatePanelHeight()));
            }

        });
    }


    /**
     * Methode calculating the new height to assign to the panel
     * @return int height
     */
    private int calculatePanelHeight(){

        /*
            la hauteur du pannel sera:
            nombre d'images par ligne = (largeurFrame - 19 ) / 150
            le nombre de lignes nécesaire = nombre total d'images / images par ligne
            hauteur panel = 134 * nombre de lignes + 40
        */

        int imagesPerLine = (this.getWidth() - 19) / 150;
        float tmp = (float) totalImages / imagesPerLine;
        int totalLines = (int) Math.ceil(tmp);
        return (134 * totalLines) + 40;
    }


}


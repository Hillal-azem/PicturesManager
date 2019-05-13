package com.suppicture.ihm.frame;

import com.suppicture.images.process.Icon;

import javax.swing.*;
import java.awt.*;

public class OnePictureFrame extends JFrame{

    public OnePictureFrame(Icon icon) {

        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(490,0));
        this.setLocationRelativeTo(null);
        ImageIcon favicon = new ImageIcon("Images/favicon.png");
        this.setIconImage(favicon.getImage());
        this.setTitle("Pictures Manager");

        JScrollPane jScrollPane = new JScrollPane();

        ImageIcon iconImage = new ImageIcon(icon.getPath());

        jScrollPane.setViewportView(new JLabel(iconImage));

        this.setContentPane(jScrollPane);

        this.setVisible(true);

    }



}

package com.suppicture.ihm.panel;

import com.suppicture.images.process.Icon;

import com.suppicture.ihm.menubar.ToolsMenu;
import com.suppicture.images.process.ImagesLoader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPanel extends JPanel {

    private static List<JButton> imageButtons;
    private static List<Icon> icons;
    private ToolsMenu menuBar;

    public MainPanel(ToolsMenu menuBar) {
        this.menuBar = menuBar;

        ImagesLoader imagesLoader = ImagesLoader.getInstance("Images/myImages");
        List<Icon> icons = imagesLoader.getIcons();
        Collections.sort(icons);
        MainPanel.icons = icons;

        List<JButton> imagesButtons = new ArrayList<>();
        imageButtons = imagesButtons;

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.display();

    }

    public void display(){
        JButton imageButton;
        for (Icon icon :
                icons) {

            imageButton = new JButton(icon.getName(),icon);

            JButton finalImageButton = imageButton;
            imageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (ImagesProcess.select(icon)) {
                        finalImageButton.setBorderPainted(false);
                    }
                    else {
                        finalImageButton.setBorderPainted(true);
                        finalImageButton.setBorder(new LineBorder(Color.BLUE));
                    }

                    menuBar.enableEditMenu();

                }
            });

            imageButtons.add(imageButton);
            imageButton.setLayout(null);
            imageButton.setPreferredSize(new Dimension(145,130));
            imageButton.setBorderPainted(false);
            imageButton.setHorizontalTextPosition(SwingConstants.CENTER);
            imageButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            imageButton.setBackground(Color.WHITE);

            this.add(imageButton);
        }
    }

    public static List<JButton> getImageButtons() {
        return imageButtons;
    }

    public static List<Icon> getIcons() {
        return icons;
    }
}


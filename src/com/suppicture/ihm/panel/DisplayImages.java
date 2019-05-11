package com.suppicture.ihm.panel;

import com.suppicture.images.process.Icon;

import com.suppicture.ihm.menubar.ToolsMenu;
import com.suppicture.images.process.LoadImages;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisplayImages extends JPanel {

    private ToolsMenu menuBar;

    public DisplayImages(ToolsMenu menuBar) {
        this.menuBar = menuBar;

        LoadImages loadImages = new LoadImages("Images/myImages");
        List<Icon> icons = loadImages.getIcons();
        Collections.sort(icons);

        ArrayList<JButton> buttonList = new ArrayList<>();
        ArrayList<Icon> selectedImages = new ArrayList<>();

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

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

            buttonList.add(imageButton);
            imageButton.setLayout(null);
            imageButton.setPreferredSize(new Dimension(145,130));
            imageButton.setBorderPainted(false);
            imageButton.setHorizontalTextPosition(SwingConstants.CENTER);
            imageButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            imageButton.setBackground(Color.WHITE);

            this.add(imageButton);
        }
    }
}


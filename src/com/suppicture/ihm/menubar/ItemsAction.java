package com.suppicture.ihm.menubar;

import com.suppicture.file.process.ImagesFilter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/***
 * Class with static methods. It manages the click events
 * on the items of each menu
 *
 */
class ItemsAction {

    /**
     * Static method managing event of importing images
     * @param item MyJMenuItem
     */
    static void actionImport(MyJMenuItem item){

        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image;

                ImagesFilter imagesFilter = new ImagesFilter(
                        new String[]{"png", "jpeg", "jpg"},
                        "Images must be of format: *.jpeg, *.png, *.jpg");

                JFileChooser choices = new JFileChooser();
                choices.setFileFilter(imagesFilter);
                choices.setMultiSelectionEnabled(true) ;

                if(JFileChooser.APPROVE_OPTION == choices.showOpenDialog(item)){

                    File[] files = choices.getSelectedFiles();

                    for (File file :
                            files) {

                        String imageExtension = file.getName().substring(file.getName().lastIndexOf('.') + 1);

                        try {
                            image = ImageIO.read(file);
                            ImageIO.write(image, imageExtension, new File("Images/myImages/" + file.getName()));

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }

            }
        });

    }

    /**
     * Static method managing event of editing. Rename and delete
     * @param item MyJMenuItem
     */
    static void actionRename(MyJMenuItem item){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
    }

    static void actionDelete(MyJMenuItem item){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
    }

    static void actionView(MyJMenuItem item){

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    static void actionHelp(MyJMenuItem item){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

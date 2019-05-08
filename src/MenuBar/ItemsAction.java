package MenuBar;

import file.ImagesFilter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/***
 * Class with static methods. It manages the click events
 * on the items of each menu
 *
 */
class ItemsAction {

    /**
     * Static method managing event of importing images
     * @param itemsFile ArrayList<JMenuItem>
     */
    static void actionFile(ArrayList<JMenuItem> itemsFile){

        itemsFile.get(0).addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image;

                ImagesFilter imagesFilter = new ImagesFilter(
                        new String[]{"png", "jpeg", "jpg"},
                        "Images must be of format: *.jpeg, *.png, *.jpg");

                JFileChooser choices = new JFileChooser();
                choices.setFileFilter(imagesFilter);
                choices.setMultiSelectionEnabled(true) ;

                if(JFileChooser.APPROVE_OPTION == choices.showOpenDialog(itemsFile.get(0))){

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
     * @param itemsEdit
     */
    static void actionEdit(ArrayList<JMenuItem> itemsEdit){
        itemsEdit.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        itemsEdit.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    static void actionView(ArrayList<JMenuItem> itemsView){
        itemsView.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        itemsView.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    static void actionHelp(ArrayList<JMenuItem> itemsHelp){
        itemsHelp.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

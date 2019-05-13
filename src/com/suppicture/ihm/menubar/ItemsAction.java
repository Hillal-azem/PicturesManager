package com.suppicture.ihm.menubar;

import com.suppicture.file.process.ImagesFilter;
import com.suppicture.ihm.frame.MainFrame;
import com.suppicture.ihm.frame.OnePictureFrame;
import com.suppicture.ihm.panel.ImagesProcess;
import com.suppicture.ihm.panel.MainPanel;
import com.suppicture.images.process.Icon;
import com.suppicture.images.process.ImagesLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

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

    private static ImagesFilter imagesFilter = new ImagesFilter(
            new String[]{"png", "jpeg", "jpg"},
            "Images must be of format: *.jpeg, *.png, *.jpg");

    static void actionImport(MyJMenuItem item, MainFrame frame){

        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image;

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
                    frame.refreshPanel();
                }

            }
        });

    }
    /**
     * Static method managing event of editing. Rename and delete
     * @param item MyJMenuItem
     */
    static void actionRename(MyJMenuItem item,MainFrame frame){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Icon> selectIcons = ImagesProcess.getSelectedImages();

                    String newName = JOptionPane.showInputDialog(frame, "Enter printer name:",selectIcons.get(0).getName());

                    if (newName != null){
                        File firstImage = new File(selectIcons.get(0).getPath());

                        File newImage;

                        String suffix = extention(newName);

                        if (suffix == null || !imagesFilter.isAuthozedFormat(suffix)){
                            newImage = new File("Images/myImages/"+newName+".png");
                        }
                        else{
                            newImage = new File("Images/myImages/"+newName);
                        }

                        if(canChange(newImage.getName())){
                            firstImage.renameTo(newImage);
                            frame.refreshPanel();
                            ImagesProcess.removeAllFromList();
                            ToolsMenu.enableEditMenu();

                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"This file already exist");
                        }

                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }

        });
    }

    static void actionDelete(MyJMenuItem item, MainFrame frame){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    List<Icon> icons = ImagesProcess.getSelectedImages();

                    String[] options = {"oui", "non"};

                    int validate = JOptionPane.showOptionDialog(null, "Are you sure you want to delete these pictures?",
                            "Validate",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    if (validate == 0){
                        for (Icon icon : icons) {
                            File file = new File(icon.getPath());
                            file.delete();
                        }
                        frame.refreshPanel();
                        ImagesProcess.removeAllFromList();
                        ToolsMenu.enableEditMenu();
                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }

        });
    }

    public static void actionView(MyJMenuItem item){

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    List<Icon> icon = ImagesProcess.getSelectedImages();
                    new OnePictureFrame(icon.get(0));

                }catch (Exception e1){
                    e1.printStackTrace();
                }


            }
        });
    }

    public static void actionHelp(MyJMenuItem item, MainFrame frame){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newline=System.getProperty("line.separator");
                JOptionPane.showMessageDialog(frame,
                        "[+] To import picture click on the menu file then import and select files (png, jpg ...)"+newline+newline+
                                "[+] Click on a picture to rename or delete it by clicking on the edit menu"+newline+newline+
                                "[+] You can also click on view to display the selected picture"+newline+newline+
                                "[+] If you click on several photos you only have the choice to delete pictures");
            }
        });
    }

    static void actionSelectAll(MyJMenuItem selectAllItems) {
        selectAllItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImagesProcess.addAllToList();
                for (JButton imageButton :
                        MainPanel.getImageButtons()) {
                    imageButton.setBorderPainted(true);
                    imageButton.setBorder(new LineBorder(Color.BLUE));
                }
                ToolsMenu.enableEditMenu();
                ToolsMenu.enableViewMenu();
            }
        });
    }

    static void actionUnselectAll(MyJMenuItem unselectAllItems){
        unselectAllItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImagesProcess.removeAllFromList();
                for (JButton imageButton :
                        MainPanel.getImageButtons()) {
                    imageButton.setBorderPainted(false);
                }
                ToolsMenu.enableEditMenu();
                ToolsMenu.enableViewMenu();
            }
        });
    }

    private static String extention(String fileName) {
        String suffix = null;

        int i = fileName.lastIndexOf('.');
        if(i > 0 &&  i < fileName.length() - 1)
            suffix = fileName.substring(i+1).toLowerCase();

        return suffix;
    }

    private static boolean canChange(String newName){

        ImagesLoader imagesLoader = ImagesLoader.getInstance();
        List<Icon> allIcons = imagesLoader.getIcons();

        boolean isDifferentImage = true;

        for (Icon allIcon : allIcons) {
            if (allIcon.getName().equals(newName)){
                isDifferentImage = false;
                break;
            }
        }
        return isDifferentImage;
    }
}

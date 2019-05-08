package com.images;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ImagesProcess {

    private String pathToImages;
    private File[] imageFiles;
    private List<ImageIcon> icones;

    public ImagesProcess(String pathToImages) {
        this.pathToImages = pathToImages;
        this.imageFiles = getImageFilesFromDirectory();
        this.icones = getImagesFromFiles();
    }

    private File[] getImageFilesFromDirectory(){
        return new File(pathToImages).listFiles();
    }

    private List<ImageIcon> getImagesFromFiles(){
        List<ImageIcon> iconsList = new ArrayList<>();
        BufferedImage image = null;
        for (File file :
                imageFiles) {
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(130,100, Image.SCALE_DEFAULT));
            iconsList.add(icon);
        }
        return iconsList;
    }

    public List<ImageIcon> getIcones() {
        return icones;
    }
}

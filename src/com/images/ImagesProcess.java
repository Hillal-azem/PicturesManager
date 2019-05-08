package com.images;

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
    private List<Icon> icons;

    public ImagesProcess(String pathToImages) {
        this.pathToImages = pathToImages;
        this.imageFiles = getImageFilesFromDirectory();
        this.icons = getImagesFromFiles();
    }

    private File[] getImageFilesFromDirectory(){
        return new File(pathToImages).listFiles();
    }

    private List<Icon> getImagesFromFiles(){
        List<Icon> iconsList = new ArrayList<>();
        Image image = null;
        for (File file :
                imageFiles) {
            try {
                image = scale(ImageIO.read(file), 130, 100);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(130,100, Image.SCALE_DEFAULT));
            Icon icon = new Icon(image, file.getName(), file.getPath());
            iconsList.add(icon);
        }
        return iconsList;
    }

    private Image scale(Image source, int width, int height) {
        /* On crée une nouvelle image aux bonnes dimensions. */
        BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        /* On dessine sur le Graphics de l'image bufferisée. */
        Graphics2D g = buf.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(source, 0, 0, width, height, null);
        g.dispose();

        /* On retourne l'image bufferisée, qui est une image. */
        return buf;
    }

    public List<Icon> getIcons() {
        return icons;
    }


}

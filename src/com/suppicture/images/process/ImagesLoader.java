package com.suppicture.images.process;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ImagesLoader {

    private static ImagesLoader instance = null;
    private static final int imageWidth = 130;
    private static final int imageHeight = 100;


    private String pathToImages;
    private File[] imageFiles;
    private List<Icon> icons;

    private ImagesLoader(String pathToImages) {
        this.pathToImages = pathToImages;
        this.imageFiles = getImageFilesFromDirectory();
        this.icons = getImagesFromFiles();
    }


    public static ImagesLoader getInstance(String pathToImages) {
        if (instance == null){
            return new ImagesLoader(pathToImages);
        }
        else {
            return instance;
        }
    }

    public static ImagesLoader getInstance(){
        if (instance == null){
            return new ImagesLoader("Images/myImages");
        }
        else {
            return instance;
        }
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
                image = scale(ImageIO.read(file), imageWidth, imageHeight);
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

        return buf;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public static int getImageWidth() {
        return imageWidth;
    }

    public static int getImageHeight() {
        return imageHeight;
    }
}

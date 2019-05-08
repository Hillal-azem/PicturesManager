package com.images;

import javax.swing.*;
import java.awt.*;

public class Icon extends ImageIcon {

    private String name;
    private String path;

    public Icon(Image image, String name, String path) {
        super(image);
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}

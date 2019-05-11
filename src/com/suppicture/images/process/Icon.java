package com.suppicture.images.process;

import javax.swing.*;
import java.awt.*;

public class Icon extends ImageIcon implements Comparable<Icon>{

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

    @Override
    public int compareTo(Icon o) {
        return name.compareTo(o.getName());
    }
}

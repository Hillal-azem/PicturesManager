package com.suppicture.file.process;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImagesFilter extends FileFilter {

    String[] authorizedFormats;
    String description;

    public ImagesFilter(String[] authorizedFormats, String description) {
        this.authorizedFormats = authorizedFormats;
        this.description = description;
    }

    public boolean isAuthozedFormat(String suffix){
        for (String authorizedFormat:
                authorizedFormats) {
            if (suffix.equals(authorizedFormat)) return true;
        }
        return false;
    }

    @Override
    public boolean accept(File f) {
        String fileName = f.getName();
        String suffix = null;

        if (f.isDirectory())  return true;

        int i = fileName.lastIndexOf('.');
        if(i > 0 &&  i < fileName.length() - 1)
            suffix = fileName.substring(i+1).toLowerCase();
        return suffix != null && isAuthozedFormat(suffix);
    }


    @Override
    public String getDescription() {
        return description;
    }
}



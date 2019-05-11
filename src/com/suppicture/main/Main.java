package com.suppicture.main;

import com.suppicture.images.process.LoadImages;
import com.suppicture.ihm.frame.MainFrame;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MainFrame windows = new MainFrame();

        LoadImages images = new LoadImages("Images/myImages");
    }
}

package panel;

import javax.swing.*;
import java.awt.*;

public class DisplayImages extends JPanel {

    private ImageIcon icon;

    public DisplayImages() {

        loadImage();
        initPanel();
    }

    private void loadImage() {

        icon = new ImageIcon("book.jpg");
    }

    private void initPanel() {

        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        setPreferredSize(new Dimension(w, h));
    }

}

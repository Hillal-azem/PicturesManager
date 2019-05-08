package panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class DisplayImages extends JPanel {

    public DisplayImages() {

        ImageIcon icon = new ImageIcon(new ImageIcon("Images/myImages/IMG_20130717_163711.jpg").getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT));

        ArrayList<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i<4;i++){

            buttonList.add(new JButton("ok",icon));
            buttonList.get(i).setBorder( new EmptyBorder(5, 8, 5, 8) );
            buttonList.get(i).setBorderPainted(false);
            buttonList.get(i).setHorizontalTextPosition(SwingConstants.CENTER);
            buttonList.get(i).setVerticalTextPosition(SwingConstants.BOTTOM);
            buttonList.get(i).setBackground(Color.WHITE);

            this.add(buttonList.get(i), BorderLayout.WEST);
        }
    }
}


package panel;

import com.images.ImagesProcess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayImages extends JPanel {

    public DisplayImages() {

        //this.setLayout(new BorderLayout());

        ImagesProcess imagesProcess = new ImagesProcess("Images/myImages");
        List<ImageIcon> icons = imagesProcess.getIcons();

        ArrayList<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i<icons.size();i++){
            buttonList.add(new JButton("ok",icons.get(i)));
            buttonList.get(i).setBorder( new EmptyBorder(5, 8, 5, 8) );
            buttonList.get(i).setBorderPainted(false);
            buttonList.get(i).setHorizontalTextPosition(SwingConstants.CENTER);
            buttonList.get(i).setVerticalTextPosition(SwingConstants.BOTTOM);
            buttonList.get(i).setBackground(Color.WHITE);

            this.add(buttonList.get(i), BorderLayout.WEST);
        }
    }
}


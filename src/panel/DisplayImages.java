package panel;

import com.images.Icon;
import com.images.ImagesProcess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisplayImages extends JPanel {

    public DisplayImages() {

        ImagesProcess imagesProcess = new ImagesProcess("Images/myImages");
        List<Icon> icons = imagesProcess.getIcons();
        Collections.sort(icons);

        ArrayList<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i<icons.size();i++){

            buttonList.add(new JButton(icons.get(i).getName(),icons.get(i)));
            buttonList.get(i).setLayout(null);
            buttonList.get(i).setPreferredSize(new Dimension(145,130));
            buttonList.get(i).setBorderPainted(false);
            buttonList.get(i).setHorizontalTextPosition(SwingConstants.CENTER);
            buttonList.get(i).setVerticalTextPosition(SwingConstants.BOTTOM);
            buttonList.get(i).setBackground(Color.WHITE);

            this.add(buttonList.get(i));
        }
    }
}


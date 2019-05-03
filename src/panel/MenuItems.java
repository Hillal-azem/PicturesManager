package panel;

import javax.swing.*;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class MenuItems{

    private ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

    public MenuItems(String[] titles, java.awt.event.ActionListener[] actions, JMenu menu) {

        for(int i = 0; i < titles.length; i++){
            menuItems.add(new JMenuItem(titles[i]));
            menuItems.get(i).addActionListener(actions[i]);
            menu.add(menuItems.get(i));
        }
    }
}

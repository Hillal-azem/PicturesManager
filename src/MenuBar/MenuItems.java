package MenuBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuItems{

    private ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

    public MenuItems(String[] titles, JMenu menu) {

        for(int i = 0; i < titles.length; i++){
            menuItems.add(new JMenuItem(titles[i]));
            menuItems.get(i).setBackground(Color.WHITE);
            menu.add(menuItems.get(i));
        }
    }

    public ArrayList<JMenuItem> getMenuItems() {
        return menuItems;
    }
}

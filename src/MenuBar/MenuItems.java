package MenuBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Class MenuItems
 * Create items from list and add them to the menu
 */
public class MenuItems{


    private ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

    /**
     * Constructor witch creates items from the titles list
     * and add them to the menu
     * @param titles
     * @param menu
     */
    public MenuItems(String[] titles, JMenu menu) {

        for(int i = 0; i < titles.length; i++){
            menuItems.add(new JMenuItem(titles[i]));
            menuItems.get(i).setBackground(Color.WHITE);
            menu.add(menuItems.get(i));
        }
    }

    /**
     * Getter on the list of items
     * @return ArrayList<JMenuItem>
     */
    public ArrayList<JMenuItem> getMenuItems() {
        return menuItems;
    }
}

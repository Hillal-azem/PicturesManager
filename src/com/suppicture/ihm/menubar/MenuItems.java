package com.suppicture.ihm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


// TODO
//  This Class is to delete
//  Because it's never used


/**
 * Class MenuItems
 * Create items from list and add them to the menu
 */
public class MenuItems{


    private ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

    /**
     * Constructor witch creates items from the titles list
     * and add them to the menu
     * @param titles ArrayList<String>
     * @param menu Jmenu
     */
    public MenuItems(String[] titles, JMenu menu) {

        for(int i = 0; i < titles.length; i++){
            JMenuItem menuItem = new JMenuItem(titles[i]);
            //m.setEnabled(false);
            menuItems.add(menuItem);
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

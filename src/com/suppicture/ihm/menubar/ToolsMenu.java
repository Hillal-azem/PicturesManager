package com.suppicture.ihm.menubar;

import com.suppicture.ihm.frame.MainFrame;
import com.suppicture.ihm.panel.ImagesProcess;
import com.suppicture.ihm.panel.MainPanel;
import com.suppicture.images.process.ImagesLoader;

import javax.swing.*;
import java.awt.*;

public class ToolsMenu extends JMenuBar{

    private Color bgColor = Color.WHITE;

    public ToolsMenu() {
        JMenu menuFile = new JMenu("File");
        this.add(menuFile);
        JMenu menuEdit = new JMenu("Edit");
        this.add(menuEdit);
        JMenu menuView = new JMenu("View");
        this.add(menuView);
        JMenu menuHelp = new JMenu("Help");
        this.add(menuHelp);


        MyJMenuItem importItem = new MyJMenuItem("Import");
        menuFile.add(importItem);
        ItemsAction.actionImport(importItem);

        MyJMenuItem selectAllItems = new MyJMenuItem("Select all");
        menuFile.add(selectAllItems);
        ItemsAction.actionSelectAll(selectAllItems);

        MyJMenuItem unselectAllItems = new MyJMenuItem("Unselect all");
        menuFile.add(unselectAllItems);
        ItemsAction.actionUnselectAll(unselectAllItems);

        MyJMenuItem renameItem = new MyJMenuItem("Rename");
        renameItem.setEnabled(false);
        menuEdit.add(renameItem);
        ItemsAction.actionRename(renameItem);

        MyJMenuItem deleteItem = new MyJMenuItem("Delete");
        deleteItem.setEnabled(false);
        menuEdit.add(deleteItem);
        ItemsAction.actionDelete(renameItem);


        //MenuItems menuItemsImport = new MenuItems(stringToArray("Import"),menuFile);
        //ItemsAction.actionFile(menuItemsImport.getMenuItems());

        //MenuItems menuItemsEdit = new MenuItems(stringToArray("Rename","Delete"),menuEdit);
        //menuItemsEdit.getMenuItems().get(0).setEnabled(false);
        //menuItemsEdit.getMenuItems().get(1).setEnabled(false);
        //ItemsAction.actionEdit(menuItemsEdit.getMenuItems());

        //ItemsAction.actionView(new MenuItems(stringToArray("DisplayView","Undisplayed View"),menuView).getMenuItems());
        //ItemsAction.actionHelp(new MenuItems(stringToArray("help ?"),menuHelp).getMenuItems());


    }

    private String[] stringToArray(String...array){
        return array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    public void enableEditMenu(){
        if (ImagesProcess.noImagesSelected()){
            this.getMenu(1).getItem(1).setEnabled(false);
            this.getMenu(1).getItem(0).setEnabled(false);
        }
        else {
            this.getMenu(1).getItem(1).setEnabled(true);
            if (ImagesProcess.getSelectedImages().size() == 1){
                this.getMenu(1).getItem(0).setEnabled(true);
            }
            else {
                this.getMenu(1).getItem(0).setEnabled(false);
            }
        }
    }

}
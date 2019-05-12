package com.suppicture.ihm.menubar;

import com.suppicture.ihm.frame.MainFrame;
import com.suppicture.ihm.frame.OnePictureFrame;
import com.suppicture.ihm.panel.ImagesProcess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToolsMenu extends JMenuBar{

    private Color bgColor = Color.WHITE;
    private static List<JMenu> menus = new ArrayList<>();

    public ToolsMenu(MainFrame frame) {
        JMenu menuFile = new JMenu("File");
        this.add(menuFile);
        ToolsMenu.menus.add(menuFile);
        JMenu menuEdit = new JMenu("Edit");
        this.add(menuEdit);
        menus.add(menuEdit);
        JMenu menuView = new JMenu("View");
        this.add(menuView);
        menus.add(menuView);
        JMenu menuHelp = new JMenu("Help");
        this.add(menuHelp);
        menus.add(menuHelp);




        MyJMenuItem importItem = new MyJMenuItem("Import");
        menuFile.add(importItem);
        ItemsAction.actionImport(importItem, frame);

        MyJMenuItem selectAllItems = new MyJMenuItem("Select all");
        menuFile.add(selectAllItems);
        ItemsAction.actionSelectAll(selectAllItems);

        MyJMenuItem unselectAllItems = new MyJMenuItem("Unselect all");
        menuFile.add(unselectAllItems);
        ItemsAction.actionUnselectAll(unselectAllItems);

        MyJMenuItem renameItem = new MyJMenuItem("Rename");
        renameItem.setEnabled(false);
        menuEdit.add(renameItem);
        ItemsAction.actionRename(renameItem,frame);

        MyJMenuItem deleteItem = new MyJMenuItem("Delete");
        deleteItem.setEnabled(false);
        menuEdit.add(deleteItem);
        ItemsAction.actionDelete(deleteItem,frame);

        MyJMenuItem viewItem = new MyJMenuItem("View picture");
        viewItem.setEnabled(false);
        menuView.add(viewItem);
        ItemsAction.actionView(viewItem);

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

    /**
     * Static method enabling/desablic options on the
     * menuBar's editMenu
     */
    public static void enableEditMenu(){
        if (ImagesProcess.noImagesSelected()){
            menus.get(1).getItem(1).setEnabled(false);
            menus.get(1).getItem(0).setEnabled(false);
        }
        else {
            menus.get(1).getItem(1).setEnabled(true);
            if (ImagesProcess.getSelectedImages().size() == 1){
                menus.get(1).getItem(0).setEnabled(true);
            }
            else {
                menus.get(1).getItem(0).setEnabled(false);
            }
        }
    }

    public static void enableViewMenu(){
        if (ImagesProcess.noImagesSelected()){
            menus.get(2).getItem(0).setEnabled(false);
        }
        else {
            menus.get(2).getItem(0).setEnabled(true);
            if (ImagesProcess.getSelectedImages().size() == 1){
                menus.get(2).getItem(0).setEnabled(true);
            }
            else {
                menus.get(2).getItem(0).setEnabled(false);
            }
        }
    }




}
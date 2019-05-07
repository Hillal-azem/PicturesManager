package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        actionFile(new MenuItems(stringToArray("Import"),menuFile).getMenuItems());
        actionEdit(new MenuItems(stringToArray("Rename","Delete"),menuEdit).getMenuItems());
        actionView(new MenuItems(stringToArray("DisplayView","Undisplayed View"),menuView).getMenuItems());
        actionHelp(new MenuItems(stringToArray("help ?"),menuHelp).getMenuItems());
    }

    private void actionFile(ArrayList<JMenuItem> itemsFile){
        itemsFile.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    private void actionEdit(ArrayList<JMenuItem> itemsEdit){
        itemsEdit.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        itemsEdit.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void actionView(ArrayList<JMenuItem> itemsView){
        itemsView.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        itemsView.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void actionHelp(ArrayList<JMenuItem> itemsHelp){
        itemsHelp.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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

}

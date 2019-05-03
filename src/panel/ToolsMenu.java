package panel;

import javax.swing.*;

public class ToolsMenu {

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private JMenuBar menuBar = new JMenuBar();

    public ToolsMenu() {
        JMenu menu1 = new JMenu("File");
        menuBar.add(menu1);
        JMenu menu2 = new JMenu("Edit");
        menuBar.add(menu2);
        JMenu menu3 = new JMenu("View");
        menuBar.add(menu3);
        JMenu menu4 = new JMenu("Help");
        menuBar.add(menu4);

        JMenuItem menuItem = new JMenuItem("Il n'y a aucune aide ici !");
        menu4.add(menuItem);
    }





}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class HandleObjects extends MouseAdapter implements MouseListener {

    JLabel imagePreview;
    JPanel panelObjects;
    JPanel instancePanel;
    JPanel editionPanel;

    public HandleObjects(JPanel panelObjects, JLabel imagePreview, JPanel instancePanel, JPanel editionPanel) {
        this.imagePreview = imagePreview;
        this.panelObjects = panelObjects;
        this.instancePanel = instancePanel;
        this.editionPanel = editionPanel;

    }

    public void findComponentAndRename(MouseEvent e, String name, JPanel panel) {
        for (Component component : Arrays.asList(panel.getComponents())) {
            if (component.getName().equals(e.getComponent().getName())) {
                if (component instanceof JLabel) {

                    JLabel label = (JLabel) component;
                    label.setName(name);
                    label.setText(name);

                }

            }
        }
    }

    public void updateInstancesInEditionPanel(String name) {
        for (Component component : Arrays.asList(editionPanel.getComponents())) {

            if (component instanceof JLabel) {

                JLabel label = (JLabel) component;
                label.setName(name);

            }

        }
    }

    public void updateInstances() {
        int numInstances = 1;
        for (Component component : Arrays.asList(instancePanel.getComponents())) {
            if (component instanceof JLabel) {
                JLabel instance = (JLabel) component;
                instance.setText(instance.getName() + "(" + numInstances + ")");
                numInstances++;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 1) {
            JLabel label = (JLabel) e.getComponent();

            ImageIcon path = (ImageIcon) label.getIcon();

            imagePreview.setIcon(new ImageIcon(path.getDescription()));
            imagePreview.setText(null);
            //        imagePreview.setIcon(new ImageIcon(label.getName()));
            imagePreview.setBounds(imagePreview.getX() + imagePreview.getWidth() / 2, imagePreview.getY() + imagePreview.getHeight() / 2,
                    label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
        } else if (e.getClickCount() == 2) {
            String Name = JOptionPane.showInputDialog(null, "digite um novo nome");

            this.findComponentAndRename(e, Name, instancePanel);
            this.findComponentAndRename(e, Name, panelObjects);
            this.updateInstances();
            this.updateInstancesInEditionPanel(Name);

        }

    }

}

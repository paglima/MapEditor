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

    public Sprite findComponent(MouseEvent e, JPanel panel) {
        for (Component component : Arrays.asList(panel.getComponents())) {
            if (component.getName().equals(e.getComponent().getName())) {
                if (component instanceof Sprite) {

                    Sprite sprite = (Sprite) component;
                    return sprite;
                   
                }

            }
        }
        return null;
    }

    public void Rename(String name, Sprite sprite) {
        sprite.setName(name);
        sprite.setText(name);
        sprite.setNameText(name);
    }

    public void findComponentAndRename(MouseEvent e, String name, JPanel panel) {
        Sprite sprite = this.findComponent(e, panel);
        this.Rename(name, sprite);
    }

    public void updateInstancesInEditionPanel(String name, Sprite sprite) {
        for (Component component : Arrays.asList(editionPanel.getComponents())) {
            if (component instanceof Sprite) {
                Sprite s = (Sprite) component;
                if (s.getNameFile().equals(sprite.getNameFile())) {
                    s.setNameText(name);
                }
            }
        }

    }

    public void updateInstances() {
        int numInstances = 1;
        for (Component component : Arrays.asList(instancePanel.getComponents())) {
            if (component instanceof Sprite) {

                Sprite instance = (Sprite) component;

                instance.setText(instance.getNameText() + "(" + numInstances + ")");
                numInstances++;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 1) {
            Sprite Sprite = (Sprite) e.getComponent();

            ImageIcon path = (ImageIcon) Sprite.getIcon();

            imagePreview.setIcon(new ImageIcon(path.getDescription()));
            imagePreview.setText(null);
            //        imagePreview.setIcon(new ImageIcon(label.getName()));
            imagePreview.setBounds(imagePreview.getX() + imagePreview.getWidth() / 2, imagePreview.getY() + imagePreview.getHeight() / 2,
                    Sprite.getIcon().getIconWidth(), Sprite.getIcon().getIconHeight());
        } else if (e.getClickCount() == 2) {
            String name = JOptionPane.showInputDialog(null, "digite um novo nome");
            
            Sprite sprite = this.findComponent(e, panelObjects);
            this.findComponentAndRename(e, name, instancePanel);
            this.findComponentAndRename(e, name, panelObjects);
            this.updateInstances();
            this.updateInstancesInEditionPanel(name,sprite);

        }

    }

}

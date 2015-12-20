/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComponentDragger extends MouseAdapter {

     private Component target;

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Container container = (Container) e.getComponent();
        for (Component c : container.getComponents()) {
            if (c.getBounds().contains(e.getPoint())) {
                target = c;
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (target != null) {
            target.setBounds(e.getX(), e.getY(), target.getWidth(), target.getHeight());
            e.getComponent().repaint();
            }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        target = null;
    }

    
}
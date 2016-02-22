/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droptarget;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Leandro
 */
public class DragAndDropWithinPanel extends MouseAdapter implements MouseListener {

    private int pressedX;
    private int pressedY;
    private JPanel actionsPanel;

    protected Point anchorPoint;
    private List<JLabel> listaDeInstancias = new ArrayList<>();

    public DragAndDropWithinPanel() {
    }

    public DragAndDropWithinPanel(List<JLabel> listaDeInstancias, JPanel actionsPanel) {
        this.listaDeInstancias = listaDeInstancias;
        this.actionsPanel = actionsPanel;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
////        distancia entre o click do mouse sobre o objeto e o dragging
//        int dX = e.getX() - pressedX;
//        int dY = e.getY() - pressedY;
//        // atribuindo novo valor da distancia percorrido pelo mouse no componente
//        int newX = e.getComponent().getX() + dX - e.getComponent().getWidth()/4;
//        int newY = e.getComponent().getY() + dY - e.getComponent().getHeight()/2;
//        e.getComponent().setLocation(newX , newY);
        
        this.addBorderOnObject(e);
        
        if (this.getJToggleTranslateSelected()) {
            int anchorX = anchorPoint.x;
            int anchorY = anchorPoint.y;

            Component component = e.getComponent();
            Container container = component.getParent();

            Point parentOnScreen = container.getLocationOnScreen();
            Point mouseOnScreen = e.getLocationOnScreen();
            Point position = new Point(mouseOnScreen.x - parentOnScreen.x - anchorX, mouseOnScreen.y - parentOnScreen.y - anchorY);
            component.setLocation(position);

            //Change Z-Buffer if it is "overbearing"
//        if (overbearing) {
//            container.setComponentZOrder(handle, 0);
//            component.repaint();
//        }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        anchorPoint = e.getPoint();
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       this.addBorderOnObject(e);    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    public void addBorderOnObject(MouseEvent e) {
        for (JLabel label : listaDeInstancias)         
                label.setBorder(null);             
        JLabel label = (JLabel) e.getComponent();
        label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    public boolean getJToggleTranslateSelected() {
        List<Component> comps = Arrays.asList(actionsPanel.getComponents());
        for (Component comp : comps) {
            JToggleButton tbtn = (JToggleButton) comp;
            if (tbtn.getName().equals("Translate") && tbtn.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean getJToggleRotateSelected() {
        List<Component> comps = Arrays.asList(actionsPanel.getComponents());
        for (Component comp : comps) {
            JToggleButton tbtn = (JToggleButton) comp;
            if (tbtn.getName().equals("Rotate") && tbtn.isSelected()) {
                return true;
            }
        }
        return false;
    }


}

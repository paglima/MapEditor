/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droptarget;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Leandro
 */
public class DragAndDropWithinPanel extends MouseAdapter implements MouseListener{
    
    private int pressedX;
    private int pressedY;
    protected Point anchorPoint;
    
    @Override
    public void mouseDragged(MouseEvent e) {
////        distancia entre o click do mouse sobre o objeto e o dragging
//        int dX = e.getX() - pressedX;
//        int dY = e.getY() - pressedY;
//        // atribuindo novo valor da distancia percorrido pelo mouse no componente
//        int newX = e.getComponent().getX() + dX - e.getComponent().getWidth()/4;
//        int newY = e.getComponent().getY() + dY - e.getComponent().getHeight()/2;
//        e.getComponent().setLocation(newX , newY);
        
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

    @Override
    public void mouseMoved(MouseEvent e) {
        anchorPoint = e.getPoint();
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         
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
    
}

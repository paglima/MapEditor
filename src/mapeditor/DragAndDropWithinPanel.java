/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Leandro
 */
public class DragAndDropWithinPanel implements MouseListener, MouseMotionListener{
    
    private int pressedX;
    private int pressedY;
    
    @Override
    public void mouseDragged(MouseEvent e) {
//         distancia percorrida pelo mouse
        int dX = e.getX() - pressedX;
        int dY = e.getY() - pressedY;
        // atribuindo novo valor da distancia percorrido pelo mouse no componente
        int newX = e.getComponent().getX() + dX;
        int newY = e.getComponent().getY() + dY;
        e.getComponent().setLocation(newX, newY);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressedX = e.getX();
        pressedY = e.getY();
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

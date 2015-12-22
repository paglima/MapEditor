/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semUso;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Leandro
 */
public class DragAndDrop implements MouseListener, MouseMotionListener{
      

        // metodos abstratos do Drag And Drop
        
        public void mouseClicked(MouseEvent e) {
               System.out.println(e.getX());
               System.out.println(e.getY());
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("pressionou");
//            JComponent jc = (JComponent) e.getSource();
//            TransferHandler th = jc.getTransferHandler();
//            th.exportAsDrag(jc, e, TransferHandler.COPY);
            //testando
        }

        
        public void mouseReleased(MouseEvent e) {
            System.out.println("soltou");
//            panel.add(e.getComponent());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           e.getComponent().setForeground(Color.blue);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        
      @Override
    public void mouseDragged(MouseEvent e) {
          System.out.println("está arrastando");
    }  
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    

  
    
}

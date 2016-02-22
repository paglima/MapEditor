/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Leandro
 */
public class PreviewSprites extends MouseAdapter implements MouseListener{
    
   
    JLabel imagePreview;
    
    public PreviewSprites(JLabel imagePreview){
       this.imagePreview=imagePreview;
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel) e.getComponent();
    
        ImageIcon path = (ImageIcon)label.getIcon();
        
        imagePreview.setIcon(new ImageIcon(path.getDescription()));      
        imagePreview.setText(null);
//        imagePreview.setIcon(new ImageIcon(label.getName()));
        imagePreview.setBounds(imagePreview.getX()+imagePreview.getWidth()/2, imagePreview.getY()+imagePreview.getHeight()/2,
                               label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
        
    }

    
    
}

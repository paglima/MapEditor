/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droptarget;

import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mapeditor.Sprite;

/**
 *
 * @author pauloarthur
 */
public class DragGestureImpl implements DragGestureListener {
    
    JLabel imagePreview;
    
    
    public DragGestureImpl(JLabel imagePreview){
        this.imagePreview=imagePreview;
    }
    
    
    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        Cursor cursor = null;
        Sprite sprite = (Sprite) event.getComponent();
        
        imagePreview.setText(null);
        ImageIcon path = (ImageIcon)sprite.getIcon();
        imagePreview.setIcon(new ImageIcon(path.getDescription()));
        imagePreview.setBounds(imagePreview.getX()+imagePreview.getWidth()/2, imagePreview.getY()+imagePreview.getHeight()/2,
                               sprite.getIcon().getIconWidth(), sprite.getIcon().getIconHeight());
        
        
        if (event.getDragAction() == DnDConstants.ACTION_COPY) {
            cursor = DragSource.DefaultCopyDrop;
        }
        
        event.startDrag(cursor, new TransferableSprite(sprite));
    }
    
}
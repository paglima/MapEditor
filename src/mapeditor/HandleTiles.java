/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;

/**
 *
 * @author Leandro
 */
public class HandleTiles extends MouseAdapter implements MouseListener{
    JLabel imagePreview;

    public HandleTiles(JLabel imagePreview) {
        this.imagePreview = imagePreview;
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
        } 

    }
    @Override
    public void mousePressed(MouseEvent e) {
        JComponent c = (JComponent)e.getSource();
        TransferHandler handler = c.getTransferHandler();
        handler.exportAsDrag(c, e, TransferHandler.COPY);
    }
    
}

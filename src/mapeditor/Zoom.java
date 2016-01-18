/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class Zoom {

   
    private JPanel editionPanel;
    private int scale = 2;
    private List<Component> jc;

    public Zoom(JPanel editionPanel) {
        jc = Arrays.asList(editionPanel.getComponents());
        this.editionPanel = editionPanel;

    }

    public void zoomIn() {
        
        for (Component component : jc) {
            JLabel label = (JLabel)component;
//            label.setLocation(scaleImageIn(label));
            Image img = null;
            ImageIcon path = (ImageIcon) label.getIcon();
            String description = path.getDescription();
            try {
                img = ImageIO.read(new File(description));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(label.getWidth()*2, label.getHeight()*2,
                    Image.SCALE_SMOOTH);
            
           label.setPreferredSize(new Dimension(label.getWidth()*2,label.getHeight()*2));
           ImageIcon imgScaled = new ImageIcon(dimg);
           imgScaled.setDescription(description);
           label.setIcon(imgScaled);
           scaleEditionPanel();
        }

    }

    public void zoomOut() {
        
        for (Component component : jc) {
            JLabel label = (JLabel) component;
            
            label.setLocation(scaleImageOut(label));
            scaleEditionPanel();
        }

    }

    private Point scaleImageIn(JLabel label) {
        int w = label.getWidth();
        int h = label.getHeight();

        int imageWidth = label.getIcon().getIconWidth() * scale;
        int imageHeight = label.getIcon().getIconHeight() * scale;

        int x = (w - imageWidth) / 2;
        int y = (h - imageHeight) / 2;

        label.setIcon(resizeImage(label, imageWidth, imageHeight));

        return new Point(x, y);
    }

    private Point scaleImageOut(JLabel label) {
        int w = label.getWidth();
        int h = label.getHeight();

        int imageWidth = label.getIcon().getIconWidth() / scale;
        int imageHeight = label.getIcon().getIconHeight() / scale;

        int x = (w - imageWidth) / 2;
        int y = (h - imageHeight) / 2;

        label.setIcon(resizeImage(label, imageWidth, imageHeight));

        return new Point(x, y);
    }

    private ImageIcon resizeImage(JLabel label, int resizeWidth, int resizeHeight) {
        Image img = null;
        ImageIcon path = (ImageIcon) label.getIcon();

        try {
            img = ImageIO.read(new File(path.getDescription()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(resizeWidth, resizeHeight,
                Image.SCALE_SMOOTH);

        return new javax.swing.ImageIcon(dimg);
    }

    private void scaleEditionPanel() {
        System.out.println(editionPanel.getWidth());
        editionPanel.setPreferredSize(new Dimension(editionPanel.getWidth() * scale, editionPanel.getHeight() * scale));
        
    }

}

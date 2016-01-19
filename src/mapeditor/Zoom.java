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
import javax.swing.JScrollPane;

/**
 *
 * @author Leandro
 */
public class Zoom {

    private JPanel editionPanel;
    private JScrollPane scrEditionPane;
    private int scale = 2;
    private List<Component> jc;

    public Zoom(JPanel editionPanel, JScrollPane scrEditionPane) {
        jc = Arrays.asList(editionPanel.getComponents());
        this.editionPanel = editionPanel;
        this.scrEditionPane = scrEditionPane;

    }

    public void zoomIn() {

        for (Component component : jc) {
            JLabel label = (JLabel) component;
//            label.setLocation(scaleImageIn(label));
            Image img = null;
            ImageIcon path = (ImageIcon) label.getIcon();
            String description = path.getDescription();

            try {
                img = ImageIO.read(new File(description));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Image dimg = img.getScaledInstance(label.getWidth() * scale, label.getHeight() * scale,
                    Image.SCALE_SMOOTH);

            label.setSize(new Dimension(label.getWidth() * scale, label.getHeight() * scale));
            label.setPreferredSize(new Dimension(label.getWidth() * scale, label.getHeight() * scale));

            ImageIcon imgScaled = new ImageIcon(dimg);
            imgScaled.setDescription(description);

            label.setIcon(imgScaled);
            zoomInEditionPanel();
        }

    }

    public void zoomOut() {
        if (checkZoomOutLimit()) {
            for (Component component : jc) {
                JLabel label = (JLabel) component;
//            label.setLocation(scaleImageIn(label));
                Image img = null;
                ImageIcon path = (ImageIcon) label.getIcon();
                String description = path.getDescription();

                try {
                    img = ImageIO.read(new File(description));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Image dimg = img.getScaledInstance(label.getWidth() / scale, label.getHeight() / scale,
                        Image.SCALE_SMOOTH);

                label.setSize(new Dimension(label.getWidth() / scale, label.getHeight() / scale));
                label.setPreferredSize(new Dimension(label.getWidth() / scale, label.getHeight() / scale));

                ImageIcon imgScaled = new ImageIcon(dimg);
                imgScaled.setDescription(description);

                label.setIcon(imgScaled);
                zoomOutEditionPanel();
            }
        }

    }

//    private Point scaleImageIn(JLabel label) {
//        int w = label.getWidth();
//        int h = label.getHeight();
//
//        int imageWidth = label.getIcon().getIconWidth() * scale;
//        int imageHeight = label.getIcon().getIconHeight() * scale;
//
//        int x = (w - imageWidth) / 2;
//        int y = (h - imageHeight) / 2;
//
//        label.setIcon(resizeImage(label, imageWidth, imageHeight));
//
//        return new Point(x, y);
//    }
//
//    private Point scaleImageOut(JLabel label) {
//        int w = label.getWidth();
//        int h = label.getHeight();
//
//        int imageWidth = label.getIcon().getIconWidth() / scale;
//        int imageHeight = label.getIcon().getIconHeight() / scale;
//
//        int x = (w - imageWidth) / 2;
//        int y = (h - imageHeight) / 2;
//
//        label.setIcon(resizeImage(label, imageWidth, imageHeight));
//
//        return new Point(x, y);
//    }
//    private ImageIcon resizeImage(JLabel label, int resizeWidth, int resizeHeight) {
//        Image img = null;
//        ImageIcon path = (ImageIcon) label.getIcon();
//
//        try {
//            img = ImageIO.read(new File(path.getDescription()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Image dimg = img.getScaledInstance(resizeWidth, resizeHeight,
//                Image.SCALE_SMOOTH);
//
//        return new javax.swing.ImageIcon(dimg);
//    }
    private void zoomInEditionPanel() {

        editionPanel.setSize(new Dimension(editionPanel.getWidth() * scale, editionPanel.getHeight() * scale));
        editionPanel.setPreferredSize(new Dimension(editionPanel.getWidth() * scale, editionPanel.getHeight() * scale));

    }

    private void zoomOutEditionPanel() {
        // Não pode ser menor que a janela 

        editionPanel.setSize(new Dimension(editionPanel.getWidth() / scale, editionPanel.getHeight() / scale));
        editionPanel.setPreferredSize(new Dimension(editionPanel.getWidth() / scale, editionPanel.getHeight() / scale));

    }

    private boolean checkZoomOutLimit() {
        if (!(editionPanel.getWidth() / 2 < scrEditionPane.getWidth())
                || !(editionPanel.getHeight() / 2 < scrEditionPane.getHeight())) {
            return true;
        } else {
            return false;
        }
    }

}

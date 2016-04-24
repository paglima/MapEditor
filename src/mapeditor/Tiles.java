/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import Utils.FileNameUtils;
import droptarget.DragGestureImpl;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

/**
 *
 * @author Leandro
 */
public class Tiles {

    TilesFrame tf;
    Color color = Color.white;
    Color[] colors = new Color[2];
    List<File> files = new ArrayList<>();
    JPanel editionPanel;
    JPanel tilesPanel;
    JLabel labelPreview;
    ButtonGroup group;
    HandleTiles handleTiles;
    int initialY = 0;
    int initialX = 5;
    int areaTile = 48 * 48;
    int tileWidth = 48;
    int tileHeight = 48;

    public Tiles(JPanel editionPanel, JPanel tilesPanel, HandleTiles handleTiles) {
        this.editionPanel = editionPanel;
        this.tilesPanel = tilesPanel;
        this.handleTiles = handleTiles;
        group = new ButtonGroup();
       
    }

    public void openSettings() {
        tf = new TilesFrame();
        group.add(tf.getBtnRadio32x32());
        group.add(tf.getBtnRadio48x48());
        group.add(tf.getBtnRadio64x64());
        group.add(tf.getBtnRadio96x96());
        group.add(tf.getBtnRadio128x128());

        tf.setVisible(true);
        this.preDefinedValues();
        tf.setDefaultCloseOperation(tf.DISPOSE_ON_CLOSE);

        this.finishSettings();

    }

    public void finishSettings() {
        tf.getBtnOk().addActionListener(btnOk);
        tf.getBtnCancel().addActionListener(btnCancel);
        tf.getBtnColorBackGround().addActionListener(btnColorBackGround);
        tf.getBtnColorBorder().addActionListener(btnColorBorder);

    }

    private void preDefinedValues() {
        tf.getLabelColorBorder().setBackground(Color.black);
        tf.getLabelColorBackground().setBackground(Color.white);

    }

    ActionListener btnOk = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            String dimension = group.getSelection().getActionCommand();

            JOptionPane.showMessageDialog(null, dimension);

            tileWidth = Integer.parseInt(dimension);
            tileHeight = Integer.parseInt(dimension);
            colors[0] = tf.getLabelColorBackground().getBackground();
            colors[1] = tf.getLabelColorBorder().getBackground();

            createTiles();
            tf.dispose();
        }

    };
    ActionListener btnCancel = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.dispose();
        }

    };
    ActionListener btnColorBackGround = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            color = JColorChooser.showDialog(null, "Choose Background Color", color);

            if (color == null) {
                color = Color.white;
            }
            tf.getLabelColorBackground().setBackground(color);

        }

    };
    ActionListener btnColorBorder = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            color = JColorChooser.showDialog(null, "Choose Background Color", color);

            if (color == null) {
                color = Color.black;
            }
            tf.getLabelColorBorder().setBackground(color);

        }

    };

    public void importTiles() {
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int response = fc.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            files = Arrays.asList(fc.getSelectedFiles());
            
            int numFiles = files.size();
            int column = tilesPanel.getWidth() / tileWidth;
            int row = numFiles/column;
            int r=0;
            int c=0;
            int tamX= tileWidth;
            int tamY = tileHeight;
            for (File file : files) {

                JLabel label = new JLabel();
                if(c<column)
                    label.setBounds(tilesPanel.getX()+(tamX* (c++)) ,tilesPanel.getY()+tamY , tileWidth, tileHeight);
                else if(r<row){
                    tamY+=tileHeight;
                    c=0;
                    label.setBounds(tilesPanel.getX()+(tamX* (c++)) ,tilesPanel.getY()+tamY , tileWidth, tileHeight);
                   
                }
                label.setIcon(new ImageIcon(file.getAbsolutePath()));
                label.addMouseListener(handleTiles);
                label.setTransferHandler(new TransferHandler("icon"));

                tilesPanel.add((Component) label);

               
                tilesPanel.revalidate();
                tilesPanel.repaint();
            }

        }
    }

    public void createTiles() {
        int column = editionPanel.getWidth() / tileWidth;
        int row = editionPanel.getHeight() / tileHeight;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                JLabel label = new JLabel();

                label.setBackground(colors[0]);
                Border blackline = BorderFactory.createLineBorder(colors[1]);
                label.setOpaque(true);
                label.setBorder(blackline);

                label.setBounds(tileWidth * j, tileHeight * i, tileWidth, tileHeight);

                label.addMouseListener(handleTiles);
                label.setTransferHandler(new TransferHandler("icon"));
                editionPanel.add(label);
            }
        }
        editionPanel.repaint();
        editionPanel.revalidate();

    }

}

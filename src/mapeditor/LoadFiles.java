/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import Utils.FileNameUtils;
import droptarget.DragGestureImpl;
import java.awt.Component;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class LoadFiles {
        List<File> files = new ArrayList<>();
        JPanel panelObjects;
        JLabel labelPreview;
        JList listaLabels;
        HandleObjects handleObjects;
        int initialY=0;
        
        
        public LoadFiles(JPanel panelObjects, HandleObjects handleObjects, JLabel labelPreview, JList listaLabels){
            this.panelObjects = panelObjects;
            this.handleObjects=handleObjects;
            this.labelPreview=labelPreview;
            this.listaLabels=listaLabels;
        }
    
    public void addInPanelObjects(){
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int response = fc.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            files = Arrays.asList(fc.getSelectedFiles());

            for (File file : files) {

                JLabel label = new JLabel();
                label.setName(file.getName());
                label.setText(FileNameUtils.removeExtension(file.getName()));
                label.setIcon(new ImageIcon(getClass().getResource("/imagens/Images-icon.png"), file.getAbsolutePath()));
                label.setBounds(panelObjects.getX() + 5, initialY, 300, 25);
                label.addMouseListener(handleObjects);

                panelObjects.add((Component) label);

                DragSource ds = new DragSource();
                ds.createDefaultDragGestureRecognizer(label, DnDConstants.ACTION_COPY, new DragGestureImpl(labelPreview));
                initialY = initialY + 26;
            }

        } else {
            return;
        }
        panelObjects.repaint();
        panelObjects.validate();

    }
    
//    public void createAJList(){
//         String labels[] = { "A", "B", "C", "D", "E", "F", "G", "H" }; 
//          listaLabels = new JList(labels);
//          panelObjects.add(listaLabels);
//          panelObjects.repaint();
//            panelObjects.validate();
//   
//    
//    
//    }
    
}

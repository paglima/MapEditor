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

                Sprite sprite = new Sprite();
                sprite.setNameFile(file.getName());
                sprite.setNameText(FileNameUtils.removeExtension(file.getName()));
                sprite.setName(file.getName());
                sprite.setText(FileNameUtils.removeExtension(file.getName()));
                sprite.setIcon(new ImageIcon(getClass().getResource("/imagens/Images-icon.png"), file.getAbsolutePath()));
                sprite.setBounds(panelObjects.getX() + 5, initialY, 300, 25);
                sprite.addMouseListener(handleObjects);

                panelObjects.add((Component) sprite);

                DragSource ds = new DragSource();
                ds.createDefaultDragGestureRecognizer(sprite, DnDConstants.ACTION_COPY, new DragGestureImpl(labelPreview));
                initialY = initialY + 26;
            }

        } else {
            return;
        }
        panelObjects.repaint();
        panelObjects.validate();

    }
//    public void addinTilesPanel(){
//        // Tiles         
//
//
// //Abrindo o File Chooser
//
//        ImageIcon img = null;
//
//        File fileName = null;
//        final JFileChooser fc = new JFileChooser();
//        int response = fc.showOpenDialog(null);
//        if (response == JFileChooser.APPROVE_OPTION) {
//            fileName = fc.getSelectedFile();
//            img = new ImageIcon(fileName.toString());
//
//        } else {
//            return;
//        }
//
//        // Adiciona um novo botão ao lado do botão de abrir conforme é aberto um nova imagem
//        botoes.add(new JButton(""));
//        botoes.get(botoes.size() - 1).setIcon(img);
//
//        // traça um limite para a lista de botões na horizontal
//        if (colunas > 3) {
//            colunas = 0;
//            linhas += 50;
//        }
//
//        // posiciona um botão ao lado do outro corretamente
//        botoes.get(botoes.size() - 1).setBounds(colunas * 50, linhas, 50, 50);
//        colunas++;
//        for (int i = 0; i < botoes.size(); i++) {
//            panelTiles.add((Component) botoes.get(i));
//
//            //Adicionando componentes que realizarão drag and drop
//            botoes.get(i).addMouseListener(dad);
//            botoes.get(i).setTransferHandler(new TransferHandler("icon"));
//
//        }
//        panelTiles.repaint();
//        panelTiles.validate();
//        System.out.println(botoes.size());
//    }
    
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

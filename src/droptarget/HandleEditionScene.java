/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droptarget;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Leandro
 */
public class HandleEditionScene {
    private JPanel actionsPanel;
    private JPanel editionPanel;
    private JPanel instancePanel;
    private JPanel resourcesPanel;
    
    private List<JLabel> listaDeInstancias = new ArrayList<>();

    
    public HandleEditionScene(){
        
    }
    public HandleEditionScene(JPanel actionsPanel, JPanel editionPanel, JPanel instancePanel, JPanel resourcesPanel) {
        this.actionsPanel = actionsPanel;
        this.editionPanel = editionPanel;
        this.instancePanel = instancePanel;
        this.resourcesPanel = resourcesPanel;
    }

   public void addBorderOnObject(MouseEvent e) {
        for (JLabel label : listaDeInstancias) {
            label.setBorder(null);
        }
        JLabel label = (JLabel) e.getComponent();
        label.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
    }

    public boolean getJToggleTranslateSelected() {
        JToggleButton tbtn = (JToggleButton) actionsPanel.getComponent(0); // Component JToggleButton(Translate)
        if (tbtn.isSelected()) {
            return true;
        }
        return false;
    }

    public boolean getJToggleRotateSelected() {
        JToggleButton tbtn = (JToggleButton) actionsPanel.getComponent(1);//Component JToggleButton(Rotate)
        if (tbtn.isSelected()) {
            return true;
        }
        return false;
    }
    
    public void removeAllListaInstancias(){
        this.listaDeInstancias.clear();
    }
    public void removeLabelListaInstancias(JLabel l){
        for(JLabel label : listaDeInstancias){
            if(label ==l)
                listaDeInstancias.remove(l);
        }
    }

    public List<JLabel> getListaDeInstancias() {
        return listaDeInstancias;
    }

    public void setListaDeInstancias(List<JLabel> listaDeInstancias) {
        this.listaDeInstancias = listaDeInstancias;
    }

    
    
}

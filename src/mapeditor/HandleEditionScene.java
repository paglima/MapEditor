/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

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
    
//    private List<JLabel> listaDeInstancias = new ArrayList<>();
    private HandleInstances handleInstances = new HandleInstances(instancePanel);
    
    public HandleEditionScene(){
        
    }
    public HandleEditionScene(JPanel actionsPanel, JPanel editionPanel, JPanel instancePanel, JPanel resourcesPanel) {
        this.actionsPanel = actionsPanel;
        this.editionPanel = editionPanel;
        this.instancePanel = instancePanel;
        this.resourcesPanel = resourcesPanel;
    }

   public void addBorderOnObject(MouseEvent e) {
        for (Component comp : editionPanel.getComponents()) {
            if(comp instanceof JLabel){
                JLabel label =(JLabel)comp;
                label.setBorder(null);
            }
 
        }
        JLabel label = (JLabel) e.getComponent();
        label.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
    }
   public JToggleButton getJToggleButtonTranslate(){
       JToggleButton btnTranslate = null;
        for(Component c : Arrays.asList(actionsPanel.getComponents())){
            if(c instanceof JToggleButton){
                btnTranslate=(JToggleButton)c;
                if(btnTranslate.getName().equals("btnTranslate"))
                    return btnTranslate;
            }
        }
        return null;
   }
   
    public boolean getJToggleTranslateSelected() {
        
//        JToggleButton tbtn = (JToggleButton) actionsPanel.getComponent(0); 
        JToggleButton tbtn = this.getJToggleButtonTranslate();    // Component JToggleButton(Translate)
        if (tbtn.isSelected()) {
            return true;
        }
        return false;
    }
    
    public JToggleButton getJToggleButtonRotate(){
       JToggleButton btnRotate = null;
        for(Component c : Arrays.asList(actionsPanel.getComponents())){
            if(c instanceof JToggleButton){
                btnRotate=(JToggleButton)c;
                if(btnRotate.getName().equals("btnRotate"))
                    return btnRotate;
            }
        }
        return null;
   }
    public boolean getJToggleRotateSelected() {
        JToggleButton tbtn = this.getJToggleButtonRotate();//Component JToggleButton(Rotate)
        if (tbtn.isSelected()) {
            return true;
        }
        return false;
    }
//    public JButton getJButtonDelete(){
//       JButton btnDelete = null;
//        for(Component c : Arrays.asList(actionsPanel.getComponents())){
//            if(c instanceof JButton){
//                btnDelete=(JButton)c;
//                if(btnDelete.getName().equals("btnRotate"))
//                    return btnDelete;
//            }
//        }
//        return null;
//   }
//    public boolean getDeleteSelected() {
//        JButton tbtn = this.getJButtonDelete();//Component JToggleButton(Rotate)
//        if (tbtn.isSelected()) {
//            return true;
//        }
//        return false;
//    }
    
    public void removeAllListaInstancias(){
        this.handleInstances.getInstances().clear();
    }
    public void removeLabelListaInstancias(JLabel l){
        for(JLabel label : handleInstances.getInstances()){
            if(label ==l)
                handleInstances.getInstances().remove(l);
        }
    }
}

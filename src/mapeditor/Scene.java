/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class Scene {
    
    JPanel mainPanel;
    
    public Scene(JPanel mainPanel){
        this.mainPanel=mainPanel;
        configScene();
        
        
    }
    
    public void configScene(){
        SceneFrame sf = new SceneFrame();
        sf.setVisible(true);
        
       
    }
    
}

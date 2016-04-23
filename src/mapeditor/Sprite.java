/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import javax.swing.JLabel;

/**
 *
 * @author Leandro
 */
public class Sprite extends JLabel{
    private String nameFile;
    private String nameText;
    
    public Sprite(){
        
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }
    
    
}

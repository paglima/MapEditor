/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semUso;

import javax.swing.ImageIcon;

/**
 *
 * @author Leandro
 */
public class LoadFiles {
    
    String nome;
    ImageIcon img;
    
    
    
    
    public LoadFiles(String nome, ImageIcon img) {
        this.nome = nome;
        this.img = img;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
    
}

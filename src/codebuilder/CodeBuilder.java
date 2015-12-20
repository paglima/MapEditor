/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author pauloarthur
 */
public class CodeBuilder{
    
    private StringBuilder totalCode;
    
    public CodeBuilder() {
        totalCode = new StringBuilder();
        totalCode.append("from PPlay.window import *")
                 .append("\n")
                 .append("from PPlay.sprite import *")
                 .append("\n\n\n")
                 .append("window = Window(600,400)")
                 .append("\n");
    }
    
    
    public void mountCode(JLabel label){
        String instance = "{0} = Sprite(\"{1}\")";
        String setPosition = "{0}.set_position({1},{2})";
        
        String line1 = MessageFormat.format(instance,label.getName(),label.getIcon());
        String line2 = MessageFormat.format(setPosition,label.getName(),label.getBounds().getX(),label.getBounds().getY());
        
        totalCode.append(line1);
        totalCode.append("\n");
        totalCode.append(line2);
        totalCode.append("\n\n");
    }
    
    public void generateFile(){
        try {
            Formatter fmt = new Formatter(new File("demo.py"));
            fmt.format("%s", totalCode.toString());
            fmt.close();
            totalCode.delete(0, totalCode.length());
            System.out.println("OK!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

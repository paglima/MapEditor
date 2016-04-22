/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebuilder;

import Utils.FileNameUtils;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author pauloarthur
 */
public class CodeBuilder {

    private StringBuilder totalCode;
    private JPanel editionPanel;

    public CodeBuilder(JScrollPane scrEditionPane, JPanel editionPanel) {
        this.editionPanel=editionPanel;
        totalCode = new StringBuilder();
        totalCode.append("from PPlay.window import *")
                .append("\n")
                .append("from PPlay.sprite import *")
                .append("\n\n\n")
                .append("window = Window(")
                .append(scrEditionPane.getWidth())
                .append(",")
                .append(scrEditionPane.getHeight())
                .append(")")
                .append("\n");
    }

    public void mountCode(JLabel instance) {
        String instance1 = "{0} = Sprite(\"{1}\")";
        String setPosition = "{0}.set_position({1},{2})";

        String line1 = MessageFormat.format(instance1, instance.getName(), instance.getName());
        String line2 = MessageFormat.format(setPosition, instance.getName(), instance.getBounds().getX(), instance.getBounds().getY());

        totalCode.append(line1);
        totalCode.append("\n");
        totalCode.append(line2);
        totalCode.append("\n\n");
    }
    
    public void generate(){
        List<Component> components = Arrays.asList(editionPanel.getComponents());

        int count = 0;
        for (Component component : components) {
            if(component instanceof JLabel){
                JLabel instance = (JLabel) component;
                instance.setName(FileNameUtils.removeExtension(instance.getName())+""+ (++count));
                this.mountCode(instance);
            }
        }

        this.generateFile();
    }
    
    
    

    public void generateFile() {
        try {
            Formatter fmt = new Formatter(new File("Scene.py"));
            fmt.format("%s", totalCode.toString());
            fmt.close();
            totalCode.delete(0, totalCode.length());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

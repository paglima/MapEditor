/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import Utils.FileNameUtils;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class HandleInstances {

    List<Sprite> instances = new ArrayList<>();
    JPanel instancePanel;
    int numInstances = 0;
    int countInstances = 0;
    int posX = 5;
    int posY = 20;
    int width = 300;
    int height = 25;

    public HandleInstances(JPanel instancePanel) {
        this.instancePanel = instancePanel;
    }

    public void addInstance(Sprite sprite) {
        instancePanel.removeAll();

        Sprite instance = new Sprite();
        instance.setNameFile(sprite.getNameFile());
        instance.setNameText(sprite.getNameText());
        instance.setName(sprite.getName());
        instance.setText(sprite.getNameText() + "(" + numInstances + ")");
        instance.setBounds(instancePanel.getX() + posX, (instances.size() * posY), width, height);
        this.instances.add(instance);
        numInstances++;

        for (Sprite s : instances) {
            s.setLocation(instancePanel.getX() + posX, (countInstances * posY));
            this.instancePanel.add(s);
            countInstances++;
        }

        countInstances = 0;

        instancePanel.repaint();
        instancePanel.validate();
    }

//    public void updateInstances() {
//        
//        JOptionPane.showMessageDialog(null, "p1");
//        numInstances=1;
//        for (Component component : Arrays.asList(instancePanel.getComponents())) {
//            JOptionPane.showMessageDialog(null, "p2");
//            if (component instanceof JLabel) {
//                JOptionPane.showMessageDialog(null, "p3");
//                JLabel instance = (JLabel) component;
//                instance.setText(instance.getName()+ "(" + numInstances + ")");
//                numInstances++;
//            }
//        }
//    }

    public void removeInstance(int i) {
        instances.remove(i);
        JOptionPane.showMessageDialog(null, instances.size());

        for (JLabel l : instances) {
            l.setLocation(instancePanel.getX() + posX, (countInstances * posY));
            this.instancePanel.add(l);
            countInstances++;
        }
        countInstances = 0;

        instancePanel.repaint();
        instancePanel.validate();
    }

    public void setInstances(List<Sprite> instances) {
        this.instances = instances;
    }

    public List<Sprite> getInstances() {
        return instances;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class HandleInstances {

    List<JLabel> instances = new ArrayList<>();
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

    public void addInstance(JLabel label) {
        instancePanel.removeAll();

        JLabel instance = new JLabel();

        instance.setText(FileNameUtils.removeExtension(label.getName()) + "(" + numInstances + ")");
        instance.setBounds(instancePanel.getX() + posX, (instances.size() * posY), width, height);
        this.instances.add(instance);
        numInstances++;

        for (JLabel l : instances) {
            l.setLocation(instancePanel.getX() + posX, (countInstances * posY));
            this.instancePanel.add(l);
            countInstances++;
        }

        countInstances = 0;

        instancePanel.repaint();
        instancePanel.validate();
    }

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

    public void setInstances(List<JLabel> instances) {
        this.instances = instances;
    }

    public List<JLabel> getInstances() {
        return instances;
    }

}

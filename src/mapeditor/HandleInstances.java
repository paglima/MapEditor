/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Leandro
 */
public class HandleInstances {

    List<JLabel> instances = new ArrayList<>();
    JPanel instancePanel;
    int posX = 5;
    int posY = 20;
    int width = 300;
    int height = 25;

    public HandleInstances(JPanel instancePanel) {
        this.instancePanel = instancePanel;
    }

    public void addInstance (JLabel label) {
        JLabel instance = new JLabel();
//        instance.setBounds(instancePanel.getX() + 5, initialY, 300, 25);
        instance.setText(label.getName());
        this.instances.add(instance);
        this.addInstanceInPanel();

        instancePanel.repaint();
        instancePanel.validate();
    }

    private void addInstanceInPanel() {
//        instancePanel.removeAll();
        for (JLabel instance : instances) {
            instance.setText(instance.getText() +"(" + this.instances.get(this.instances.indexOf(instance))+")" );
            instance.setBounds(instancePanel.getX() + posX, instancePanel.getY() + (instances.indexOf(instance) + posY), width, height);
            this.instancePanel.add(instance);
        }
    }

    public void setInstances(List<JLabel> instances) {
        this.instances = instances;
    }

    public List<JLabel> getInstances() {
        return instances;
    }

}

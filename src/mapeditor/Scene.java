/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Leandro
 */
public class Scene {

    JPanel editionPanel;
    JScrollPane scrEditionPane;

    SceneFrame sf;

    int widthScene;
    int heightScene;
    int widthWindow;
    int heightWindow;

    Color color = Color.white;

    public Scene(JPanel editionPanel, JScrollPane scrEditionPane) {
        this.editionPanel = editionPanel;
        this.scrEditionPane = scrEditionPane;
        openSettings();

    }

    public void openSettings() {
        sf = new SceneFrame();
        sf.setVisible(true);
        this.preDefinedValues();
        sf.setDefaultCloseOperation(sf.DISPOSE_ON_CLOSE);
        
        
        
        this.finishSettings();

    }

    public void finishSettings() {
        sf.getBtnOk().addActionListener(btnOk);
        sf.getBtnCancel().addActionListener(btnCancel);
        sf.getBtnColor().addActionListener(btnColor);

    }
    private void preDefinedValues(){
        sf.getWidthWindowField().setText(Integer.toString(scrEditionPane.getSize().width));
        sf.getHeightWindowField().setText(Integer.toString(scrEditionPane.getSize().height));
        sf.getWidthSceneField().setText(Integer.toString(editionPanel.getSize().width));
        sf.getHeightSceneField().setText(Integer.toString(editionPanel.getSize().height));
    }

    ActionListener btnOk = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                widthScene = Integer.parseInt(sf.getWidthSceneField().getText());
                heightScene = Integer.parseInt(sf.getHeightSceneField().getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Preencha os campos da cena com valores inteiros");
                return;
            }

            try {
                widthWindow = Integer.parseInt(sf.getWidthWindowField().getText());
                heightWindow = Integer.parseInt(sf.getHeightWindowField().getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Preencha os campos da janela com valores inteiros");
                return;
            }

            editionPanel.setSize(new Dimension(widthScene, heightScene));
            editionPanel.setPreferredSize(new Dimension(widthScene, heightScene));

            scrEditionPane.setSize(new Dimension(widthWindow, heightWindow));
            scrEditionPane.setPreferredSize(new Dimension(widthWindow, heightWindow));

            editionPanel.setBackground(color);

            sf.dispose();
        }

    };
    ActionListener btnCancel = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            sf.dispose();
        }

    };
    ActionListener btnColor = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            color = JColorChooser.showDialog(null, "Choose Background Color", color);

            if (color == null) {
                color = Color.white;
            }
            sf.getColorPanel().setBackground(color);

        }

    };

}

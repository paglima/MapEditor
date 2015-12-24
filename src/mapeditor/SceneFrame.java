/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author Leandro
 */
public class SceneFrame extends javax.swing.JFrame {

    
    public SceneFrame() {
        initComponents();
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(JButton btnColor) {
        this.btnColor = btnColor;
    }

    public JToggleButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(JToggleButton btnOk) {
        this.btnOk = btnOk;
    }

    public JPanel getColorPanel() {
        return colorPanel;
    }

    public void setColorPanel(JPanel colorPanel) {
        this.colorPanel = colorPanel;
    }

    public JTextField getHeightSceneField() {
        return heightSceneField;
    }

    public void setHeightSceneField(JTextField heightSceneField) {
        this.heightSceneField = heightSceneField;
    }

    public JLabel getHeightSceneLabel() {
        return heightSceneLabel;
    }

    public void setHeightSceneLabel(JLabel heightSceneLabel) {
        this.heightSceneLabel = heightSceneLabel;
    }

    public JTextField getHeightWindowField() {
        return heightWindowField;
    }

    public void setHeightWindowField(JTextField heightWindowField) {
        this.heightWindowField = heightWindowField;
    }

    public JLabel getHeightWindowLabel() {
        return heightWindowLabel;
    }

    public void setHeightWindowLabel(JLabel heightWindowLabel) {
        this.heightWindowLabel = heightWindowLabel;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getSceneLabel() {
        return sceneLabel;
    }

    public void setSceneLabel(JLabel sceneLabel) {
        this.sceneLabel = sceneLabel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getWidthSceneField() {
        return widthSceneField;
    }

    public void setWidthSceneField(JTextField widthSceneField) {
        this.widthSceneField = widthSceneField;
    }

    public JLabel getWidthSceneLabel() {
        return widthSceneLabel;
    }

    public void setWidthSceneLabel(JLabel widthSceneLabel) {
        this.widthSceneLabel = widthSceneLabel;
    }

    public JTextField getWidthWindowField() {
        return widthWindowField;
    }

    public void setWidthWindowField(JTextField widthWindowField) {
        this.widthWindowField = widthWindowField;
    }

    public JLabel getWidthWindowLabel() {
        return widthWindowLabel;
    }

    public void setWidthWindowLabel(JLabel widthWindowLabel) {
        this.widthWindowLabel = widthWindowLabel;
    }

    public JLabel getWindowLabel() {
        return windowLabel;
    }

    public void setWindowLabel(JLabel windowLabel) {
        this.windowLabel = windowLabel;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        widthSceneField = new javax.swing.JTextField();
        widthSceneLabel = new javax.swing.JLabel();
        heightSceneLabel = new javax.swing.JLabel();
        heightSceneField = new javax.swing.JTextField();
        btnOk = new javax.swing.JToggleButton();
        btnCancel = new javax.swing.JButton();
        btnColor = new javax.swing.JButton();
        colorPanel = new javax.swing.JPanel();
        sceneLabel = new javax.swing.JLabel();
        widthWindowLabel = new javax.swing.JLabel();
        widthWindowField = new javax.swing.JTextField();
        heightWindowLabel = new javax.swing.JLabel();
        heightWindowField = new javax.swing.JTextField();
        windowLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titleLabel.setText("Settings Window and Scene");

        widthSceneLabel.setText("Width");

        heightSceneLabel.setText("Height");

        btnOk.setText("Ok");

        btnCancel.setText("Cancel");

        btnColor.setText("Color Background");

        colorPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        sceneLabel.setText("Setting Scene");

        widthWindowLabel.setText("Width");

        widthWindowField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthWindowFieldActionPerformed(evt);
            }
        });

        heightWindowLabel.setText("Height");

        windowLabel.setText("Setting Window");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(widthSceneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(widthWindowLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(widthSceneField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(heightSceneLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(widthWindowField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(heightWindowLabel)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(heightSceneField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(heightWindowField))
                            .addGap(77, 77, 77))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(130, 130, 130)
                                    .addComponent(btnCancel))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(windowLabel)
                                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap()))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(sceneLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(windowLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(widthWindowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(widthWindowLabel)
                    .addComponent(heightWindowLabel)
                    .addComponent(heightWindowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sceneLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(widthSceneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(widthSceneLabel)
                    .addComponent(heightSceneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightSceneLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void widthWindowFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthWindowFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_widthWindowFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnColor;
    private javax.swing.JToggleButton btnOk;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JTextField heightSceneField;
    private javax.swing.JLabel heightSceneLabel;
    private javax.swing.JTextField heightWindowField;
    private javax.swing.JLabel heightWindowLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sceneLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField widthSceneField;
    private javax.swing.JLabel widthSceneLabel;
    private javax.swing.JTextField widthWindowField;
    private javax.swing.JLabel widthWindowLabel;
    private javax.swing.JLabel windowLabel;
    // End of variables declaration//GEN-END:variables
}

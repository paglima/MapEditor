package mapeditor;

import codebuilder.CodeBuilder;
import droptarget.DragGestureImpl;
import droptarget.DropTargetImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Leandro
 */
public class Interface1 extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    ArrayList<JButton> botoes = new ArrayList<JButton>();
    ArrayList<JLabel> lblSprites = new ArrayList<JLabel>();
    ArrayList<JLabel> imagensCarregadas = new ArrayList<JLabel>();
    List<File> files = new ArrayList<>();
    List<LoadFiles> filesNameImg = new ArrayList<>();
    List<JLabel> spritesDoPanel = new ArrayList<>();
    JLabel selecionado = new JLabel("");

    int larguraPainel = 200;
    int colunas = 1;
    int linhas = 0;
    ComponentDragger dragger = new ComponentDragger();

    // resopnsavel pela execução do drag and drop utilizando o mouse.
    DragAndDrop dad = new DragAndDrop();
    DragAndDropWithinPanel dadwp = new DragAndDropWithinPanel();
    MouseMotionListener ma = new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

//            label1.setLocation(e.getX() - 15, e.getY() - 15);
        }
    };
    MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Component component = e.getComponent();
            component.setForeground(Color.red);
            
            spritesDoPanel.add(new JLabel(""));
            spritesDoPanel.get(spritesDoPanel.size() - 1).setBounds(e.getX(), e.getY(), 48, 48);
            for (int i = 0; i < imagensCarregadas.size(); i++) {
                if (imagensCarregadas.get(i).getForeground() == Color.red) {
                    spritesDoPanel.get(spritesDoPanel.size() - 1).setIcon(new ImageIcon(files.get(i).getAbsolutePath()));
                    spritesDoPanel.get(spritesDoPanel.size() - 1).setForeground(Color.black);
                }

            }
            spritesDoPanel.get(spritesDoPanel.size() - 1).setVisible(false);

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            spritesDoPanel.get(spritesDoPanel.size() - 1).setVisible(true);
            panel2.add((Component) spritesDoPanel.get(spritesDoPanel.size() - 1));

            spritesDoPanel.get(spritesDoPanel.size() - 1).removeMouseListener(ml);
            spritesDoPanel.get(spritesDoPanel.size() - 1).removeMouseMotionListener(ma);
            spritesDoPanel.get(spritesDoPanel.size() - 1).addMouseListener(dadwp);
            spritesDoPanel.get(spritesDoPanel.size() - 1).addMouseMotionListener(dadwp);

            panel2.removeMouseListener(ml);
            panel2.removeMouseMotionListener(ma);
            panel2.addMouseListener(dadwp);
            panel2.addMouseMotionListener(dadwp);
            panel2.repaint();
            panel2.validate();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    };

    public JLabel createLabel() {
        //cria um label com um quadrado brando como icone.
        JLabel l1 = new JLabel();
        l1.setIcon(new ImageIcon(getClass().getResource("/imagens/whiteSquare.png")));
        //adicionando ao mouseListener para interagir como drag and drop
        l1.addMouseListener(dad);
        l1.setTransferHandler(new TransferHandler("icon"));

        return l1;
    }

    public void addLabelGrid() {
        for (int i = 0; i < 100; i++) {
            panel2.add(createLabel());
        }

    }

    public Interface1() {
        initComponents();
        DropTargetImpl dropTargetImpl = new DropTargetImpl(panel2);
        
        MouseListener mouL = new MouseListener() {

            public Point point;
            
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                this.point = e.getLocationOnScreen();
                System.out.println("On mouse" + e.getLocationOnScreen());
            }
            
        };
        
        panel2.addMouseListener(mouL);
        
        
        
        //addLabelGrid();
//        panel2.addMouseListener(ml);
//        panel2.setTransferHandler(new TransferHandler("icon"));

        panel2.setBackground(Color.white);
        panel2.addMouseListener(ml);
        panel2.addMouseMotionListener(ma);

//        panelTiles.addMouseListener(dragger);
//        panelTiles.addMouseMotionListener(dragger);
//        panelObjetos.addMouseListener(dragger);
//        panelObjetos.addMouseMotionListener(dragger);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrpanel1 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        scrpanel2 = new javax.swing.JScrollPane();
        panel1 = new javax.swing.JTabbedPane();
        panelObjetos = new javax.swing.JPanel();
        panelTiles = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        toolBar1 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        btnSprite = new javax.swing.JButton();
        btnBackGround = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnImportSrpites = new javax.swing.JButton();
        panelPreview = new javax.swing.JPanel();
        labelPreview = new javax.swing.JLabel();
        mb1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu1 = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelObjetosLayout = new javax.swing.GroupLayout(panelObjetos);
        panelObjetos.setLayout(panelObjetosLayout);
        panelObjetosLayout.setHorizontalGroup(
            panelObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        panelObjetosLayout.setVerticalGroup(
            panelObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        panel1.addTab("Objects", panelObjetos);

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Open-folder-add-icon.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTilesLayout = new javax.swing.GroupLayout(panelTiles);
        panelTiles.setLayout(panelTilesLayout);
        panelTilesLayout.setHorizontalGroup(
            panelTilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTilesLayout.createSequentialGroup()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        panelTilesLayout.setVerticalGroup(
            panelTilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTilesLayout.createSequentialGroup()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 593, Short.MAX_VALUE))
        );

        panel1.addTab("Tiles", panelTiles);

        scrpanel2.setViewportView(panel1);

        toolBar1.setRollover(true);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Document-Blank-icon.png"))); // NOI18N
        toolBar1.add(jButton8);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/open-file-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Actions-document-save-icon.png"))); // NOI18N
        toolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Undo-icon.png"))); // NOI18N
        toolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Redo-icon.png"))); // NOI18N
        toolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom-Out-icon.png"))); // NOI18N
        toolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom-In-icon.png"))); // NOI18N
        toolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Data-Grid-icon.png"))); // NOI18N
        toolBar1.add(jButton7);

        panel2.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        btnSprite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Grass-icon48x48.png"))); // NOI18N
        btnSprite.setText("Add Sprites");
        btnSprite.setPreferredSize(new java.awt.Dimension(48, 48));
        btnSprite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpriteActionPerformed(evt);
            }
        });

        btnBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/terreno1.png"))); // NOI18N
        btnBackGround.setText("Add Background");
        btnBackGround.setPreferredSize(new java.awt.Dimension(48, 48));
        btnBackGround.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackGroundActionPerformed(evt);
            }
        });

        jButton10.setText("Compile ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnImportSrpites.setText("import Sprites");
        btnImportSrpites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportSrpitesActionPerformed(evt);
            }
        });

        labelPreview.setText("jLabel1");

        javax.swing.GroupLayout panelPreviewLayout = new javax.swing.GroupLayout(panelPreview);
        panelPreview.setLayout(panelPreviewLayout);
        panelPreviewLayout.setHorizontalGroup(
            panelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPreviewLayout.setVerticalGroup(
            panelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(panelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(68, 68, 68))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(scrpanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(toolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImportSrpites)
                        .addGap(32, 32, 32)
                        .addComponent(btnSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap(552, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(toolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImportSrpites))))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(scrpanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(457, Short.MAX_VALUE))
        );

        scrpanel1.setViewportView(panelPrincipal);

        jMenu1.setText("Arquivo");

        Menu1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Menu1.setText("Novo");
        Menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu1ActionPerformed(evt);
            }
        });
        jMenu1.add(Menu1);

        menu2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menu2.setText("NovoTiles");
        menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2ActionPerformed(evt);
            }
        });
        jMenu1.add(menu2);

        mb1.add(jMenu1);

        jMenu2.setText("Editar");
        mb1.add(jMenu2);

        jMenu3.setText("Ferramentas");
        mb1.add(jMenu3);

        jMenu4.setText("Janela");
        mb1.add(jMenu4);

        jMenu5.setText("Sobre");
        mb1.add(jMenu5);

        setJMenuBar(mb1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpanel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrpanel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu1ActionPerformed

    }//GEN-LAST:event_Menu1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // Abrindo o File Chooser

        ImageIcon img = null;

        File fileName = null;
        final JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile();
            img = new ImageIcon(fileName.toString());

        } else {
            return;
        }

        // Adiciona um novo botão ao lado do botão de abrir conforme é aberto um nova imagem
        botoes.add(new JButton(""));
        botoes.get(botoes.size() - 1).setIcon(img);

        // traça um limite para a lista de botões na horizontal
        if (colunas > 3) {
            colunas = 0;
            linhas += 50;
        }

        // posiciona um botão ao lado do outro corretamente
        botoes.get(botoes.size() - 1).setBounds(colunas * 50, linhas, 50, 50);
        colunas++;
        for (int i = 0; i < botoes.size(); i++) {
            panelTiles.add((Component) botoes.get(i));

            //Adicionando componentes que realizarão drag and drop
            botoes.get(i).addMouseListener(dad);
            botoes.get(i).setTransferHandler(new TransferHandler("icon"));

        }
        panelTiles.repaint();
        panelTiles.validate();
        System.out.println(botoes.size());


    }//GEN-LAST:event_btn1ActionPerformed

    private void btnSpriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpriteActionPerformed
        ImageIcon img = null;

        File fileName = null;
        final JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile();
            img = new ImageIcon(fileName.toString());
        } else {
            return;
        }

        lblSprites.add(new JLabel(""));
        lblSprites.get(lblSprites.size() - 1).setIcon(img);

        lblSprites.get(lblSprites.size() - 1).setBounds(0, lblSprites.size() * 50, img.getIconWidth(), img.getIconHeight());

        for (int i = 0; i < lblSprites.size(); i++) {
//            panelObjetos.add((Component) lblSprites.get(i));
            panel2.add((Component) lblSprites.get(i));

            //Adicionando componentes que realizarão drag and drop
//            lblSprites.get(i).addMouseListener(ml);
//            lblSprites.get(i).setTransferHandler(new TransferHandler("icon"));
        }
//        panelObjetos.repaint();
//        panelObjetos.validate();
        panel2.repaint();
        panel2.validate();
        System.out.println(lblSprites.size());

    }//GEN-LAST:event_btnSpriteActionPerformed

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed

    }//GEN-LAST:event_menu2ActionPerformed

    private void btnBackGroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackGroundActionPerformed
        ImageIcon img = null;

        File fileName = null;
        final JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile();
            img = new ImageIcon(fileName.toString());
        } else {
            return;
        }

        JLabel background = new JLabel("");
        background.setIcon(img);
        background.setBounds(panel2.getBounds());

        panel2.add((Component) background);
        panel2.repaint();
        panel2.validate();
    }//GEN-LAST:event_btnBackGroundActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        CodeBuilder cb = new CodeBuilder();
        List<Component> components = Arrays.asList(panel2.getComponents());

        int count = 0;
        for (Component component : components) {
            JLabel label = (JLabel) component;
            label.setName("sprite" + (++count));
            cb.mountCode(label);
        }

        cb.generateFile();

    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnImportSrpitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportSrpitesActionPerformed

        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            files = Arrays.asList(fc.getSelectedFiles());

            int initialY = 0;
            
            for (File file : files) {
                JLabel label = new JLabel("");
                label.setText(file.getName());
                label.setName(file.getName());
                label.setIcon(new ImageIcon(getClass().getResource("/imagens/Images-icon.png")));
                label.setBounds(panelObjetos.getX() + 5, initialY , 100, 25);
                label.addMouseListener(ml);
                label.addMouseMotionListener(ma);
                panelObjetos.add((Component) label);
                filesNameImg.add(new LoadFiles(file.getName(), new ImageIcon(file.getAbsolutePath())));
                
                DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(label, DnDConstants.ACTION_COPY, new DragGestureImpl());
                initialY = initialY + 26;
            }

        } else {
            return;
        }
        panelObjetos.repaint();
        panelObjetos.validate();

    }//GEN-LAST:event_btnImportSrpitesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Menu1;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnBackGround;
    private javax.swing.JButton btnImportSrpites;
    private javax.swing.JButton btnSprite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JMenuBar mb1;
    private javax.swing.JMenuItem menu2;
    private javax.swing.JTabbedPane panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panelObjetos;
    private javax.swing.JPanel panelPreview;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTiles;
    private javax.swing.JScrollPane scrpanel1;
    private javax.swing.JScrollPane scrpanel2;
    private javax.swing.JToolBar toolBar1;
    // End of variables declaration//GEN-END:variables
}

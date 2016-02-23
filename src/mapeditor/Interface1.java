package mapeditor;

import droptarget.DragAndDropWithinPanel;
import semUso.LoadFiles;
import codebuilder.CodeBuilder;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import droptarget.DragGestureImpl;
import droptarget.DropTargetImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import json.JsonLabel;
import json.JsonParser;

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
    PreviewSprites pp;
    Zoom zoom;
    
    int larguraPainel = 200;
    int colunas = 1;
    int linhas = 0;
    int initialY = 0;
    
    // resopnsavel pela execução do drag and drop utilizando o mouse.
//    DragAndDrop dad = new DragAndDrop();
    
//    public JLabel createLabel() {
//        //cria um label com um quadrado brando como icone.
//        JLabel l1 = new JLabel();
//        l1.setIcon(new ImageIcon(getClass().getResource("/imagens/whiteSquare.png")));
//        //adicionando ao mouseListener para interagir como drag and drop
//        l1.addMouseListener(dad);
//        l1.setTransferHandler(new TransferHandler("icon"));
//
//        return l1;
//    }

//    public void addLabelGrid() {
//        for (int i = 0; i < 100; i++) {
//            panel2.add(createLabel());
//        }
//
//    }

    public Interface1() {        
        initComponents();
        
        pp = new PreviewSprites(labelPreview);
        DropTargetImpl dropTargetImpl = new DropTargetImpl(editionPanel,instancePanel,actionsPanel);
        
        editionPanel.setBackground(Color.white);
//        panel2.addMouseListener(new ComponentDragger());
//        panel2.addMouseMotionListener(new ComponentDragger());
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrMainPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        scrObjectsPanel = new javax.swing.JScrollPane();
        objectsPanel = new javax.swing.JTabbedPane();
        panelObjetos = new javax.swing.JPanel();
        instancePanel = new javax.swing.JPanel();
        panelTiles = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        scrPreviewPanel = new javax.swing.JScrollPane();
        panelPreview = new javax.swing.JPanel();
        labelPreview = new javax.swing.JLabel();
        scrEditionPane = new javax.swing.JScrollPane();
        editionPanel = new javax.swing.JPanel();
        actionsPanel = new javax.swing.JPanel();
        btnTranslate = new javax.swing.JToggleButton();
        btnRotate = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnImportSrpites = new javax.swing.JButton();
        btnCompile = new javax.swing.JButton();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNewFile = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnGridLayout = new javax.swing.JButton();
        mb1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu1 = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        objectsPanel.setToolTipText("");

        panelObjetos.setToolTipText("Painel de Objetos");

        javax.swing.GroupLayout panelObjetosLayout = new javax.swing.GroupLayout(panelObjetos);
        panelObjetos.setLayout(panelObjetosLayout);
        panelObjetosLayout.setHorizontalGroup(
            panelObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        panelObjetosLayout.setVerticalGroup(
            panelObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        objectsPanel.addTab("Objects", panelObjetos);

        instancePanel.setToolTipText("Painel de Instâncias");

        javax.swing.GroupLayout instancePanelLayout = new javax.swing.GroupLayout(instancePanel);
        instancePanel.setLayout(instancePanelLayout);
        instancePanelLayout.setHorizontalGroup(
            instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        instancePanelLayout.setVerticalGroup(
            instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        objectsPanel.addTab("Instances", instancePanel);

        panelTiles.setToolTipText("Painel Tiles");

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
                .addContainerGap(265, Short.MAX_VALUE))
        );
        panelTilesLayout.setVerticalGroup(
            panelTilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTilesLayout.createSequentialGroup()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 593, Short.MAX_VALUE))
        );

        objectsPanel.addTab("Tiles", panelTiles);

        scrObjectsPanel.setViewportView(objectsPanel);

        panelPreview.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelPreviewLayout = new javax.swing.GroupLayout(panelPreview);
        panelPreview.setLayout(panelPreviewLayout);
        panelPreviewLayout.setHorizontalGroup(
            panelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPreviewLayout.setVerticalGroup(
            panelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrPreviewPanel.setViewportView(panelPreview);

        scrEditionPane.setPreferredSize(new java.awt.Dimension(800, 600));

        editionPanel.setPreferredSize(new java.awt.Dimension(1024, 768));

        javax.swing.GroupLayout editionPanelLayout = new javax.swing.GroupLayout(editionPanel);
        editionPanel.setLayout(editionPanelLayout);
        editionPanelLayout.setHorizontalGroup(
            editionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        editionPanelLayout.setVerticalGroup(
            editionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        scrEditionPane.setViewportView(editionPanel);

        actionsPanel.setBackground(new java.awt.Color(204, 204, 204));
        actionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        btnTranslate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/move-icon.png"))); // NOI18N
        btnTranslate.setToolTipText("Movimenta imagem/sprite");
        btnTranslate.setName("Translate"); // NOI18N
        btnTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranslateActionPerformed(evt);
            }
        });

        btnRotate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Actions-transform-rotate-icon.png"))); // NOI18N
        btnRotate.setToolTipText("Rotaciona imagem/sprite");
        btnRotate.setName("Rotate"); // NOI18N

        jLabel1.setText("Translate");

        jLabel2.setText("Rotate");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/image-remove-icon.png"))); // NOI18N
        jButton1.setToolTipText("Deleta imagem/sprite");

        jLabel3.setText("Delete");

        javax.swing.GroupLayout actionsPanelLayout = new javax.swing.GroupLayout(actionsPanel);
        actionsPanel.setLayout(actionsPanelLayout);
        actionsPanelLayout.setHorizontalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(btnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        actionsPanelLayout.setVerticalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(btnTranslate)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRotate)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resources"));

        btnImportSrpites.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/image-add-icon.png"))); // NOI18N
        btnImportSrpites.setToolTipText("Importa imagens/sprites");
        btnImportSrpites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportSrpitesActionPerformed(evt);
            }
        });

        btnCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/binary-icon.png"))); // NOI18N
        btnCompile.setToolTipText("Gerar código Python para PPLAY");
        btnCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompileActionPerformed(evt);
            }
        });

        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom-In-icon.png"))); // NOI18N
        btnZoomIn.setToolTipText("zoom +");
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });

        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom-Out-icon.png"))); // NOI18N
        btnZoomOut.setToolTipText("zoom -");
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnImportSrpites, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompile, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnZoomIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(1, 1, 1))
                        .addComponent(btnCompile, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImportSrpites, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        btnNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Document-Blank-icon.png"))); // NOI18N
        btnNewFile.setToolTipText("Novo cenário");
        btnNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFileActionPerformed(evt);
            }
        });

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/open-file-icon.png"))); // NOI18N
        btnLoad.setToolTipText("Carrega cenário");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Actions-document-save-icon.png"))); // NOI18N
        btnSave.setToolTipText("Salva cenário");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnGridLayout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Data-Grid-icon.png"))); // NOI18N
        btnGridLayout.setToolTipText("Grid layout(para tiles)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGridLayout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGridLayout)
                    .addComponent(btnSave)
                    .addComponent(btnLoad)
                    .addComponent(btnNewFile))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrObjectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(scrPreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(scrEditionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(392, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(scrObjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrPreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(actionsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrEditionPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(491, Short.MAX_VALUE))
        );

        scrMainPanel.setViewportView(mainPanel);

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
            .addComponent(scrMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu1ActionPerformed

    }//GEN-LAST:event_Menu1ActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try {
            ImageIcon img = null;
            File file = null;
            FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("json files (*.json)","json");
            final JFileChooser fc = new JFileChooser();
            fc.setFileFilter(jsonFilter);
            int response = fc.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                img = new ImageIcon(file.toString());
            } else {
                return;
            }
            Gson gson = new Gson();
            List<JsonLabel> jsonLabels =  Arrays.asList( gson.fromJson(new FileReader(file), JsonLabel[].class));
            
            for (JsonLabel jsonLabel : jsonLabels) {
                JLabel sprite = new JLabel(jsonLabel.getName());
                sprite.setIcon(new ImageIcon(jsonLabel.getPath()));
                sprite.setBounds(jsonLabel.getPositionX(), jsonLabel.getPositionY(),sprite.getIcon().getIconWidth(), sprite.getIcon().getIconHeight());
                sprite.addMouseListener(new DragAndDropWithinPanel());
                sprite.addMouseMotionListener(new DragAndDropWithinPanel());
                editionPanel.add((Component)sprite);
            }
            
            editionPanel.repaint();
            editionPanel.validate();
        } catch (Exception ex) {
            //error
        }

    }//GEN-LAST:event_btnLoadActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
// Tiles         


// Abrindo o File Chooser

//        ImageIcon img = null;
//
//        File fileName = null;
//        final JFileChooser fc = new JFileChooser();
//        int response = fc.showOpenDialog(this);
//        if (response == JFileChooser.APPROVE_OPTION) {
//            fileName = fc.getSelectedFile();
//            img = new ImageIcon(fileName.toString());
//
//        } else {
//            return;
//        }
//
//        // Adiciona um novo botão ao lado do botão de abrir conforme é aberto um nova imagem
//        botoes.add(new JButton(""));
//        botoes.get(botoes.size() - 1).setIcon(img);
//
//        // traça um limite para a lista de botões na horizontal
//        if (colunas > 3) {
//            colunas = 0;
//            linhas += 50;
//        }
//
//        // posiciona um botão ao lado do outro corretamente
//        botoes.get(botoes.size() - 1).setBounds(colunas * 50, linhas, 50, 50);
//        colunas++;
//        for (int i = 0; i < botoes.size(); i++) {
//            panelTiles.add((Component) botoes.get(i));
//
//            //Adicionando componentes que realizarão drag and drop
//            botoes.get(i).addMouseListener(dad);
//            botoes.get(i).setTransferHandler(new TransferHandler("icon"));
//
//        }
//        panelTiles.repaint();
//        panelTiles.validate();
//        System.out.println(botoes.size());


    }//GEN-LAST:event_btn1ActionPerformed

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed

    }//GEN-LAST:event_menu2ActionPerformed

    private void btnCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompileActionPerformed
        CodeBuilder cb = new CodeBuilder();
        List<Component> components = Arrays.asList(editionPanel.getComponents());

        int count = 0;
        for (Component component : components) {
            JLabel label = (JLabel) component;
            label.setName("sprite" + (++count));
            cb.mountCode(label);
        }

        cb.generateFile();

    }//GEN-LAST:event_btnCompileActionPerformed

    private void btnImportSrpitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportSrpitesActionPerformed

        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            files = Arrays.asList(fc.getSelectedFiles());

            for (File file : files) {
                
                JLabel label = new JLabel();
                label.setName(file.getName());
                label.setText(file.getName());
                label.setIcon(new ImageIcon(getClass().getResource("/imagens/Images-icon.png"), file.getAbsolutePath()));
                label.setBounds(panelObjetos.getX() + 5, initialY , 300, 25); 
                label.addMouseListener(pp);
                
                panelObjetos.add((Component) label);
                             
                DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(label, DnDConstants.ACTION_COPY, new DragGestureImpl(labelPreview));               
                initialY = initialY + 26;
            }           

        } else {
            return;
        }
        panelObjetos.repaint();
        panelObjetos.validate();

    }//GEN-LAST:event_btnImportSrpitesActionPerformed

    private void btnNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFileActionPerformed
        new Scene(editionPanel,scrEditionPane);
    }//GEN-LAST:event_btnNewFileActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
        zoom = new Zoom(editionPanel,scrEditionPane);
        zoom.zoomIn();
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
        zoom = new Zoom(editionPanel,scrEditionPane);
        zoom.zoomOut();
    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JFileChooser fs = new JFileChooser();
        fs.setDialogTitle("Salve o json de estado");
        fs.setFileFilter(new FileNameExtensionFilter("json files (*.json)","json"));
        
        int result = fs.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            try {
                FileWriter fw = new FileWriter(fs.getSelectedFile().getPath());
                JsonParser jp = new JsonParser(fw);
                jp.write(editionPanel.getComponents());
            } catch (IOException ex) {
                Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        CodeBuilder cb = new CodeBuilder();
        List<Component> components = Arrays.asList(editionPanel.getComponents());

        int count = 0;
        for (Component component : components) {
            JLabel label = (JLabel) component;
            label.setName("sprite" + (++count));
            cb.mountCode(label);
        }

        cb.generateFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnTranslateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranslateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTranslateActionPerformed

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
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnCompile;
    private javax.swing.JButton btnGridLayout;
    private javax.swing.JButton btnImportSrpites;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNewFile;
    private javax.swing.JToggleButton btnRotate;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnTranslate;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JPanel editionPanel;
    private javax.swing.JPanel instancePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar mb1;
    private javax.swing.JMenuItem menu2;
    private javax.swing.JTabbedPane objectsPanel;
    private javax.swing.JPanel panelObjetos;
    private javax.swing.JPanel panelPreview;
    private javax.swing.JPanel panelTiles;
    private javax.swing.JScrollPane scrEditionPane;
    private javax.swing.JScrollPane scrMainPanel;
    private javax.swing.JScrollPane scrObjectsPanel;
    private javax.swing.JScrollPane scrPreviewPanel;
    // End of variables declaration//GEN-END:variables
}

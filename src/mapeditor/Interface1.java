package mapeditor;

import Utils.FileNameUtils;
import droptarget.DragAndDropWithinPanel;
import codebuilder.CodeBuilder;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import droptarget.DragGestureImpl;
import droptarget.DropTargetImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
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
    LoadFiles ld;
    JList listaLabels;
    List<LoadFiles> filesNameImg = new ArrayList<>();
    List<JLabel> spritesDoPanel = new ArrayList<>();
    JLabel selecionado = new JLabel("");
    HandleObjects handleObjects;
    Zoom zoom;
    DragAndDropWithinPanel dadwp = new DragAndDropWithinPanel();
    HandleEditionScene hes;
    HandleInstances hi;
    HandleTiles handleTiles;
    Tiles tiles;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    int larguraPainel = 200;
    int colunas = 1;
    int linhas = 0;
    int initialY = 0;
    int defaultScreenX = 1440;
    int defaultScreenY = 900;
    

    public void customDimension() {
        JOptionPane.showMessageDialog(null, screenSize.width);
        JOptionPane.showMessageDialog(null, screenSize.height);
        JOptionPane.showMessageDialog(null, scrMainPanel.getSize().width);
        JOptionPane.showMessageDialog(null, scrMainPanel.getSize().height);

        this.calculatesDimensionJScrollPane(scrMainPanel);
        this.calculatesDimensionJScrollPane(scrObjectsPanel);
        this.calculatesDimensionJScrollPane(scrPreviewPanel);
        this.calculatesDimensionJScrollPane(scrEditionPane);
        this.calculatesDimensionJPanel(mainPanel);
        this.calculatesDimensionJPanel(menuPanel);
        this.calculatesDimensionJPanel(editionPanel);
        this.calculatesDimensionJPanel(resourcesPanel);
        this.calculatesDimensionJPanel(scenePanel);
        this.calculatesDimensionJPanel(actionsPanel);
        this.calculatesDimensionJPanel(panelObjects);
        this.calculatesDimensionJPanel(panelPreview);
        this.calculatesDimensionJPanel(instancePanel);
    

    }

    private void calculatesDimensionJPanel(JPanel panel) {
        panel.setSize(screenSize.width / (this.defaultScreenX / panel.getSize().width),
                screenSize.height / (this.defaultScreenY / panel.getSize().height));
        panel.setPreferredSize(new Dimension(screenSize.width / (this.defaultScreenX / panel.getSize().width),
                screenSize.height / (this.defaultScreenY / panel.getSize().height)));
    }

    private void calculatesDimensionJScrollPane(JScrollPane panel) {
        panel.setSize(screenSize.width / (this.defaultScreenX / (panel.getSize().width)),
                screenSize.height / (this.defaultScreenY / (panel.getSize().height)));
        panel.setPreferredSize(new Dimension(screenSize.width / (this.defaultScreenX / (panel.getSize().width)),
                screenSize.height / (this.defaultScreenY / (panel.getSize().height))));
    }

    public Interface1() {
        initComponents();
        this.setSize(screenSize);
        this.setPreferredSize(screenSize);
        //this.customDimension();

        
        hes = new HandleEditionScene(actionsPanel, editionPanel, instancePanel, resourcesPanel);
        hi = new HandleInstances(instancePanel);
        handleObjects = new HandleObjects(panelObjects,labelPreview,instancePanel,editionPanel);
        handleTiles = new HandleTiles(labelPreview);
        DropTargetImpl dropTargetImpl = new DropTargetImpl(editionPanel, instancePanel, hes, hi);

        editionPanel.setBackground(Color.white);
        tiles= new Tiles(editionPanel,tilesPanel,handleTiles);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrMainPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        scrObjectsPanel = new javax.swing.JScrollPane();
        objectsPanel = new javax.swing.JTabbedPane();
        panelObjects = new javax.swing.JPanel();
        instancePanel = new javax.swing.JPanel();
        tilesPanel = new javax.swing.JPanel();
        btnImportTiles = new javax.swing.JButton();
        scrPreviewPanel = new javax.swing.JScrollPane();
        panelPreview = new javax.swing.JPanel();
        labelPreview = new javax.swing.JLabel();
        scrEditionPane = new javax.swing.JScrollPane();
        editionPanel = new javax.swing.JPanel();
        resourcesPanel = new javax.swing.JPanel();
        btnImportSprites = new javax.swing.JButton();
        btnCompile = new javax.swing.JButton();
        actionsPanel = new javax.swing.JPanel();
        btnTranslate = new javax.swing.JToggleButton();
        btnRotate = new javax.swing.JToggleButton();
        labeltranslate = new javax.swing.JLabel();
        labelRotate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        labelDelete = new javax.swing.JLabel();
        scenePanel = new javax.swing.JPanel();
        btnSettings = new javax.swing.JButton();
        btnClearScene = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        btnZoomIn = new javax.swing.JButton();
        lConfig = new javax.swing.JLabel();
        lClean = new javax.swing.JLabel();
        lZoom = new javax.swing.JLabel();
        lCompile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        btnNewFile = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnGridLayout = new javax.swing.JButton();
        lNewFile = new javax.swing.JLabel();
        lOpen = new javax.swing.JLabel();
        lSave = new javax.swing.JLabel();
        lGrid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1440, 900));

        scrMainPanel.setPreferredSize(new java.awt.Dimension(1440, 899));

        mainPanel.setBackground(new java.awt.Color(153, 153, 153));
        mainPanel.setPreferredSize(new java.awt.Dimension(1440, 899));

        scrObjectsPanel.setBackground(new java.awt.Color(204, 204, 204));
        scrObjectsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Panel Objects"));
        scrObjectsPanel.setPreferredSize(new java.awt.Dimension(340, 692));

        objectsPanel.setBackground(new java.awt.Color(204, 204, 204));
        objectsPanel.setToolTipText("");

        panelObjects.setBackground(new java.awt.Color(204, 204, 204));
        panelObjects.setToolTipText("Painel de Objetos");

        javax.swing.GroupLayout panelObjectsLayout = new javax.swing.GroupLayout(panelObjects);
        panelObjects.setLayout(panelObjectsLayout);
        panelObjectsLayout.setHorizontalGroup(
            panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        panelObjectsLayout.setVerticalGroup(
            panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        objectsPanel.addTab("Objects", panelObjects);

        instancePanel.setBackground(new java.awt.Color(204, 204, 204));
        instancePanel.setToolTipText("Painel de Instâncias");

        javax.swing.GroupLayout instancePanelLayout = new javax.swing.GroupLayout(instancePanel);
        instancePanel.setLayout(instancePanelLayout);
        instancePanelLayout.setHorizontalGroup(
            instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        instancePanelLayout.setVerticalGroup(
            instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        objectsPanel.addTab("Instances", instancePanel);

        tilesPanel.setToolTipText("Painel Tiles");

        btnImportTiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clickTiles2.png"))); // NOI18N
        btnImportTiles.setToolTipText("Clique para importar os sprites tiles");
        btnImportTiles.setPreferredSize(new java.awt.Dimension(64, 64));
        btnImportTiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportTilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tilesPanelLayout = new javax.swing.GroupLayout(tilesPanel);
        tilesPanel.setLayout(tilesPanelLayout);
        tilesPanelLayout.setHorizontalGroup(
            tilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tilesPanelLayout.createSequentialGroup()
                .addComponent(btnImportTiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 261, Short.MAX_VALUE))
        );
        tilesPanelLayout.setVerticalGroup(
            tilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tilesPanelLayout.createSequentialGroup()
                .addComponent(btnImportTiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 698, Short.MAX_VALUE))
        );

        objectsPanel.addTab("Tiles", tilesPanel);

        scrObjectsPanel.setViewportView(objectsPanel);

        scrPreviewPanel.setPreferredSize(new java.awt.Dimension(340, 240));

        panelPreview.setBackground(new java.awt.Color(204, 204, 204));
        panelPreview.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Preview"));

        javax.swing.GroupLayout panelPreviewLayout = new javax.swing.GroupLayout(panelPreview);
        panelPreview.setLayout(panelPreviewLayout);
        panelPreviewLayout.setHorizontalGroup(
            panelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreviewLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelPreviewLayout.setVerticalGroup(
            panelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreviewLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(labelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        scrPreviewPanel.setViewportView(panelPreview);

        scrEditionPane.setPreferredSize(new java.awt.Dimension(1024, 768));

        editionPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout editionPanelLayout = new javax.swing.GroupLayout(editionPanel);
        editionPanel.setLayout(editionPanelLayout);
        editionPanelLayout.setHorizontalGroup(
            editionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        editionPanelLayout.setVerticalGroup(
            editionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        scrEditionPane.setViewportView(editionPanel);

        resourcesPanel.setBackground(new java.awt.Color(204, 204, 204));
        resourcesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu-Resources"));
        resourcesPanel.setPreferredSize(new java.awt.Dimension(800, 150));

        btnImportSprites.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Actions-list-add-icon.png"))); // NOI18N
        btnImportSprites.setToolTipText("Importa imagens/sprites");
        btnImportSprites.setPreferredSize(new java.awt.Dimension(55, 55));
        btnImportSprites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportSpritesActionPerformed(evt);
            }
        });

        btnCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/binary-icon.png"))); // NOI18N
        btnCompile.setToolTipText("Gerar código Python para PPLAY");
        btnCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompileActionPerformed(evt);
            }
        });

        actionsPanel.setBackground(new java.awt.Color(204, 204, 204));
        actionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Actions"));

        btnTranslate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/move-icon.png"))); // NOI18N
        btnTranslate.setToolTipText("Movimenta imagem/sprite");
        btnTranslate.setName("btnTranslate"); // NOI18N
        btnTranslate.setPreferredSize(new java.awt.Dimension(55, 55));
        btnTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranslateActionPerformed(evt);
            }
        });

        btnRotate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Actions-transform-rotate-icon.png"))); // NOI18N
        btnRotate.setToolTipText("Rotaciona imagem/sprite");
        btnRotate.setName("btnRotate"); // NOI18N
        btnRotate.setPreferredSize(new java.awt.Dimension(55, 55));

        labeltranslate.setText("Translate");

        labelRotate.setText("Rotate");
        labelRotate.setName(""); // NOI18N

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Actions-application-exit-icon.png"))); // NOI18N
        btnDelete.setToolTipText("Deleta imagem/sprite");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.setPreferredSize(new java.awt.Dimension(55, 55));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelDelete.setText("Delete");

        javax.swing.GroupLayout actionsPanelLayout = new javax.swing.GroupLayout(actionsPanel);
        actionsPanel.setLayout(actionsPanelLayout);
        actionsPanelLayout.setHorizontalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltranslate)
                    .addComponent(btnTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRotate)
                    .addComponent(btnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDelete)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        actionsPanelLayout.setVerticalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltranslate)
                    .addComponent(labelRotate)
                    .addComponent(labelDelete))
                .addGap(8, 8, 8)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTranslate, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(btnRotate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scenePanel.setBackground(new java.awt.Color(204, 204, 204));
        scenePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Scene"));

        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/window-system-icon.png"))); // NOI18N
        btnSettings.setToolTipText("Ajustar tela e cena");
        btnSettings.setPreferredSize(new java.awt.Dimension(55, 55));
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnClearScene.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/window-icon.png"))); // NOI18N
        btnClearScene.setToolTipText("Limpar Cenário");
        btnClearScene.setPreferredSize(new java.awt.Dimension(55, 55));
        btnClearScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSceneActionPerformed(evt);
            }
        });

        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom-Out-icon (1).png"))); // NOI18N
        btnZoomOut.setToolTipText("zoom -");
        btnZoomOut.setPreferredSize(new java.awt.Dimension(55, 55));
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });

        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom-In-icon (1).png"))); // NOI18N
        btnZoomIn.setToolTipText("zoom +");
        btnZoomIn.setPreferredSize(new java.awt.Dimension(55, 55));
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });

        lConfig.setText("Config ");

        lClean.setText("Clean");

        lZoom.setText("Zoom Out  -     Zoom In");

        javax.swing.GroupLayout scenePanelLayout = new javax.swing.GroupLayout(scenePanel);
        scenePanel.setLayout(scenePanelLayout);
        scenePanelLayout.setHorizontalGroup(
            scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenePanelLayout.createSequentialGroup()
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scenePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scenePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lClean)
                    .addComponent(btnClearScene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scenePanelLayout.createSequentialGroup()
                        .addComponent(btnZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        scenePanelLayout.setVerticalGroup(
            scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scenePanelLayout.createSequentialGroup()
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lConfig)
                        .addComponent(lClean))
                    .addComponent(lZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClearScene, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(scenePanelLayout.createSequentialGroup()
                        .addGroup(scenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lCompile.setText("Compile");

        jLabel1.setText("Import");

        javax.swing.GroupLayout resourcesPanelLayout = new javax.swing.GroupLayout(resourcesPanel);
        resourcesPanel.setLayout(resourcesPanelLayout);
        resourcesPanelLayout.setHorizontalGroup(
            resourcesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resourcesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(resourcesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImportSprites, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scenePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(resourcesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resourcesPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lCompile))
                    .addGroup(resourcesPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnCompile, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(124, 124, 124))
        );
        resourcesPanelLayout.setVerticalGroup(
            resourcesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resourcesPanelLayout.createSequentialGroup()
                .addGroup(resourcesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(resourcesPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lCompile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCompile)
                        .addGap(10, 10, 10))
                    .addComponent(actionsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scenePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resourcesPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImportSprites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        menuPanel.setBackground(new java.awt.Color(204, 204, 204));
        menuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

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
        btnGridLayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGridLayoutActionPerformed(evt);
            }
        });

        lNewFile.setText("New File");

        lOpen.setText("Open ");

        lSave.setText("Save");

        lGrid.setText("Grid");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewFile)
                    .addComponent(lNewFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoad)
                    .addComponent(lOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(lSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lGrid)
                    .addComponent(btnGridLayout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNewFile)
                    .addComponent(lOpen)
                    .addComponent(lSave)
                    .addComponent(lGrid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGridLayout)
                    .addComponent(btnSave)
                    .addComponent(btnLoad)
                    .addComponent(btnNewFile))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrObjectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resourcesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrEditionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(372, 372, 372))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resourcesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(scrObjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrEditionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(123, 123, 123))
        );

        scrMainPanel.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try {
            ImageIcon img = null;
            File file = null;
            FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("json files (*.json)", "json");
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
            List<JsonLabel> jsonLabels = Arrays.asList(gson.fromJson(new FileReader(file), JsonLabel[].class));

            for (JsonLabel jsonLabel : jsonLabels) {
                JLabel sprite = new JLabel(jsonLabel.getName());
                sprite.setIcon(new ImageIcon(jsonLabel.getPath()));
                sprite.setBounds(jsonLabel.getPositionX(), jsonLabel.getPositionY(), sprite.getIcon().getIconWidth(), sprite.getIcon().getIconHeight());
                sprite.addMouseListener(new DragAndDropWithinPanel());
                sprite.addMouseMotionListener(new DragAndDropWithinPanel());
                editionPanel.add((Component) sprite);
            }

            editionPanel.repaint();
            editionPanel.validate();
        } catch (Exception ex) {
            //error
        }

    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompileActionPerformed
        CodeBuilder cb = new CodeBuilder(scrEditionPane,editionPanel);
        cb.generate();

    }//GEN-LAST:event_btnCompileActionPerformed

    private void btnImportSpritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportSpritesActionPerformed
        ld = new LoadFiles(panelObjects, handleObjects,labelPreview, listaLabels);
        ld.addInPanelObjects();
       
    }//GEN-LAST:event_btnImportSpritesActionPerformed

    private void btnNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFileActionPerformed
        new Scene(editionPanel, scrEditionPane);
    }//GEN-LAST:event_btnNewFileActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
        zoom = new Zoom(editionPanel, scrEditionPane);
        zoom.zoomIn();
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
        zoom = new Zoom(editionPanel, scrEditionPane);
        zoom.zoomOut();
    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JFileChooser fs = new JFileChooser();
        fs.setDialogTitle("Salve o json de estado");
        fs.setFileFilter(new FileNameExtensionFilter("json files (*.json)", "json"));

        int result = fs.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(fs.getSelectedFile().getPath());
                JsonParser jp = new JsonParser(fw);
                jp.write(editionPanel.getComponents());
            } catch (IOException ex) {
                Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        CodeBuilder cb = new CodeBuilder(scrEditionPane,editionPanel);
        List<Component> components = Arrays.asList(editionPanel.getComponents());

        int count = 0;
        for (Component component : components) {
            Sprite sprite = (Sprite) component;
            sprite.setName("sprite" + (++count));
            cb.mountCode(sprite);
        }

        cb.generateFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnTranslateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranslateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTranslateActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        new Scene(editionPanel, scrEditionPane);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnClearSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSceneActionPerformed

        editionPanel.removeAll();
        instancePanel.removeAll();
        hi.getInstances().clear();
        instancePanel.repaint();
        instancePanel.revalidate();
        editionPanel.repaint();
        editionPanel.revalidate();

    }//GEN-LAST:event_btnClearSceneActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JButton btnDelete = null;
        JLabel label;
        int indice = 0;
        for (Component c : Arrays.asList(actionsPanel.getComponents())) {
            if (c instanceof JButton) {
                btnDelete = (JButton) c;
                if (btnDelete.getName().equals("btnDelete")) {
                    List<Component> comps = Arrays.asList(editionPanel.getComponents());

                    for (Component comp : comps) {

                        if (comp instanceof JLabel) {
                            label = (JLabel) comp;
                            if (label.getBorder() != null) {
                                editionPanel.remove((JLabel) comp);
                                instancePanel.remove(indice);
                                hi.removeInstance(indice);

                                instancePanel.repaint();
                                instancePanel.revalidate();

                            }
                        }
                        indice++;
                    }

                    editionPanel.repaint();
                    editionPanel.revalidate();

                }

            }

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnGridLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGridLayoutActionPerformed
          tiles.openSettings(); 

    }//GEN-LAST:event_btnGridLayoutActionPerformed

    private void btnImportTilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportTilesActionPerformed
        tiles.importTiles();
    }//GEN-LAST:event_btnImportTilesActionPerformed

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
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JButton btnClearScene;
    private javax.swing.JButton btnCompile;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGridLayout;
    private javax.swing.JButton btnImportSprites;
    private javax.swing.JButton btnImportTiles;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNewFile;
    private javax.swing.JToggleButton btnRotate;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSettings;
    private javax.swing.JToggleButton btnTranslate;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JPanel editionPanel;
    private javax.swing.JPanel instancePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lClean;
    private javax.swing.JLabel lCompile;
    private javax.swing.JLabel lConfig;
    private javax.swing.JLabel lGrid;
    private javax.swing.JLabel lNewFile;
    private javax.swing.JLabel lOpen;
    private javax.swing.JLabel lSave;
    private javax.swing.JLabel lZoom;
    private javax.swing.JLabel labelDelete;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JLabel labelRotate;
    private javax.swing.JLabel labeltranslate;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTabbedPane objectsPanel;
    private javax.swing.JPanel panelObjects;
    private javax.swing.JPanel panelPreview;
    private javax.swing.JPanel resourcesPanel;
    private javax.swing.JPanel scenePanel;
    private javax.swing.JScrollPane scrEditionPane;
    private javax.swing.JScrollPane scrMainPanel;
    private javax.swing.JScrollPane scrObjectsPanel;
    private javax.swing.JScrollPane scrPreviewPanel;
    private javax.swing.JPanel tilesPanel;
    // End of variables declaration//GEN-END:variables
}

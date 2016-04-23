package droptarget;

import Utils.FileNameUtils;
import mapeditor.HandleEditionScene;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import mapeditor.HandleInstances;
import mapeditor.Sprite;

public class DropTargetImpl extends DropTargetAdapter implements DropTargetListener {

    private DropTarget dropTarget;
    private JPanel editionPanel;
    private JPanel instancePanel;
    private HandleEditionScene hes;
    private HandleInstances handleInstances;
    private List<Sprite> listaDeInstancias = new ArrayList<>();
    int numInstancias=0;
    int initialY=0;

    public DropTargetImpl(JPanel editionPanel, JPanel instancePanel,HandleEditionScene hes, HandleInstances hi){
        this.editionPanel = editionPanel;
        this.instancePanel=instancePanel;
        this.handleInstances= hi;
        this.hes=hes;
        dropTarget = new DropTarget(editionPanel, DnDConstants.ACTION_COPY, this, true, null);
        
       }
    
    @Override
    public void drop(DropTargetDropEvent event) {
        DataFlavor dataFlavor = new DataFlavor(Sprite.class, Sprite.class.getSimpleName());
        try {
            Transferable tr = event.getTransferable();
            
            Sprite sprite =  (Sprite) tr.getTransferData(dataFlavor);
            ImageIcon path = (ImageIcon)sprite.getIcon();
            
            
            sprite.setNameFile(sprite.getName());
            sprite.setNameText(FileNameUtils.removeExtension(sprite.getName()));
            sprite.setText(null);
            sprite.setIcon(new ImageIcon(path.getDescription()));
            sprite.setBorder(null);
            
//            listaDeInstancias.add(label);
            handleInstances.addInstance(sprite);
            
            sprite.addMouseListener(new DragAndDropWithinPanel(hes,handleInstances));
            sprite.addMouseMotionListener(new DragAndDropWithinPanel(hes,handleInstances));
                      
//            numInstancias++;
            

//            JLabel instancia = new JLabel();
////            instancia.setText(label.getName()+numInstancias);
//            instancia.setText(label.getName()+handleInstances.getInstances().get(handleInstances.getInstances().indexOf(instancia)));// indice do objeto
//            instancia.setBounds(instancePanel.getX()+5, initialY, 300, 25);
//            instancePanel.add(instancia);         
//            initialY+=20;
//            
//            instancePanel.repaint();
//            instancePanel.validate();
            
            if (event.isDataFlavorSupported(dataFlavor)) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                
                sprite.setBounds(event.getLocation().x, event.getLocation().y, sprite.getIcon().getIconWidth(), sprite.getIcon().getIconHeight());          
                this.editionPanel.add(sprite);
//                instances.add(label);
                this.editionPanel.repaint();
                event.dropComplete(true);
                this.editionPanel.validate();
                return;
            }
            event.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }
}

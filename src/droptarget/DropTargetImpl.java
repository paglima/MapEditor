package droptarget;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import mapeditor.HandleInstances;

public class DropTargetImpl extends DropTargetAdapter implements DropTargetListener {

    private DropTarget dropTarget;
    private JPanel editionPanel;
    private JPanel instancePanel;
    private HandleEditionScene hes;
    private HandleInstances handleInstances;
    private List<JLabel> listaDeInstancias = new ArrayList<>();
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
        DataFlavor dataFlavor = new DataFlavor(JLabel.class, JLabel.class.getSimpleName());
        try {
            Transferable tr = event.getTransferable();
            
            JLabel label = (JLabel) tr.getTransferData(dataFlavor);
            ImageIcon path = (ImageIcon)label.getIcon();
            
            label.setText(null);
            label.setIcon(new ImageIcon(path.getDescription()));
            label.setBorder(null);
            
//            listaDeInstancias.add(label);
            handleInstances.addInstance(label);
            
            label.addMouseListener(new DragAndDropWithinPanel(hes,handleInstances));
            label.addMouseMotionListener(new DragAndDropWithinPanel(hes,handleInstances));
                      
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
                
                label.setBounds(event.getLocation().x, event.getLocation().y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());          
                this.editionPanel.add(label);
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

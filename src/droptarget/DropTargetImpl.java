package droptarget;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mapeditor.DragAndDropWithinPanel;

public class DropTargetImpl extends DropTargetAdapter implements DropTargetListener {

    private DropTarget dropTarget;
    private JPanel panel;
    private JPanel instancePanel;
    int numInstancias=0;
    int initialY=0;

    public DropTargetImpl(JPanel jpanel, JPanel instancePanel){
        this.panel = jpanel;
        this.instancePanel=instancePanel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
        
       }
    
    @Override
    public void drop(DropTargetDropEvent event) {
        DataFlavor dataFlavor = new DataFlavor(JLabel.class, JLabel.class.getSimpleName());
        try {
            Transferable tr = event.getTransferable();
            
            JLabel label = (JLabel) tr.getTransferData(dataFlavor);
            label.setText(null);
            label.setIcon(new ImageIcon(label.getName()));
            
            label.addMouseListener(new DragAndDropWithinPanel());
            label.addMouseMotionListener(new DragAndDropWithinPanel());
            
            numInstancias++;
            
            JLabel instancia = new JLabel();
            instancia.setText("Sprite"+numInstancias);
            instancia.setBounds(instancePanel.getX()+5, initialY, 300, 25);
            instancePanel.add(instancia);
            initialY+=20;
            
            instancePanel.repaint();
            instancePanel.validate();
            
            if (event.isDataFlavorSupported(dataFlavor)) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                
                label.setBounds(event.getLocation().x, event.getLocation().y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());          
                this.panel.add(label);
                this.panel.repaint();
                event.dropComplete(true);
                this.panel.validate();
                return;
            }
            event.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }
}

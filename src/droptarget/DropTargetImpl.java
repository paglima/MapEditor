/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droptarget;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pauloarthur
 */
public class DropTargetImpl extends DropTargetAdapter implements DropTargetListener {

    private DropTarget dropTarget;
    private JPanel panel;

    public DropTargetImpl(JPanel jpanel){
        this.panel = jpanel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this,
					true, null);
    }
    
    @Override
    public void drop(DropTargetDropEvent event) {
        DataFlavor dataFlavor = new DataFlavor(JLabel.class, JLabel.class.getSimpleName());
        try {
            Transferable tr = event.getTransferable();
            JLabel label = (JLabel) tr.getTransferData(dataFlavor);
            if (event.isDataFlavorSupported(dataFlavor)) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                this.panel.add(label);
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

package droptarget;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JLabel;

public class TransferableJLabel implements Transferable {

    private JLabel label;
    DataFlavor dataFlavor = new DataFlavor(JLabel.class,
            JLabel.class.getSimpleName());

    public TransferableJLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{dataFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(dataFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

        if (flavor.equals(dataFlavor)) {
            return label;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

}

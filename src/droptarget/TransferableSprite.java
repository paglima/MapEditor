package droptarget;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import mapeditor.Sprite;

public class TransferableSprite implements Transferable {

    private Sprite sprite;
    DataFlavor dataFlavor = new DataFlavor(Sprite.class,
            Sprite.class.getSimpleName());

    public TransferableSprite(Sprite sprite) {
        this.sprite = sprite;
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
            return sprite;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

}

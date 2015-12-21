/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droptarget;

import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import javax.swing.JLabel;

/**
 *
 * @author pauloarthur
 */
public class DragGestureListImp implements DragGestureListener {

		@Override
		public void dragGestureRecognized(DragGestureEvent event) {
			Cursor cursor = null;
			JLabel label = (JLabel) event.getComponent();

			if (event.getDragAction() == DnDConstants.ACTION_COPY) {
				cursor = DragSource.DefaultCopyDrop;
			}

			event.startDrag(cursor, new TransferableJLabel(label));
		}
	}
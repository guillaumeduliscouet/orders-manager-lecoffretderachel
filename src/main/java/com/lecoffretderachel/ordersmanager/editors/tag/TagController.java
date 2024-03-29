package com.lecoffretderachel.ordersmanager.editors.tag;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TagController {
	final TagView theView;
	final TagTableModel theModel;
	
	public TagController(TagView theView, TagTableModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		theView.injectModelIntoTable(theModel);
		theView.addBtnAddEntryListener(new BtnAddEntryListener());
		theView.addBtnDeleteEntryListener(new BtnDeleteEntryListener());
	}
	
	public void show() {
		theModel.fillData();
		theView.showGUI();
	}
	
	class BtnAddEntryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.addEmptyRow();
		}	
	}
	
	class BtnDeleteEntryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.deleteSelectedRow(theView.getSelectedRow());
		}
	}
}

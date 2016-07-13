package com.lecoffretderachel.ordersmanager.editors.product;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

import org.springframework.stereotype.Component;

@Component
public class ProductView {
	JFrame frame;
	JTable table;
	JButton btnAddEntry;
	JButton btnDeleteEntry;
	
	public ProductView() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
	}
	
    private void createGUI() {
		frame = new JFrame();
		table = new JTable();
		
		table.setFont(new Font("", 0, 16));
		table.setRowHeight(30);
		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setBounds(0, 0, 880, 200);
		tablePane.setPreferredSize(tablePane.getSize());
		
		btnAddEntry = new JButton("Ajouter");
		btnDeleteEntry = new JButton("Supprimer");
		JPanel btnPane = new JPanel();
		btnPane.add(btnAddEntry);
		btnPane.add(btnDeleteEntry);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(tablePane, BorderLayout.CENTER);
		frame.add(btnPane, BorderLayout.SOUTH);
        frame.pack();
    }
    
    public void showGUI() {
        frame.setVisible(true);
    }
    
    public int getSelectedRow() {
    	return table.getSelectionModel().getMinSelectionIndex();
    }
	
	public void injectModelIntoTable(AbstractTableModel model) {
		table.setModel(model);
	}
	
	public void addTagEditor(TableCellEditor cellEditor) {
		table.getColumnModel().getColumn(2).setCellEditor(cellEditor);;
	}
	
	public void addBtnAddEntryListener(ActionListener listener) {
		btnAddEntry.addActionListener(listener);
	}
	
	public void addBtnDeleteEntryListener(ActionListener listener) {
		btnDeleteEntry.addActionListener(listener);
	}
}

package com.devinhartzell.schedulemaker.gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ClassEditor extends JFrame {

	private static final long serialVersionUID = 8426220918159293409L;
	private JComboBox<String> startTimeMenu;
	
	public ClassEditor(int timeSlotID, int defaultDay) {
		super("Class Editor");
		getContentPane().setLayout(null);
		
		startTimeMenu = new JComboBox<String>();
		startTimeMenu.setModel(new DefaultComboBoxModel<String>(new String[] {"7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15"}));
		startTimeMenu.setSelectedIndex(timeSlotID);
		startTimeMenu.setBounds(80, 11, 66, 20);
		getContentPane().add(startTimeMenu);
		setSize(450, 300);
		setVisible(true);
		
	}
}

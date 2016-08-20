package com.devinhartzell.schedulemaker.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class ScheduleMakerWindow extends JFrame {

	private static final long serialVersionUID = 8145209520541863844L;
	
	public ScheduleMakerWindow() {
		super("Schedule Maker");

		setSize(968, 1025);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel schedulePanel = new JPanel();
		schedulePanel.setBackground(Color.WHITE);
		schedulePanel.setBounds(10, 11, 684, 962);
		
		
		
		
		
		
		getContentPane().add(schedulePanel);
		schedulePanel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 684, 34);
		schedulePanel.add(header);
		
		for (int i = 0; i <= 31; i++) {
			schedulePanel.add(new TimePanel(i, i % 2 == 0));
		}
		
		
		
		
		setVisible(true);
		
	}
}

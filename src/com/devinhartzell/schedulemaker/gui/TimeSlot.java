package com.devinhartzell.schedulemaker.gui;

import java.awt.Color;

import javax.swing.JTextPane;

public class TimeSlot extends JTextPane {

	private static final long serialVersionUID = -1627576857596571966L;
	
	// day >=1, day <=6
	// period >=0, period <=31
	public TimeSlot(int day, int period, boolean colored) {
		if (day < 1 || day > 6 || period < 0 || period > 31) 
			throw new NullPointerException();
		
		setBounds(((day-1) * 105) + 52, (period * 29) + 34, 105, 29);
		
		if (colored)
			setBackground(Color.LIGHT_GRAY);
		else
			setBackground(Color.WHITE);
		
	}

}

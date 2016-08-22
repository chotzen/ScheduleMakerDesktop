package com.devinhartzell.schedulemaker.gui;

import java.awt.Color;

import com.devinhartzell.schedulemaker.*;

import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TimeSlot extends JTextPane {

	private static final long serialVersionUID = -1627576857596571966L;
	
	public int day, period;
	private Color defaultBackground;
	
	public Section currentClass = null;
	
	// day >=1, day <=6
	// period >=0, period <=31
	public TimeSlot(int day, int period, boolean colored) {
		this.day = day;
		this.period = period;
		if (colored)
			defaultBackground = Color.LIGHT_GRAY;
		else
			defaultBackground = Color.WHITE;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ClassEditor(period, day);
			}
		});
		if (day < 0 || day > 5 || period < 0 || period > 31) 
			throw new NullPointerException();
		
		setBounds((day * 125) + 52, (period * 29) + 34, 125, 29);
		
		if (colored)
			setBackground(Color.LIGHT_GRAY);
		else
			setBackground(Color.WHITE);
		
		setEditable(false);
	}
	
	public void setSection(Section s) {
		currentClass = s;
		if (s != null)
			setBackground(s.color);
		else
			setBackground(defaultBackground);
	}
	

}

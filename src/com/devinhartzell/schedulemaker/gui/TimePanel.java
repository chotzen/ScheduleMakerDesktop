package com.devinhartzell.schedulemaker.gui;

import java.awt.Color;

import javax.swing.JTextPane;
import java.awt.Font;

public class TimePanel extends JTextPane {
	
	private static final long serialVersionUID = -7952228641511483744L;

	public TimePanel(int period, boolean colored) {
		setEditable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		if (!colored) {
			setBackground(Color.LIGHT_GRAY);
		} else {
			setBackground(Color.WHITE);
		}
		int tmin = 450 + (period * 15);
		int hr = tmin / 60;
		String min = Integer.toString(tmin % 60);
		if (min.equals("0")) min = "00";
		this.setText(String.format("%s:%s", hr, min));
		this.setBounds(0, (29 * period) + 34, 52, 29);		
	}
}

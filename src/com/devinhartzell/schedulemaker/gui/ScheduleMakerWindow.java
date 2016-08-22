package com.devinhartzell.schedulemaker.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import com.devinhartzell.schedulemaker.Section;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class ScheduleMakerWindow extends JFrame {

	private static final long serialVersionUID = 8145209520541863844L;
	
	private JPanel schedulePanel;
	
	public static TimeSlot[][] scheduleArray = new TimeSlot[6][32];
	public static ArrayList<Section> classList = new ArrayList<Section>();
	private JTextField ABCDEF;
	
	public ScheduleMakerWindow() {
		super("Schedule Maker");

		setSize(833, 1025);
		setResizable(false);
		getContentPane().setLayout(null);
		
		schedulePanel = new JPanel();
		schedulePanel.setBackground(Color.WHITE);
		schedulePanel.setBounds(10, 11, 802, 962);
		
		getContentPane().add(schedulePanel);
		schedulePanel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 802, 34);
		schedulePanel.add(header);
		header.setLayout(null);
		
		for (int i = 0; i < 6; i++) {
			ABCDEF = new JTextField();
			ABCDEF.setHorizontalAlignment(SwingConstants.CENTER);
			ABCDEF.setEditable(false);
			ABCDEF.setText(ClassEditor.letters[i]);
			ABCDEF.setFont(new Font("Tahoma", Font.PLAIN, 15));
			ABCDEF.setBounds(34 + (125 * i), 5, 125, 29);
			header.add(ABCDEF);
			ABCDEF.setOpaque(false);
			ABCDEF.setBorder(null);
		}
		
		
		boolean c = false;
		
		for (int i = 0; i <= 31; i++) {
			schedulePanel.add(new TimePanel(i, i % 2 == 0));
			for (int j = 0; j <=5; j++) {
				addTimeSlot(j, i, c);
				
			}
			c = !c;
		}
		
		
		
		setVisible(true);
		
	}
	
	public void addTimeSlot(int day, int period, boolean colored) {
		scheduleArray[day][period] = new TimeSlot(day, period, colored);
		schedulePanel.add(scheduleArray[day][period]);
		
	}
	
	public static void update() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 31; j++) {
				scheduleArray[i][j].setSection(null);
			}
		}
		
		for (Section s : classList) {
			for (TimeSlot t: s.times) {
				scheduleArray[t.day][t.period].setSection(s);
				
			}
		}
	}
}

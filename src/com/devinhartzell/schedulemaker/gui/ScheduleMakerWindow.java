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
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
	
	public static void update() throws Exception {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 31; j++) {
				scheduleArray[i][j].setSection(null);
				scheduleArray[i][j].setText("");
			}
		}
		
		for (Section s : classList) {
			for (TimeSlot t: s.times) {
				scheduleArray[t.day][t.period].setSection(s);
				
			}
			// find start and end times
			int start = s.times.get(0).period, end = s.times.get(0).period;
			for (TimeSlot t: s.times) {
				if (t.period < start) {
					start = t.period;
				}
				if (t.period > end) {
					end = t.period;
				}
			}
			
			int length = end-start + 1;
			if (length == 1) {
				String message;
				if (s.title.length() > 8) 
					message = String.format("%s. - %s", s.title.substring(0, 8), s.location);
				else
					message = String.format("%s. - %s", s.title, s.location);
				for (TimeSlot t: s.times) {
					t.setText(message);
				}
			} else if (length > 1) {
				int upmiddle = (int)Math.floor(length / 2.0) + start;
				int downmiddle = upmiddle--;
				for (TimeSlot t: s.times) {
					if (t.period == upmiddle) t.setText(s.title);
					if (t.period == downmiddle) t.setText(s.location);
				}
			} else {
				throw new Exception();
			}
			
			
			
		}
		
		
	}
	
	public static void main(String args[]) {
		new ScheduleMakerWindow();
	}
}

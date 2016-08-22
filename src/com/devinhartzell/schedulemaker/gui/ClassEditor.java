package com.devinhartzell.schedulemaker.gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import java.util.ArrayList;
import javax.swing.event.ChangeListener;

import com.devinhartzell.schedulemaker.Section;

import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

public class ClassEditor extends JFrame {

	private static final long serialVersionUID = 8426220918159293409L;
	private JComboBox<String> startTimeMenu;
	private JComboBox<String> endTimeMenu;
	private JEditorPane className;
	private JEditorPane location;
	private JRadioButton[] daySelectors = new JRadioButton[6];
	
	public static String[] letters = {"A", "B", "C", "D", "E", "F"};
	private JSpinner red;
	private JSpinner green;
	private JSpinner blue;
	private JButton doneButton;
	
	public ClassEditor(int timeSlotID, int defaultDay) {
		super("Class Editor");
		getContentPane().setLayout(null);
		
		startTimeMenu = new JComboBox<String>();
		startTimeMenu.setModel(new DefaultComboBoxModel<String>(new String[] {"7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15"}));
		startTimeMenu.setBounds(114, 11, 66, 20);
		getContentPane().add(startTimeMenu);
		
		endTimeMenu = new JComboBox<String>();
		endTimeMenu.setModel(new DefaultComboBoxModel<String>(new String[] {"7:40", "7:55", "8:10", "8:25", "8:40", "8:55", "9:10", "9:25", "9:40", "9:55", "10:10", "10:25", "10:40", "10:55", "11:10", "11:25", "11:40", "11:55", "12:10", "12:25", "12:40", "12:55", "13:10", "13:25", "13:40", "13:55", "14:10", "14:25", "14:40", "14:55", "15:10", "15:25"}));
		endTimeMenu.setBounds(114, 42, 66, 20);
		getContentPane().add(endTimeMenu);
		
		JTextArea txtrStartTime = new JTextArea();
		txtrStartTime.setEditable(false);
		txtrStartTime.setText("Start Time");
		txtrStartTime.setBounds(10, 9, 94, 22);
		getContentPane().add(txtrStartTime);
		
		JTextArea txtrEndTime = new JTextArea();
		txtrEndTime.setEditable(false);
		txtrEndTime.setText("End Time");
		txtrEndTime.setBounds(10, 42, 94, 22);
		getContentPane().add(txtrEndTime);
		
		className = new JEditorPane();
		className.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				className.setText("");
			}
		});
		className.setBounds(190, 11, 121, 20);
		getContentPane().add(className);
		
		location = new JEditorPane();
		location.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				location.setText("");
			}
		});

		location.setBounds(321, 11, 53, 20);
		getContentPane().add(location);
		
		JPanel colordemo = new JPanel();
		colordemo.setBackground(new Color(0,0,0));
		colordemo.setBounds(10, 73, 55, 20);
		getContentPane().add(colordemo);
		
		
		red = new JSpinner();
		red.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				colordemo.setBackground(new Color((Integer)red.getValue(), (Integer)green.getValue(), (Integer)blue.getValue()));
			}
		});

		red.setModel(new SpinnerNumberModel(0, 0, 255, 1));
		red.setBounds(75, 73, 47, 20);
		getContentPane().add(red);
		
		green = new JSpinner();
		green.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				colordemo.setBackground(new Color((Integer)red.getValue(), (Integer)green.getValue(), (Integer)blue.getValue()));
			}
		});
		green.setModel(new SpinnerNumberModel(0, 0, 255, 1));
		green.setBounds(124, 73, 47, 20);
		getContentPane().add(green);
		
		blue = new JSpinner();
		blue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				colordemo.setBackground(new Color((Integer)red.getValue(), (Integer)green.getValue(), (Integer)blue.getValue()));
			}
		});
		blue.setModel(new SpinnerNumberModel(0, 0, 255, 1));
		blue.setBounds(174, 73, 47, 20);
		getContentPane().add(blue);
		
		doneButton = new JButton("Done");
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ArrayList<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
				for (int i = 0; i<=5; i++) {
					if (daySelectors[i].isSelected()) {
						for (int j = startTimeMenu.getSelectedIndex(); j <= endTimeMenu.getSelectedIndex(); j++) {
							timeSlotList.add(ScheduleMakerWindow.scheduleArray[i][j]);
						}
					}
						
				}
				Section c = new Section(className.getText(), location.getText(), timeSlotList, 
						new Color((Integer)red.getValue(), (Integer)green.getValue(), (Integer)blue.getValue()));
				
				ScheduleMakerWindow.classList.add(c);
				if (!(ScheduleMakerWindow.scheduleArray[defaultDay][timeSlotID].currentClass == null)) {
					ScheduleMakerWindow.classList.remove(ScheduleMakerWindow.scheduleArray[defaultDay][timeSlotID].currentClass);
				}
				
				ScheduleMakerWindow.update();
				dispose();
			}
		});
		
		doneButton.setBounds(305, 73, 89, 23);
		getContentPane().add(doneButton);
		
		for (int i = 0; i <= 5; i++) {
			daySelectors[i] = new JRadioButton(letters[i]);
			daySelectors[i].setBounds(190 + (34 * i), 42, 35, 23);
			
			getContentPane().add(daySelectors[i]);
		}
		
		if (ScheduleMakerWindow.scheduleArray[defaultDay][timeSlotID].currentClass == null) {
			
			System.out.println("Couldn't find class, generating info");
			startTimeMenu.setSelectedIndex(timeSlotID);
			endTimeMenu.setSelectedIndex(timeSlotID + 3);
			className.setText("Class Name");
			location.setText("Location");
			
			for (int i = 0; i <= 5; i++) { 
				if (i == defaultDay) daySelectors[i].setSelected(true);
			}
			
			red.setValue((int)Math.round(Math.random() * 255)); 
			green.setValue((int)Math.round(Math.random() * 255)); 
			blue.setValue((int)Math.round(Math.random() * 255)); 
			colordemo.setBackground(new Color((Integer)red.getValue(), (Integer)green.getValue(), (Integer)blue.getValue()));
			
		} else {
			Section s = ScheduleMakerWindow.scheduleArray[defaultDay][timeSlotID].currentClass;
			int start = s.times.get(0).period, end = s.times.get(0).period;
			for (TimeSlot t: s.times) {
				if (t.period < start) {
					start = t.period;
				}
				if (t.period > end) {
					end = t.period;
				}
				
				daySelectors[t.day].setSelected(true);
			}
			startTimeMenu.setSelectedIndex(start);
			endTimeMenu.setSelectedIndex(end);
			
			className.setText(s.title);
			location.setText(s.location);
			
			red.setValue(s.color.getRed());
			green.setValue(s.color.getGreen());
			blue.setValue(s.color.getBlue());
			colordemo.setBackground(new Color((Integer)red.getValue(), (Integer)green.getValue(), (Integer)blue.getValue()));
			
			
		}
		
		
		
		setSize(420, 300);
		setVisible(true);
		
	}
}

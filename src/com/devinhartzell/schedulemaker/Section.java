package com.devinhartzell.schedulemaker;

import java.awt.Color;
import java.util.ArrayList;

import com.devinhartzell.schedulemaker.gui.TimeSlot;

public class Section {

	public String title, location;
	public ArrayList<TimeSlot> times = new ArrayList<TimeSlot>();
	public Color color;
	
	public Section(String title, String location, ArrayList<TimeSlot> times, Color color) {
		this.title = title;
		this.location = location;
		this.times = times;
		this.color = color;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setTimes(ArrayList<TimeSlot> times) {
		this.times = times;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}

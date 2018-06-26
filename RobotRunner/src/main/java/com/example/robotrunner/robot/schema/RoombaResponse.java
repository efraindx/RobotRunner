package com.example.robotrunner.robot.schema;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RoombaResponse {

	private List<Visited> visited;
	private List<Cleaned> cleaned;
	
	@SerializedName("final")
	private Final finalPosition;
	private int battery;

	public void setVisited(List<Visited> visited) {
		this.visited = visited;
	}

	public List<Visited> getVisited() {
		if (visited == null) {
			visited = new ArrayList<>();
		}
		return visited;
	}

	public void setCleaned(List<Cleaned> cleaned) {
		this.cleaned = cleaned;
	}

	public List<Cleaned> getCleaned() {
		if (cleaned == null) {
			cleaned = new ArrayList<>();
		}
		
		return cleaned;
	}

	public Final getFinalPosition() {
		return finalPosition;
	}

	public void setFinalPosition(Final finalPosition) {
		this.finalPosition = finalPosition;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public int getBattery() {
		return this.battery;
	}
}

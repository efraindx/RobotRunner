package com.example.robotrunner.robot.schema;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public class Start {

	private int X;
	private int Y;
	private String facing;

	public void setX(int X) {
		this.X = X;
	}

	public int getX() {
		return this.X;
	}

	public void setY(int Y) {
		this.Y = Y;
	}

	public int getY() {
		return this.Y;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public String getFacing() {
		return this.facing;
	}

	@Override
	public String toString() {
		return "Start [X=" + X + ", Y=" + Y + ", facing=" + facing + "]";
	}
}

package com.example.robotrunner.robot.schema;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public class Visited {

	private int X;
	private int Y;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visited other = (Visited) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		return true;
	}
}

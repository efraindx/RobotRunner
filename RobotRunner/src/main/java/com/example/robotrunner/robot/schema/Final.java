package com.example.robotrunner.robot.schema;

public class Final {
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		result = prime * result + ((facing == null) ? 0 : facing.hashCode());
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
		Final other = (Final) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		if (facing == null) {
			if (other.facing != null)
				return false;
		} else if (!facing.equals(other.facing))
			return false;
		return true;
	}
}
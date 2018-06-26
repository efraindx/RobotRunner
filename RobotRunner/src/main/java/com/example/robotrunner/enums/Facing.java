package com.example.robotrunner.enums;

public enum Facing {
	N,
	E,
	S,
	W;
	
	public Facing next() {
		Facing result = null;
		
		switch (this) {
		case N:
			return E;
		case E:
			return S;
		case S:
			return W;
		case W:
			return N;
		}
		
		return result;
	}
	
	public Facing previous() {
		Facing result = null;
		
		switch (this) {
		case N:
			return W;
		case E:
			return N;
		case S:
			return E;
		case W:
			return S;
		}
		
		return result;
	}
}

package model;

import java.io.Serializable;

public class Color implements Serializable{
	private int ColorID;
	private String Color;
	
	public Color() {}

	public int getColorID() {
		return ColorID;
	}

	public void setColorID(int colorID) {
		ColorID = colorID;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
		
}

package model;

public class Color {
	private int idP;
	private String color;
	private int ratio;
	public Color() {
		
	}
	public Color(int idP, String color, int ratio) {
		
		this.idP = idP;
		this.color = color;
		this.ratio = ratio;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getRatio() {
		return ratio;
	}
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}
	@Override
	public String toString() {
		return "Color [idP=" + idP + ", color=" + color + ", ratio=" + ratio + "]";
	}
	
	
}

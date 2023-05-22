package model;

public class Size {
	private int idP;
	private String size;
	private int ratio;
	public Size() {
	}
	public Size(int idP, String size, int ratio) {
		this.idP = idP;
		this.size = size;
		this.ratio = ratio;
	}
	
	public int getIdP() {
		return idP;
	}
	public String getSize() {
		return size;
	}
	public int getRatio() {
		return ratio;
	}
	@Override
	public String toString() {
	       return "Size{" + "size=" + size + ", ratio=" + ratio + '}';
	}
}

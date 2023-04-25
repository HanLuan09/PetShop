package model;

public class RatingProduct {
	private int idA, idP, rating;
	private String comment;
	
	public RatingProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RatingProduct(int idA, int idP, int rating, String comment) {
		super();
		this.idA = idA;
		this.idP = idP;
		this.rating = rating;
		this.comment = comment;
	}

	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

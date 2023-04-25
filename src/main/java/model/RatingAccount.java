package model;

public class RatingAccount extends RatingProduct {
	private String imageA, username;

	public RatingAccount() {
		super();
	}

	public RatingAccount(int idA, int idP, int rating, String comment, String imageA, String username) {
		super(idA, idP, rating, comment);
		this.imageA = imageA;
		this.username = username;
	}

	public String getImageA() {
		return imageA;
	}

	public void setImageA(String imageA) {
		this.imageA = imageA;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}

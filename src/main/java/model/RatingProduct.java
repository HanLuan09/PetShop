package model;

import java.sql.Date;

public class RatingProduct {
	private int idA, idP, idO, rating;
	private String comment;
	private Date dateRating;
	
	
	public RatingProduct() {
	
	}

	public RatingProduct(int idA, int idP, int idO, int rating, String comment, Date dateRating) {
		super();
		this.idA = idA;
		this.idP = idP;
		this.idO = idO;
		this.rating = rating;
		this.comment = comment;
		this.dateRating = dateRating;
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

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
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

	public Date getDateRating() {
		return dateRating;
	}

	public void setDateRating(Date dateRating) {
		this.dateRating = dateRating;
	}

	@Override
	public String toString() {
		return "RatingProduct [idA=" + idA + ", idP=" + idP + ", idO=" + idO + ", rating=" + rating + ", comment="
				+ comment + ", dateRating=" + dateRating + "]";
	}
	
}

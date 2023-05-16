package model;

import java.util.List;

public class RatingCount {
	private int rating;
	private int count;
	public RatingCount() {
		
	}
	public RatingCount(int rating, int count) {
		this.rating = rating;
		this.count = count;
	}
	public int getRating() {
		return rating;
	}
	public int getCount() {
		return count;
	}
	public int countRating(List<RatingCount> list) {
		int sum=0;
		for(RatingCount o: list) sum += o.count;
		return sum;
	}
	public double trungBinhRating(List<RatingCount> list) {
		int sum = 0;
		int sum2= 0;
	    for(RatingCount o: list) {
	    	sum += (o.rating * o.count);
	    	sum2+= o.count;
	    }
	    double avg = (double)sum / sum2;

	    int truncated = (int)(avg * 10);
	    int decimal = truncated % 10;

	    return (double)(truncated / 10) + (double)decimal / 10;
	}
}

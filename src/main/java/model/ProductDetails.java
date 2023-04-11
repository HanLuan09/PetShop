package model;

public class ProductDetails extends Product implements Comparable<ProductDetails> {
	private int sumPrice;
	private float rating;
	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetails(int idP, String nameP, String imageP, String describe, String origin, int amount,
            int discount, int price, int cateId, int sumPrice, float rating) {
        super(idP, nameP, imageP, describe, origin, amount, discount, price, cateId);
        this.sumPrice = sumPrice;
        this.rating = rating;
    }
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public int compareTo(ProductDetails o) {
        // so sánh độ phổ biến
//        int comparePopularity = Integer.compare(o.getPopularity(), this.getPopularity());
//        if (comparePopularity != 0) {
//            return comparePopularity;
//        }

        // so sánh đánh giá
        int compareRating = Float.compare(o.getRating(), this.getRating());
        if (compareRating != 0) {
            return compareRating;
        }

        // so sánh giá
        return Integer.compare(this.getPrice(), o.getPrice());
    }
	@Override
	public String toString() {
		return "ProductDetails [sumPrice=" + sumPrice + ", rating=" + rating + "]";
	}
	
	
	
}
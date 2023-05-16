package model.sort;

import java.util.Comparator;

import model.ProductDetails;

public class SortByPopularity implements Comparator<ProductDetails> {
    @Override
    public int compare(ProductDetails item1, ProductDetails item2) {
        // Tính tỉ lệ mức độ đánh giá
        double popularity1 = item1.getCountRating() * item1.getSumPrice();
        double popularity2 = item2.getCountRating() * item2.getSumPrice();
        // So sánh và trả về kết quả
        return Double.compare(popularity2, popularity1);
    }
}

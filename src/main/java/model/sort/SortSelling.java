package model.sort;

import java.util.Comparator;

import model.ProductDetails;

public class SortSelling implements Comparator<ProductDetails> {
    @Override
    public int compare(ProductDetails item1, ProductDetails item2) {
        return Integer.compare(item2.getSumPrice(), item1.getSumPrice());
    }
}
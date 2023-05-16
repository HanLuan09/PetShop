package model.sort;

import java.util.Comparator;

import model.ProductDetails;

public class SortHightoLow implements Comparator<ProductDetails> {
    @Override
    public int compare(ProductDetails item1, ProductDetails item2) {
    	return Integer.compare(item2.getPriceNew(), item1.getPriceNew());
    }
}
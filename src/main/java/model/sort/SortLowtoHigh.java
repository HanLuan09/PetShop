package model.sort;

import java.util.Comparator;

import model.ProductDetails;

public class SortLowtoHigh implements Comparator<ProductDetails> {
    @Override
    public int compare(ProductDetails item1, ProductDetails item2) {
    	return Integer.compare(item1.getPriceNew(), item2.getPriceNew());
    }
}
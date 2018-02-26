package org.java;

/**
 * A product is produced by a chain and weights between 1 and 9 weight-unit.
 * @author auzias
 *
 */
public class Product {
    private int weight;

    public Product(int weight) throws IllegalWeightException {
	WeightHelper.checkWeight(weight, Constant.PRODUCT_MAXIMAL_WEIGHT);
	this.weight = weight;
    }


    public int getWeight()  {
	return this.weight;
    }
}

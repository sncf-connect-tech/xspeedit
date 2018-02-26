package org.java;

public class WeightHelper {

    /**
     * Checks whether or not a weight is compliant with product requirements.
     * @param weight weight of to be tested.
     * @param max maximal weight.
     * @throws IllegalWeightException if the weight of the product is either too heavy or too light.
     */
    public static void checkWeight(int weight, int max) throws IllegalWeightException {
	if (weight > max) {
	    throw new IllegalWeightException(Constant.EXCEPTION_MESSAGE_HEAVY + weight + Constant.EXCEPTION_MESSAGE_UNIT);
	}
	if (weight < Constant.MINIMAL_WEIGHT) {
	    throw new IllegalWeightException(Constant.EXCEPTION_MESSAGE_LIGHT + weight + Constant.EXCEPTION_MESSAGE_UNIT);
	}
    }
}

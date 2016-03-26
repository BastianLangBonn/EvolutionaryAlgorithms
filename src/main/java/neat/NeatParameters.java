package neat;

import neural_network.ActivationType;

public class NeatParameters {

	public static final double MUTATION_WEIGHT_RANGE = 0.5;
	public static final double MUTATION_WEIGHT_BOUNDARY = 2.0;
	public static final int PUPULATION_SIZE = 30;
	public static final int NUMBER_OF_INPUT_NODES = 2;
	public static final int NUMBER_OF_OUTPUT_NODES = 1;
	public static final ActivationType OUTPUT_ACTIVATION_TYPE = ActivationType.HYPERBOLIC_TANGENT;

}

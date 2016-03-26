package neural_network.activation_functions;

/**
 * Implementation of {@link ActivationFunction} using an unsigned higher-slope
 * sigmoid.
 * 
 * @author Bastian Lang
 *
 */
public class Sigmoid implements ActivationFunction {

	public double compute(double input) {
		return 1. / (1 + Math.exp(-4.9 * input));
	}

}

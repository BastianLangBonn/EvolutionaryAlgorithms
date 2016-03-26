package neural_network.activation_functions;

/**
 * Implementation of {@link ActivationFunction} using a gaussian:
 * exp(-(x-0).^2/(2*1^2))
 * 
 * @author Bastian Lang
 *
 */
public class Gaussian implements ActivationFunction {

	public double compute(double input) {
		return Math.exp(Math.pow(-(input - 0), 2) / (4));
	}

}

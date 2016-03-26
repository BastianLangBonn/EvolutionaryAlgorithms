package neural_network.activation_functions;

/**
 * Implementation of {@link ActivationFunction} using Tangens Hyperbolicus
 * 
 * @author Bastian Lang
 *
 */
public class HyperbolicTangent implements ActivationFunction {

	public double compute(double input) {
		return Math.tanh(input);
	}

}

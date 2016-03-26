package neural_network.activation_functions;

/**
 * Implementation of {@link ActivationFunction} using a step function: x>0
 * 
 * @author Bastian Lang
 *
 */
public class Step implements ActivationFunction {

	public double compute(double input) {
		if (input <= 0) {
			return 0;
		} else {
			return 1;
		}
	}

}

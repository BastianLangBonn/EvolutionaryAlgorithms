package neat;

/**
 * Enum containing all possible types of activation functions for the ANN used
 * in NEAT.
 * 
 * @author Bastian Lang
 *
 */
public enum ActivationType {
	LINEAR, //
	HYPERBOLIC_TANGENT, // tanh(x)
	UNSIGNED_HIGHER_SLOPE_SIGMOID, // 1./(1+exp(-4.9*x))
	GAUSSIAN, // exp(-(x-0).^2/(2*1^2))
	STEP_FUNCTION// (x>0)
	;
}

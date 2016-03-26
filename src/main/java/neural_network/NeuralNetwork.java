package neural_network;

import java.util.List;

import org.jblas.DoubleMatrix;

import neat.NeatParameters;
import neural_network.activation_functions.ActivationFunction;

public class NeuralNetwork {

	/**
	 * Contains the weights to each neuron. Each column represents the weights
	 * to one neuron.
	 */
	private DoubleMatrix weights;
	/**
	 * Contains the activation functions for all the neurons.
	 */
	private List<ActivationFunction> activationFunctions;
	private DoubleMatrix outputs;

	/**
	 * Constructor
	 * 
	 * @param weights
	 *            Matrix containing the weights for every connection of the
	 *            network. Columns represent destinations, consisting of hidden
	 *            and output units. Rows represent sources, consisting of bias,
	 *            input and hidden units.
	 * @param activationFunctions
	 *            List of activation functions of every unit.
	 */
	public NeuralNetwork(DoubleMatrix weights, List<ActivationFunction> activationFunctions) {
		this.weights = weights;
		this.weights = DoubleMatrix.concatVertically(this.weights,
				DoubleMatrix.zeros(NeatParameters.NUMBER_OF_OUTPUT_NODES, this.weights.columns));
		this.activationFunctions = activationFunctions;
	}

	public DoubleMatrix compute(int[] input) {
		int numberOfInputs = input.length;
		validateNumberOfInputs(numberOfInputs);
		insertInputIntoOutputMatrix(input);
		propagateInputThroughNetwork(numberOfInputs);
		return getOutputValues();
	}

	private DoubleMatrix getOutputValues() {
		return outputs.getColumnRange(0, outputs.columns - NeatParameters.NUMBER_OF_OUTPUT_NODES, outputs.columns);
	}

	private void propagateInputThroughNetwork(int numberOfInputs) {
		for (int outputIndex = numberOfInputs + 1; outputIndex < outputs.columns; outputIndex++) {
			int weightIndex = outputIndex - numberOfInputs - 1;
			DoubleMatrix product = outputs.mmul(weights.getColumn(weightIndex));
			if (product.length != 1) {
				throw new IllegalStateException("Result of matrix multiplication should be a scalar.");
			}
			outputs.put(0, outputIndex, activationFunctions.get(weightIndex).compute(product.get(0)));
		}
	}

	private void insertInputIntoOutputMatrix(int[] input) {
		outputs = DoubleMatrix.zeros(1, weights.rows);
		outputs.put(0, 0, 1);
		for (int i = 0; i < input.length; i++) {
			outputs.put(0, i + 1, input[i]);
		}
	}

	private void validateNumberOfInputs(int numberOfInputs) {
		if (numberOfInputs != NeatParameters.NUMBER_OF_INPUT_NODES) {
			throw new IllegalArgumentException(
					"Number of inputs is bigger or equal to number of neurons in the network.");
		}
	}

}

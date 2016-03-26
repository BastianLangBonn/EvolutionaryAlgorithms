package neural_network;

import java.util.ArrayList;
import java.util.List;

import org.jblas.DoubleMatrix;
import org.junit.Test;

import neural_network.activation_functions.ActivationFunction;
import neural_network.activation_functions.HyperbolicTangent;

public class NeuralNetworkTest {

	@Test
	public void simpleNetworkPropagation() throws Exception {
		int[] input = { 1, 2 };
		DoubleMatrix weight = new DoubleMatrix(5, 3);
		weight.put(0, 0, 0.1);
		weight.put(1, 0, 0.2);
		weight.put(2, 0, 0.5);
		weight.put(3, 0, 0);
		weight.put(4, 0, 0);
		weight.put(0, 1, 0.2);
		weight.put(1, 1, 0.5);
		weight.put(2, 1, 0.2);
		weight.put(3, 1, 0);
		weight.put(4, 1, 0);
		weight.put(0, 2, 0.5);
		weight.put(1, 2, 0);
		weight.put(2, 2, 0);
		weight.put(3, 2, 0.3);
		weight.put(4, 2, 0.3);
		List<ActivationFunction> activationFunctions = new ArrayList<ActivationFunction>();
		activationFunctions.add(new HyperbolicTangent());
		activationFunctions.add(new HyperbolicTangent());
		activationFunctions.add(new HyperbolicTangent());
		NeuralNetwork neuralNetwork = new NeuralNetwork(weight, activationFunctions);
		System.out.println(neuralNetwork.compute(input));
	}

}

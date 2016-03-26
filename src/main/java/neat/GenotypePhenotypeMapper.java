package neat;

import org.jblas.DoubleMatrix;

import basic.Genotype;
import basic.Phenotype;

public class GenotypePhenotypeMapper {

	public Phenotype map(Genotype genotype) {
		int numberOfNodeGenes = genotype.getNumberOfNodeGenes();
		DoubleMatrix weights = new DoubleMatrix(numberOfNodeGenes - NeatParameters.NUMBER_OF_OUTPUT_NODES,
				numberOfNodeGenes - NeatParameters.NUMBER_OF_INPUT_NODES - 1);

		// new NeuralNetwork(weights, outputs, activationFunctions,
		// NeatParameters.INPUT_NODES,
		// NeatParameters.OUTPUT_NODES);

		return null;
	}

}

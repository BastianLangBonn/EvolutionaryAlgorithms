package neat;

import org.jblas.DoubleMatrix;

import basic.Genotype;
import basic.Phenotype;

public class GenotypePhenotypeMapper {

	public Phenotype map(Genotype genotype) {
		int numberOfNodeGenes = genotype.getNumberOfNodeGenes();
		DoubleMatrix weights = new DoubleMatrix(numberOfNodeGenes - NeatParameters.NUMBER_OF_OUTPUT_NODES,
				numberOfNodeGenes - NeatParameters.NUMBER_OF_INPUT_NODES - 1);
		
		// Get order of neurons
		/**
		 * * Add inputs to set
		 * * for every remaining node gene, check if all sources of incomming connections are contained in the set
		 * * Stop if no node gene could be added
		 * * Add node if all incoming sources are contained
		 * * Whenever a node gets added, add a column with all its connections to the weight matrix
		 */

		// new NeuralNetwork(weights, outputs, activationFunctions,
		// NeatParameters.INPUT_NODES,
		// NeatParameters.OUTPUT_NODES);

		return null;
	}

}

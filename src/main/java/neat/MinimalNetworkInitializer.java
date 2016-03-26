package neat;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import basic.Gene;
import basic.Genotype;
import basic.Individual;
import basic.Phenotype;
import basic.PopulationInitializer;
import neat.genes.ConnectionGene;
import neat.genes.NodeGene;
import neural_network.ActivationType;
import neural_network.NodeType;

/**
 * Class to create an initial population of minimal solutions.
 * 
 * @author Bastian Lang
 *
 */
public class MinimalNetworkInitializer implements PopulationInitializer {

	private GeneTracker nodeCounter;
	private GenotypePhenotypeMapper genotypePhenotypeMapper;
	private Random random;

	public MinimalNetworkInitializer(GeneTracker nodeCounter) {
		this.nodeCounter = nodeCounter;
		random = new Random();
	}

	public Set<Individual> initializePopulation() {
		Set<Individual> result = new HashSet<Individual>(NeatParameters.PUPULATION_SIZE);
		for (int i = 0; i < NeatParameters.PUPULATION_SIZE; i++) {
			result.add(createMinimalIndividual());
		}
		return result;
	}

	private Individual createMinimalIndividual() {
		NodeGene bias = createBiasGene();
		HashSet<NodeGene> inputs = createInputGenes();
		HashSet<NodeGene> outputs = createOutputGenes();
		HashSet<ConnectionGene> connections = createConnectionGenes(bias, inputs, outputs);
		HashSet<Gene> genes = createGenesSet(bias, inputs, outputs, connections);
		Individual individual = createIndividual(genes);
		return individual;
	}

	private Individual createIndividual(HashSet<Gene> genes) {
		Genotype genotype = new Genotype(genes);
		Phenotype phenotype = genotypePhenotypeMapper.map(genotype);
		Individual individual = new Individual(genotype, phenotype);
		return individual;
	}

	private NodeGene createBiasGene() {
		NodeGene bias = new NodeGene(nodeCounter.getNextNodeGeneId(), ActivationType.LINEAR, NodeType.BIAS);
		return bias;
	}

	private HashSet<NodeGene> createInputGenes() {
		HashSet<NodeGene> inputs = new HashSet<NodeGene>();
		for (int i = 0; i < NeatParameters.NUMBER_OF_OUTPUT_NODES; i++) {
			inputs.add(new NodeGene(nodeCounter.getNextNodeGeneId(), ActivationType.LINEAR, NodeType.INPUT));
		}
		return inputs;
	}

	private HashSet<NodeGene> createOutputGenes() {
		HashSet<NodeGene> outputs = new HashSet<NodeGene>();
		for (int i = 0; i < NeatParameters.NUMBER_OF_INPUT_NODES; i++) {
			outputs.add(new NodeGene(nodeCounter.getNextNodeGeneId(), NeatParameters.OUTPUT_ACTIVATION_TYPE,
					NodeType.OUTPUT));
		}
		return outputs;
	}

	private HashSet<ConnectionGene> createConnectionGenes(NodeGene bias, HashSet<NodeGene> inputs,
			HashSet<NodeGene> outputs) {
		HashSet<ConnectionGene> connections = new HashSet<ConnectionGene>();
		for (NodeGene output : outputs) {
			ConnectionGene connectionGene = new ConnectionGene(nodeCounter.getNextInnovationNumber(), bias, output,
					createRandomWeight());
			connections.add(connectionGene);
			for (NodeGene input : inputs) {
				ConnectionGene connection = new ConnectionGene(nodeCounter.getNextInnovationNumber(), input, output,
						createRandomWeight());
				connections.add(connection);
			}
		}
		return connections;
	}

	private HashSet<Gene> createGenesSet(NodeGene bias, HashSet<NodeGene> inputs, HashSet<NodeGene> outputs,
			HashSet<ConnectionGene> connections) {
		HashSet<Gene> genes = new HashSet<Gene>();
		genes.add(bias);
		genes.addAll(inputs);
		genes.addAll(outputs);
		genes.addAll(connections);
		return genes;
	}

	private double createRandomWeight() {
		return random.nextDouble() * 2 * NeatParameters.MUTATION_WEIGHT_BOUNDARY
				- NeatParameters.MUTATION_WEIGHT_BOUNDARY;
	}

}

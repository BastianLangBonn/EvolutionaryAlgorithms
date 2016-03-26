package neat.genes;

import java.util.Random;

import basic.Gene;
import neat.NeatParameters;

public class ConnectionGene implements Gene {

	private int innovationNumber;
	private NodeGene source;
	private NodeGene destination;
	private double weight;
	private boolean enabled;
	private Random random;

	public ConnectionGene(ConnectionGene gene) {
		innovationNumber = gene.getInnovationNumber();
		source = new NodeGene(gene.getSource());
		destination = new NodeGene(gene.getDestination());
		weight = gene.getWeight();
		enabled = gene.isEnabled();
		random = new Random();
	}

	public ConnectionGene(int innovationNumber, NodeGene source, NodeGene destination, double weight) {
		this.innovationNumber = innovationNumber;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.enabled = true;
	}

	public void mutate() {
		weight += computeWeightChange();
		capWeight();

	}

	private double computeWeightChange() {
		double weightChange = -1 + 2 * random.nextDouble() * NeatParameters.MUTATION_WEIGHT_RANGE;
		return weightChange;
	}

	private void capWeight() {
		if (weight > NeatParameters.MUTATION_WEIGHT_BOUNDARY) {
			weight = NeatParameters.MUTATION_WEIGHT_BOUNDARY;
		} else if (weight < -NeatParameters.MUTATION_WEIGHT_BOUNDARY) {
			weight = -NeatParameters.MUTATION_WEIGHT_BOUNDARY;
		}
	}

	public int getInnovationNumber() {
		return innovationNumber;
	}

	public NodeGene getSource() {
		return source;
	}

	public NodeGene getDestination() {
		return destination;
	}

	public double getWeight() {
		return weight;
	}

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + innovationNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionGene other = (ConnectionGene) obj;
		if (innovationNumber != other.innovationNumber)
			return false;
		return true;
	}

}

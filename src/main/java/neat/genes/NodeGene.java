package neat.genes;

import basic.Gene;
import neural_network.ActivationType;
import neural_network.NodeType;

/**
 * Class representing a node gene for the NEAT algorithm.
 * 
 * @author Bastian Lang
 *
 */
public class NodeGene implements Gene {

	private int id;
	private ActivationType activationType;
	private NodeType nodeType;

	public NodeGene(NodeGene gene) {
		this.id = gene.getId();
		this.activationType = gene.getActivationType();
		this.nodeType = gene.getNodeType();
	}

	public NodeGene(int id, ActivationType activationType, NodeType nodeType) {
		this.id = id;
		this.activationType = activationType;
		this.nodeType = nodeType;
	}

	public void mutate() {
		// NOOP
		return;
	}

	public int getId() {
		return id;
	}

	public ActivationType getActivationType() {
		return activationType;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		NodeGene other = (NodeGene) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

package neat;

import basic.Gene;

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

}

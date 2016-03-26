package neat;

/**
 * Class responsible for keeping track of the NodeIds.
 * 
 * @author Bastian Lang
 *
 */
public class GeneTracker {

	private int nodeGeneIdCounter;
	private int innovationCounter;

	public GeneTracker() {
		nodeGeneIdCounter = 0;
		innovationCounter = 0;
	}

	/**
	 * @return The next unused nodeID
	 */
	public int getNextNodeGeneId() {
		return nodeGeneIdCounter++;
	}

	public int getNextInnovationNumber() {
		return innovationCounter++;
	}

}

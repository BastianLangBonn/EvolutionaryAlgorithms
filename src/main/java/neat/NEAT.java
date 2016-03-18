package neat;

import java.util.Set;

/**
 * Class performing the NEAT algorithm.
 * @author Bastian Lang
 *
 */
public class NEAT {

	public void run(){
		
		Population currentGeneration = initializePopulation();
		speciatePopulation(currentGeneration);
		evaluatePopulation(currentGeneration);
		checkStoppingCriteria(currentGeneration);
		Population mates = selectMates(currentGeneration);
		currentGeneration = generateNextGeneration(mates);
		
	}
	
}

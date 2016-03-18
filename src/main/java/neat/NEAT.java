package neat;

/**
 * Class performing the NEAT algorithm.
 * 
 * @author Bastian Lang
 *
 */
public class Neat {

	private Population currentGeneration;
	private PopulationInitializer populationInitializer;
	private PopulationSpeciator populationSpeciator;
	private PopulationEvaluator populationEvaluator;
	private GenerationCreator generationCreator;
	private CriteriaChecker criteriaChecker;

	public void run() {

		currentGeneration = initializePopulation();
		currentGeneration = speciatePopulation(currentGeneration);
		currentGeneration = evaluatePopulation(currentGeneration);

		while (!stoppingCriteriaReached(currentGeneration)) {
			currentGeneration = generateNextGeneration(currentGeneration);
			currentGeneration = speciatePopulation(currentGeneration);
			currentGeneration = evaluatePopulation(currentGeneration);
		}
	}

	private Population initializePopulation() {
		return populationInitializer.initializePopulation();
	}

	private Population speciatePopulation(Population currentGeneration) {
		return populationSpeciator.speciatePopulation(currentGeneration);
	}

	private Population evaluatePopulation(Population currentGeneration) {
		return populationEvaluator.evaluatePopulation(currentGeneration);
	}

	private boolean stoppingCriteriaReached(Population currentGeneration) {
		return criteriaChecker.checkStoppingCriteria(currentGeneration);
	}

	private Population generateNextGeneration(Population mates) {
		return generationCreator.createNextGeneration(currentGeneration);
	}

	public void setPopulationInitializer(PopulationInitializer populationInitializer) {
		this.populationInitializer = populationInitializer;
	}

	public void setPopulationSpeciator(PopulationSpeciator populationSpeciator) {
		this.populationSpeciator = populationSpeciator;
	}

	public void setPopulationEvaluator(PopulationEvaluator populationEvaluator) {
		this.populationEvaluator = populationEvaluator;
	}

	public void setGenerationCreator(GenerationCreator generationCreator) {
		this.generationCreator = generationCreator;
	}

	public void setCriteriaChecker(CriteriaChecker criteriaChecker) {
		this.criteriaChecker = criteriaChecker;
	}

}

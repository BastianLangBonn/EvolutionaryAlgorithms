package basic;

import java.util.Set;

/**
 * Class performing the NEAT algorithm.
 * 
 * @author Bastian Lang
 *
 */
public class EvolutionaryAlgorithm {

	private Set<Individual> currentGeneration;
	private PopulationInitializer populationInitializer;
	private PopulationEvaluator populationEvaluator;
	private GenerationCreator generationCreator;
	private CriteriaChecker criteriaChecker;

	public void run() {

		currentGeneration = initializePopulation();
		currentGeneration = evaluatePopulation(currentGeneration);

		while (!stoppingCriteriaReached(currentGeneration)) {
			currentGeneration = generateNextGeneration(currentGeneration);
			currentGeneration = evaluatePopulation(currentGeneration);
		}
	}

	private Set<Individual> initializePopulation() {
		return populationInitializer.initializePopulation();
	}

	private Set<Individual> evaluatePopulation(Set<Individual> currentGeneration) {
		return populationEvaluator.evaluatePopulation(currentGeneration);
	}

	private boolean stoppingCriteriaReached(Set<Individual> currentGeneration) {
		return criteriaChecker.checkStoppingCriteria(currentGeneration);
	}

	private Set<Individual> generateNextGeneration(Set<Individual> mates) {
		return generationCreator.createNextGeneration(currentGeneration);
	}

	public void setPopulationInitializer(PopulationInitializer populationInitializer) {
		this.populationInitializer = populationInitializer;
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

package basic;

import java.util.HashSet;
import java.util.Set;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for class {@link EvolutionaryAlgorithm}
 * 
 * @author Bastian Lang
 *
 */
public class EvolutionaryAlgorithmTest {

	private Set<Individual> population;
	private PopulationInitializer populationInitializer;
	private PopulationEvaluator populationEvaluator;
	private CriteriaChecker criteriaChecker;
	private GenerationCreator generationCreator;
	private Mockery mockery;

	@Before
	public void setUp() {
		mockery = new Mockery();
		population = new HashSet<Individual>();
		populationInitializer = mockery.mock(PopulationInitializer.class);
		populationEvaluator = mockery.mock(PopulationEvaluator.class);
		criteriaChecker = mockery.mock(CriteriaChecker.class);
		generationCreator = mockery.mock(GenerationCreator.class);
		mockery.checking(new CommonRunExpectations());
	}

	/**
	 * Checks that run() calls all sub-methods in the correct order with the
	 * correct objects.
	 * 
	 * @throws Exception
	 */
	@Test
	public void run() throws Exception {
		EvolutionaryAlgorithm subject = new EvolutionaryAlgorithm();
		subject.setPopulationInitializer(populationInitializer);
		subject.setPopulationEvaluator(populationEvaluator);
		subject.setGenerationCreator(generationCreator);
		subject.setCriteriaChecker(criteriaChecker);
		subject.run();
		mockery.assertIsSatisfied();
	}

	private final class CommonRunExpectations extends Expectations {
		{
			exactly(1).of(populationInitializer).initializePopulation();
			will(returnValue(population));
			exactly(2).of(populationEvaluator).evaluatePopulation(population);
			will(returnValue(population));
			exactly(2).of(criteriaChecker).checkStoppingCriteria(population);
			will(onConsecutiveCalls(returnValue(false), returnValue(true)));
			exactly(1).of(generationCreator).createNextGeneration(population);
			will(returnValue(population));
		}
	}

}

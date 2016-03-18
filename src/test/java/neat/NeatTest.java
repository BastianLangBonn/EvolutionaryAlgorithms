package neat;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for class {@link Neat}
 * 
 * @author Bastian Lang
 *
 */
public class NeatTest {

	private Population population;
	private PopulationInitializer populationInitializer;
	private PopulationSpeciator populationSpeciator;
	private PopulationEvaluator populationEvaluator;
	private CriteriaChecker criteriaChecker;
	private GenerationCreator generationCreator;
	private Mockery mockery;

	@Before
	public void setUp() {
		mockery = new Mockery() {
			{
				setImposteriser(ClassImposteriser.INSTANCE);
			}
		};
		population = mockery.mock(Population.class);
		populationInitializer = mockery.mock(PopulationInitializer.class);
		populationSpeciator = mockery.mock(PopulationSpeciator.class);
		populationEvaluator = mockery.mock(PopulationEvaluator.class);
		criteriaChecker = mockery.mock(CriteriaChecker.class);
		generationCreator = mockery.mock(GenerationCreator.class);
		mockery.checking(new ExpectationsExtension());
	}

	/**
	 * Checks that run() calls all sub-methods in the correct order with the
	 * correct objects.
	 * 
	 * @throws Exception
	 */
	@Test
	public void run() throws Exception {
		Neat subject = new Neat();
		subject.setPopulationInitializer(populationInitializer);
		subject.setPopulationSpeciator(populationSpeciator);
		subject.setPopulationEvaluator(populationEvaluator);
		subject.setGenerationCreator(generationCreator);
		subject.setCriteriaChecker(criteriaChecker);
		subject.run();
		mockery.assertIsSatisfied();
	}

	private final class ExpectationsExtension extends Expectations {
		{
			exactly(1).of(populationInitializer).initializePopulation();
			will(returnValue(population));
			exactly(2).of(populationSpeciator).speciatePopulation(population);
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

package basic;

import java.util.HashSet;
import java.util.Set;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Genotype}.
 * 
 * @author Bastian Lang
 *
 */
public class GenotypeTest {

	private Mockery mockery;
	private Gene gene;
	private Genotype subject;

	@Before
	public void setUp() {
		mockery = new Mockery();
		gene = mockery.mock(Gene.class);
		Set<Gene> genes = new HashSet<Gene>();
		genes.add(gene);
		subject = new Genotype(genes);
	}

	/**
	 * Tests that a gene mutates if the mutation-rate of 100% is given.
	 * 
	 */
	@Test
	public void mutate_1_exactlyOneGeneMutates() {
		// Arrange
		mockery.checking(new Expectations() {
			{
				exactly(1).of(gene).mutate();
			}
		});

		// Act
		subject.mutate(1.0);

		// Assert
		mockery.assertIsSatisfied();
	}

	/**
	 * Tests that no gene mutates if the mutation-rate of 0% is given.
	 * 
	 */
	@Test
	public void mutate_0_noGeneMutates() {
		// Arrange
		mockery.checking(new Expectations() {
			{
				exactly(0).of(gene).mutate();
			}
		});

		// Act
		subject.mutate(0.0);

		// Assert
		mockery.assertIsSatisfied();
	}
}

package basic;

import java.util.Random;
import java.util.Set;

/**
 * Class representing the genotype of an individual for evolutionary algorithms.
 * 
 * @author Bastian Lang
 *
 */
public class Genotype {

	private Set<Gene> genes;
	private Random random;

	public Genotype(Set<Gene> genes) {
		random = new Random();
		this.genes = genes;
	}

	/**
	 * Exactly mutates one randomly selected gene in the set of genes.
	 * 
	 * @param probability
	 */
	public void mutate(double probability) {
		double randomValue;
		for (Gene gene : genes) {
			randomValue = random.nextDouble();
			if (randomValue <= probability) {
				gene.mutate();
				return;
			}
		}
	}

	public Set<Gene> getGenes() {
		return genes;
	}

	public void setGenes(Set<Gene> genes) {
		this.genes = genes;
	}

}

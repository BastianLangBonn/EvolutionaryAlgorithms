package neat;

import java.util.Set;

/**
 * Class representing the genotype of an individual for evolutionary algorithms.
 * 
 * @author Bastian Lang
 *
 */
public class Genotype {

	private Set<Gene> genes;
	
	public Genotype(Set<Gene> genes) {
		this.genes = genes;
	}

	/**
	 * Recombines the genes of two individuals according to NEAT.
	 * 
	 * @param mate
	 */
	public void recombine(Genotype mate){
		
	}
	
	/**
	 * Exactly mutates one randomly selected gene in the set of genes.
	 */
	public void mutate(){
		
	}

	public Set<Gene> getGenes() {
		return genes;
	}

	public void setGenes(Set<Gene> genes) {
		this.genes = genes;
	}
	
	
}

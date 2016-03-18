package basic;

/**
 * Class representing an individual in an evolutionary algorithm.
 * 
 * @author Bastian Lang
 *
 */
public class Individual {

	private Genotype genotype;
	private Phenotype phenotype;
	private double fitness;

	public Individual(Genotype genotype, Phenotype phenotype, double fitness) {
		this.setGenotype(genotype);
		this.setPhenotype(phenotype);
		this.setFitness(fitness);
	}

	public Genotype getGenotype() {
		return genotype;
	}

	public void setGenotype(Genotype genotype) {
		this.genotype = genotype;
	}

	public Phenotype getPhenotype() {
		return phenotype;
	}

	public void setPhenotype(Phenotype phenotype) {
		this.phenotype = phenotype;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genotype == null) ? 0 : genotype.hashCode());
		result = prime * result + ((phenotype == null) ? 0 : phenotype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individual other = (Individual) obj;
		if (genotype == null) {
			if (other.genotype != null)
				return false;
		} else if (!genotype.equals(other.genotype))
			return false;
		if (phenotype == null) {
			if (other.phenotype != null)
				return false;
		} else if (!phenotype.equals(other.phenotype))
			return false;
		return true;
	}

}

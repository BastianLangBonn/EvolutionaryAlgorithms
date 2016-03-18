package basic;

import java.util.Set;

public interface GenerationCreator {

	public Set<Individual> createNextGeneration(Set<Individual> population);

}

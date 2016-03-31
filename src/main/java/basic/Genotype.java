package basic;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import neat.genes.ConnectionGene;
import neat.genes.NodeGene;

/**
 * Class representing the genotype of an individual for evolutionary algorithms.
 * 
 * @author Bastian Lang
 *
 */
public class Genotype {

  private Set<Gene> genes;
  private Random random;
  private int numberOfNodeGenes;

  public Genotype(Set<Gene> genes) {
    random = new Random();
    this.genes = genes;
    numberOfNodeGenes = countNumberOfNodeGenes(genes);
  }

  private int countNumberOfNodeGenes(Set<Gene> genes) {
    int result = 0;
    for (Gene gene : genes) {
      if (gene instanceof NodeGene) {
        result++;
      }
    }
    return result;
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
    numberOfNodeGenes = countNumberOfNodeGenes(genes);
  }

  public int getNumberOfNodeGenes() {
    return numberOfNodeGenes;
  }

  public Set<NodeGene> getNodes() {
    HashSet<NodeGene> result = new HashSet<NodeGene>();
    for (Gene gene : genes) {
      if (gene instanceof NodeGene) {
        NodeGene node = (NodeGene) gene;
        result.add(node);
      }
    }
    return result;
  }

  public Set<ConnectionGene> getConnections() {
    HashSet<ConnectionGene> result = new HashSet<ConnectionGene>();
    for (Gene gene : genes) {
      if (gene instanceof ConnectionGene) {
        ConnectionGene connection = (ConnectionGene) gene;
        result.add(connection);
      }
    }
    return result;
  }

}

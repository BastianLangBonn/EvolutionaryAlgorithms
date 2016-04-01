package neat;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import basic.Gene;
import basic.Genotype;
import neat.genes.ConnectionGene;
import neat.genes.NodeGene;
import neural_network.ActivationType;
import neural_network.NodeType;

/**
 * Unit test for {@link NodeOrderGenerator}.
 * 
 * @author bastian
 *
 */
public class NodeOrderGeneratorTest {
  private NodeOrderGenerator subject;
  private NodeGene input;
  private NodeGene output;
  private NodeGene hidden;
  private ConnectionGene connection_0;
  private ConnectionGene connection_1;
  private ConnectionGene connection_2;

  @Before
  public void setUp() {
    subject = new NodeOrderGenerator();
    input = new NodeGene(0, ActivationType.LINEAR, NodeType.INPUT);
    hidden = new NodeGene(2, ActivationType.HYPERBOLIC_TANGENT, NodeType.HIDDEN);
    output = new NodeGene(1, ActivationType.HYPERBOLIC_TANGENT, NodeType.OUTPUT);
    connection_0 = new ConnectionGene(0, input, output, 0.5);
    connection_1 = new ConnectionGene(1, input, hidden, 0.5);
    connection_2 = new ConnectionGene(2, hidden, output, 0.5);
  }

  @Test
  public void generate_simple_correct() throws Exception {
    // Arrange
    int[] expected = { 1 };
    HashSet<Gene> genes = new HashSet<Gene>();
    genes.add(input);
    genes.add(output);
    genes.add(connection_0);
    Genotype genotype = new Genotype(genes);

    // Act
    int[] result = subject.generate(genotype);
    // Assert
    for (int i = 0; i < result.length; i++) {
      Assert.assertEquals("Wrong element at position " + i, expected[i], result[i]);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void generate_impossible_error() throws Exception {
    // Arrange
    HashSet<Gene> genes = new HashSet<Gene>();
    genes.add(input);
    genes.add(output);
    genes.add(new ConnectionGene(1, new NodeGene(2, ActivationType.HYPERBOLIC_TANGENT, NodeType.HIDDEN), output, 0.5));
    Genotype genotype = new Genotype(genes);

    // Act
    subject.generate(genotype);

  }

  @Test
  public void generate_complicated_correct() throws Exception {
    // Arrange
    int[] expected = { 2, 1 };
    HashSet<Gene> genes = new HashSet<Gene>();
    genes.add(input);
    genes.add(hidden);
    genes.add(output);
    genes.add(connection_1);
    genes.add(connection_2);
    Genotype genotype = new Genotype(genes);

    // Act
    int[] result = subject.generate(genotype);
    // Assert
    for (int i = 0; i < result.length; i++) {
      Assert.assertEquals("Wrong element at position " + i, expected[i], result[i]);
    }
  }

  @Test
  public void generate_disabledConnection_noError() throws Exception {
    // Arrange
    HashSet<Gene> genes = new HashSet<Gene>();
    genes.add(input);
    genes.add(output);
    ConnectionGene connection = new ConnectionGene(1,
        new NodeGene(2, ActivationType.HYPERBOLIC_TANGENT, NodeType.HIDDEN), output, 0.5);
    connection.setEnabled(false);
    genes.add(connection);
    Genotype genotype = new Genotype(genes);

    // Act
    subject.generate(genotype);

  }

}

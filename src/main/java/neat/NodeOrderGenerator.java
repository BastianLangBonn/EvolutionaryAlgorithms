package neat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import basic.Genotype;
import neat.genes.ConnectionGene;
import neat.genes.NodeGene;
import neural_network.NodeType;

public class NodeOrderGenerator {

  public int[] generate(Genotype genotype) {
    Set<NodeGene> nodes = genotype.getNodes();
    Set<ConnectionGene> connections = genotype.getConnections();
    ArrayList<NodeGene> result = new ArrayList<NodeGene>();
    for (NodeGene node : nodes) {
      if (node.getNodeType() == NodeType.BIAS || node.getNodeType() == NodeType.INPUT) {
        result.add(node);
      }
    }
    int numberOfBiasAndInput = result.size();
    nodes.removeAll(result);
    while (!nodes.isEmpty()) {
      boolean found = false;
      for (NodeGene node : nodes) {
        Set<NodeGene> sourceNodes = new HashSet<NodeGene>();
        for (ConnectionGene connection : connections) {
          if (!connection.isEnabled()) {
            continue;
          }
          if (connection.getDestination().equals(node)) {
            sourceNodes.add(connection.getSource());
          }
        }
        if (result.containsAll(sourceNodes)) {
          found = true;
          result.add(node);
          nodes.remove(node);
          break;
        }
      }
      if (!found) {
        throw new IllegalArgumentException("There is no ordering possible.");
      }
    }
    int[] order = new int[result.size() - numberOfBiasAndInput];
    for (int i = numberOfBiasAndInput; i < result.size(); i++) {
      order[i - numberOfBiasAndInput] = result.get(i).getId();
    }
    return order;
  }

}

package model;

/**
 * @author Luke Kennedy. Created May 12, 2010.
 */
public class Neighbor {
	private Node node;
	private Double distance;

	public Neighbor(Node node1, Node node2) {
		this.node = node2;
		this.distance = node1.getPoint().distance(node2.getPoint());
	}

	public Double getDistance() {
		return this.distance;
	}

	public Node getNode() {
		return this.node;
	}
}

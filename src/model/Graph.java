package model;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Node> listOfNodes = new ArrayList<Node>();

	public ArrayList<Node> getListOfNodes() {
		return listOfNodes;
	}

	public void setListOfNodes(ArrayList<Node> listOfNodes) {
		this.listOfNodes = listOfNodes;
	}

	public ArrayList<Node> toArrayList() {
		return this.listOfNodes;
	}

	public double getDistance(Node node1, Node node2) {
		double distance;
		distance = Math
				.sqrt((node1.getPoint().getX() - node2.getPoint().getX())
						* (node1.getPoint().getX() - node2.getPoint().getX())
						+ (node1.getPoint().getY() - node2.getPoint().getY())
						* (node2.getPoint().getY() - node2.getPoint().getY()));
		return distance;
	}

	public void add(Node node) {
		listOfNodes.add(node);
	}

	public void remove(Node node) {
		listOfNodes.remove(node);
	}

	public double getTime(Node node1, Node node2) {
		double distance;
		distance = Math
				.sqrt((node1.getPoint().getX() - node2.getPoint().getX())
						* (node1.getPoint().getX() - node2.getPoint().getX())
						+ (node1.getPoint().getY() - node2.getPoint().getY())
						* (node2.getPoint().getY() - node2.getPoint().getY()));
		return distance;
	}
}

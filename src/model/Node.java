package model;

import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author Luke Kennedy. Created May 12, 2010.
 */
public class Node implements Comparable<Node> {

	private Point2D.Double coordinates;
	public String name;
	private ArrayList<Attractions> listOfAttractions = new ArrayList<Attractions>();
	private Image pic;
	private String description;
	private ArrayList<Neighbor> neighbors = new ArrayList<Neighbor>();
	private boolean isVisited;
	public Node pathParent;
	private int womenCost;
	private int timeCost;
	private double cost;

	public Node(Point2D.Double coord, String name, ArrayList<Node> neighbors,
			ArrayList<Attractions> attractions, Image picture,
			String description, int timeCost, int womenCost) {
		this.name = name;
		this.coordinates = coord;
		if (attractions != null)
			this.listOfAttractions = attractions;
		if (picture != null)
			this.pic = picture;
		if (description != null)
			this.description = description;
		this.timeCost = timeCost;
		this.womenCost = womenCost;
		this.setCost(0);
	}

	public boolean addNeighbor(Node newNode) {
		if (this.neighbors.add(new Neighbor(this, newNode)))
			return true;
		return false;
	}

	public boolean addAttraction(Attractions e) {
		return this.listOfAttractions.add(e);
	}

	public ArrayList<Neighbor> getNeighbors() {
		return this.neighbors;
	}

	public ArrayList<Node> getNeighborNodes() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (Neighbor n : this.neighbors) {
			nodes.add(n.getNode());
		}
		return nodes;
	}

	public ArrayList<Attractions> getAttractions() {
		return this.listOfAttractions;
	}

	public void setVisited(Boolean bool) {
		this.isVisited = bool;
	}

	public boolean getVisited() {
		return this.isVisited;
	}

	public Point2D.Double getPoint() {
		return this.coordinates;
	}

	public double distance(Node node1) {
		return node1.getPoint().distance(getPoint());
	}

	public boolean removeNeighbor(Node toRemove) {
		for (int x = 0; x < this.neighbors.size(); x++) {
			if (this.neighbors.get(x).getNode() == toRemove) {
				this.neighbors.remove(x);
				return true;
			}
		}
		return false;
	}

	public boolean removeAttraction(Attractions toRemove) {
		if (this.listOfAttractions.remove(toRemove))
			return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return this.description;
	}

	public String toString() {
		return name;
	}

	public Image getImage() {
		return this.pic;
	}

	@Override
	public int compareTo(Node o) {
		return (int) (this.getCost() - o.getCost());
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}

	public int getWomenCost() {
		return womenCost;
	}

	public int getTimeCost() {
		return timeCost;
	}

	public double distance(Point p2) {
		return Math.sqrt(Math.pow(coordinates.x - p2.x, 2)
				+ Math.pow(coordinates.y - p2.y, 2));
	}

}
package controller;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import model.Graph;
import model.Node;

public class NodeController {
	private Graph nodeGraph;
	private HashMap<String, Node> nodeDetailsHash;
	private MasterController masterController;

	public NodeController(MasterController master, Graph graph,
			HashMap<String, Node> hashMap) {
		masterController = master;
		nodeGraph = graph;
		nodeDetailsHash = hashMap;
	}

	public void newNode(Point2D.Double coord, String name,
			ArrayList<String> neighborNames, Image picture, String description,
			int timeCost, int womenCost) {
		ArrayList<Node> neighbors = new ArrayList<Node>();
		for (String neighbor : neighborNames) {
			Node fromHash = nodeDetailsHash.get(neighbor.toLowerCase());
			neighbors.add(fromHash);
		}

		Node createdNode = new Node(coord, name, neighbors, null, picture,
				description, timeCost, womenCost);
		nodeGraph.add(createdNode);
		nodeDetailsHash.put(createdNode.name.toLowerCase(), createdNode);
		for (Node neighborNode : neighbors) {
			System.out.println("Neighbor: " + neighborNode);
			System.out.println("Created: " + neighbors);
			neighborNode.addNeighbor(createdNode);
		}
	}

	public ArrayList<String> getNodeList() {
		return masterController.getNodeList();
	}
}

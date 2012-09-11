package controller;

import java.util.HashMap;

import view.NavigationFrame;
import view.NewObjectFrame;

import model.Graph;
import model.Node;

public class MasterController {
	private Graph nodeGraph;
	private HashMap<String, Node> nodeDetailsHash;

	public MasterController(Graph graph, HashMap<String, Node> hashMap) {
		nodeGraph = graph;
		nodeDetailsHash = hashMap;
		new NavigationFrame(hashMap, this).setVisible(true);
	}

	public void showNewNodeFrame(int x, int y) {
		NodeController nodeControl = new NodeController(nodeGraph,
				nodeDetailsHash);
		new NewObjectFrame(nodeControl, x, y, nodeGraph, nodeDetailsHash);
	}
	
	public void removeNode(Node daNode) {
		nodeGraph.remove(daNode);
		nodeDetailsHash.remove(daNode.name.toLowerCase());
	}
}

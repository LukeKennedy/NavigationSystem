package controller;

import java.util.HashMap;

import model.Graph;
import model.Node;

public class NodeController {
	private Graph nodeGraph;
	private HashMap<String, Node> nodeDetailsHash;
	
	public NodeController(Graph graph, HashMap<String, Node> hashMap) {
		nodeGraph = graph;
		nodeDetailsHash = hashMap;
	}
	
	public void newNode() {
		
	}
}

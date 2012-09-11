package controller;

import java.util.HashMap;

import view.NavigationFrame;

import model.Graph;
import model.Node;

public class MasterController {

	public MasterController(Graph graph, HashMap<String, Node> hashMap) {
		new NavigationFrame(graph, hashMap).setVisible(true);
	}
}

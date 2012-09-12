package controller;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import model.AStar;
import model.Graph;
import model.Node;
import view.ImagePanel;
import view.InfoPanel;
import view.NavigationFrame;
import view.NewObjectFrame;

public class MasterController {
	private Graph nodeGraph;
	private HashMap<String, Node> nodeDetailsHash;

	public MasterController(Graph graph, HashMap<String, Node> hashMap) {
		nodeGraph = graph;
		nodeDetailsHash = hashMap;
		new NavigationFrame(hashMap, this).setVisible(true);
	}

	public void showNewNodeFrame(Point clickCoord) {
		NodeController nodeControl = new NodeController(this, nodeGraph,
				nodeDetailsHash);
		new NewObjectFrame(nodeControl, clickCoord);
	}

	public void removeNode(Node daNode) {
		nodeGraph.remove(daNode);
		nodeDetailsHash.remove(daNode.name.toLowerCase());
	}

	public ArrayList<String> getNodeList() {
		ArrayList<String> nameList = new ArrayList<String>();
		for (Node node : nodeGraph.toArrayList()) {
			nameList.add(node.name);
		}
		return nameList;
	}

	public void doNavigation(String heuristicType, String start, String end,
			ImagePanel mapPanel, InfoPanel directionPanel) {
		Node startNode = nodeDetailsHash.get(start.toLowerCase());
		Node endNode = nodeDetailsHash.get(end.toLowerCase());
		aStarSearch(heuristicType, mapPanel, directionPanel, startNode, endNode);
	}

	private void aStarSearch(String heuristicType, ImagePanel mapPanel,
			InfoPanel directionPanel, Node startNode, Node endNode) {
		if (startNode != null && endNode != null) {
			ArrayList<Node> directions = new AStar(startNode, endNode,
					nodeGraph, heuristicType).search();
			if (directions != null) {
				Stack<String> nameList = new Stack<String>();
				for (Node node : directions) {
					nameList.push(node.name);
				}
				ArrayList<String> reversedNameList = new ArrayList<String>();
				while (!nameList.isEmpty()) {
					reversedNameList.add(nameList.pop());
				}
				directionPanel.setDirections(reversedNameList);
				ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
				for (Node node : directions) {
					points.add(node.getPoint());
				}
				mapPanel.drawPath(points);
			}
		}
	}

	public void doNavigationByPoints(String heuristicType, Point startPoint,
			Point endPoint, ImagePanel mapPanel, InfoPanel directionPanel) {
		aStarSearch(heuristicType, mapPanel, directionPanel,
				findClosestNode(startPoint), findClosestNode(endPoint));

	}

	private Node findClosestNode(Point point) {
		ArrayList<Node> nodes = nodeGraph.toArrayList();
		double min = nodes.get(0).distance(point);
		Node closest = nodes.get(0);
		for (Node node : nodes) {
			double dis = node.distance(point);
			if (dis < min) {
				min = dis;
				closest = node;
			}
		}
		return closest;
	}

	public Point2D.Double findClosestLocationPoint(Point point) {
		return findClosestNode(point).getPoint();
	}
}

package model;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TESTNode extends Node {

	public TESTNode() {
		super(
				new Point2D.Double(50000, 50000),
				"Rose-Hulman Institute of Technology",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("RHITDefault.jpg").getImage(),
				"Rose�Hulman Institute of Technology is a small, private, non-sectarian college specializing in teaching engineering, mathematics, and science. ",
				100000, 100000);
	}

}

package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Graph;
import model.Node;
import controller.NodeController;

/**
 * @author Luke Kennedy. Created May 17, 2010.
 */
public class NewObjectFrame extends JFrame {

	public NewObjectFrame(NodeController nodeController, int x, int y,
			Graph graph, HashMap<String, Node> hash) {
		this.setSize(new Dimension(350, 820));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("RHIT Navigation System");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setVisible(true);
		this.setIconImage(new ImageIcon("globe_green.png").getImage());
		this.setMinimumSize(new Dimension(350, 500));
		this.setPreferredSize(new Dimension(350, 500));

		JPanel thePanel = new NewNodePanel(nodeController, x, y, graph, hash,
				this);
		this.add(thePanel);
		this.setVisible(true);
	}
}

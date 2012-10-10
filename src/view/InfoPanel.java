package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Node;
import model.TESTNode;

/**
 * @author Luke Kennedy. Created May 14, 2010.
 */
@SuppressWarnings("serial")
public class InfoPanel extends JPanel {
	private Node selectedNode;
	private JTextArea nameLabel = new JTextArea(
			"Rose-Hulman Institute of Technology");
	private ImageIcon nodePic = new ImageIcon("RHITDefault.jpg");
	private JLabel pictureLabel = new JLabel(nodePic, SwingConstants.LEFT);
	private JTextArea desLabel = new JTextArea(
			"Rose–Hulman Institute of Technology is a small, private, non-sectarian college specializing in teaching engineering, mathematics, and science.");
	private JTextArea attNameLabel = new JTextArea();
	private JTextArea attDesLabel = new JTextArea();
	private JTextArea ratingLabel = new JTextArea();
	private JButton ratingButton = new JButton("Set Rating");
	String[] ratings = { "1", "2", "3", "4", "5" };
	private JTextArea directions = new JTextArea();

	public JTextArea getDirections() {
		return directions;
	}

	public void setDirections(JTextArea directions) {
		this.directions = directions;
	}

	public InfoPanel() {
		this.nameLabel.setFont(new Font("Serif", Font.BOLD, 13));
		this.pictureLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.nameLabel.setEditable(false);
		this.desLabel.setEditable(false);
		this.attNameLabel.setEditable(false);
		this.attDesLabel.setEditable(false);
		this.ratingLabel.setEditable(false);
		this.directions.setEditable(false);
		this.desLabel.setRows(5);
		this.desLabel.setLineWrap(true);
		this.desLabel.setWrapStyleWord(true);
		this.attDesLabel.setSize(220, 300);
		this.attDesLabel.setRows(5);
		this.attDesLabel.setLineWrap(true);
		this.attDesLabel.setWrapStyleWord(true);
		this.directions.setVisible(false);
		this.ratingButton.setVisible(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(nameLabel);
		JPanel holder = new JPanel();
		holder.setBackground(Color.white);
		holder.add(this.pictureLabel);
		holder.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(holder);
		this.add(this.desLabel);
		this.add(this.attNameLabel);
		this.add(this.ratingLabel);
		this.add(this.attDesLabel);
		this.add(this.directions);
		this.add(ratingButton);
	}

	public void changeNode(Node newNode) {
		this.selectedNode = newNode;
		this.update();
	}

	public Node getSelectedNode() {
		return selectedNode;
	}

	private void update() {
		this.nameLabel.setText(this.selectedNode.getName());
		this.desLabel.setText(this.selectedNode.getDescription());
		this.nodePic = new ImageIcon(this.selectedNode.getImage());
		this.pictureLabel.setIcon(this.nodePic);
		this.attNameLabel.setText("");
		this.ratingLabel.setText("");
		this.attDesLabel.setText("");

	}

	public void hide() {
		this.directions.setVisible(true);
		this.selectedNode = new TESTNode();
		this.nameLabel.setVisible(false);
		this.pictureLabel.setVisible(false);
		this.desLabel.setVisible(false);
		this.attNameLabel.setVisible(false);
		this.attDesLabel.setVisible(false);
		this.ratingLabel.setVisible(false);
		this.ratingButton.setVisible(false);
	}

	public void show() {
		this.directions.setVisible(false);
		this.nameLabel.setVisible(true);
		this.pictureLabel.setVisible(true);
		this.desLabel.setVisible(true);
		this.attNameLabel.setVisible(true);
		this.attDesLabel.setVisible(true);
		this.ratingLabel.setVisible(true);
		this.ratingButton.setVisible(false);
	}

	public void setDirections(ArrayList<String> directionList) {
		this.hide();
		this.directions.setVisible(true);
		String dirString = "";
		for (String locationName : directionList) {
			dirString += locationName + "\n";
		}
		this.directions.setText(dirString);
	}
}

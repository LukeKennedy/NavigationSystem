package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.NodeController;

/**
 * @author Luke Kennedy. Created May 17, 2010.
 */
public class NewNodePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -429250999869761353L;
	private NodeController nodeController;
	private File picture;
	private JFileChooser picChooser = new JFileChooser();
	private JButton picButton;
	// private Point2D.Double location;
	// private int x;
	// private int y;
	private ArrayList<JCheckBox> boxList = new ArrayList<JCheckBox>();
	private JButton addButton = new JButton("Add Destination");
	private JButton cancelButton = new JButton("Cancel");
	private JTextField nameField = new JTextField();
	private JTextArea desField = new JTextArea();
	private JTextField locationX = new JTextField();
	private JTextField locationY = new JTextField();
	private NewObjectFrame parentFrame;
	private JTextField women = new JTextField();
	private JTextField time = new JTextField();

	public NewNodePanel(NodeController controller, int x, int y,
			NewObjectFrame frame) {
		this.parentFrame = frame;
		nodeController = controller;

		// location = new Point2D.Double(x, y);
		// this.setPreferredSize(new Dimension(350, 500));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setVisible(true);

		JLabel titleLabel = new JLabel("Add a Destination");
		titleLabel.setAlignmentX(SwingConstants.LEFT);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
		this.add(titleLabel);
		JPanel locationPanel = new JPanel();
		locationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel locationLabel = new JLabel("Location: (X, Y) ");
		locationPanel.add(locationLabel);
		locationX.setText(x + "");
		locationY.setText(y + "");
		locationX.setColumns(5);
		locationY.setColumns(5);
		locationPanel.add(locationX);
		locationPanel.add(locationY);
		this.add(locationPanel);

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel nameLabel = new JLabel("Name: ");
		namePanel.add(nameLabel);

		nameField.setColumns(25);
		namePanel.add(nameField);
		this.add(namePanel);

		JPanel womenPanel = new JPanel();
		womenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel womenLabel = new JLabel("Women (0 - Many, 100 - None): ");
		womenPanel.add(womenLabel);

		women.setColumns(5);
		womenPanel.add(women);
		this.add(womenPanel);

		JPanel timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel timeLabel = new JLabel("Time Value (0 - Fast, 100 - Slow): ");
		timePanel.add(timeLabel);

		time.setColumns(5);
		timePanel.add(time);
		this.add(timePanel);

		JPanel picPanel = new JPanel();
		picPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel picLabel = new JLabel("Picture: ");
		picPanel.add(picLabel);
		picButton = new JButton("Choose Picture");
		picPanel.add(picButton);
		this.add(picPanel);
		picButton.addActionListener(this);

		JPanel descriptionPanel = new JPanel();
		JLabel desLabel = new JLabel("Description:");
		desLabel.setAlignmentX(SwingConstants.LEFT);
		desField.setColumns(22);
		desField.setRows(5);
		desField.setLineWrap(true);
		desField.setWrapStyleWord(true);
		descriptionPanel.add(desLabel);
		descriptionPanel.add(desField);
		this.add(descriptionPanel);

		JPanel neighborPanel = new JPanel();
		neighborPanel.setSize(350, 100);
		neighborPanel.setPreferredSize(new Dimension(345, 460));
		neighborPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ArrayList<String> listOfLocations = nodeController.getNodeList();
		for (String location : listOfLocations) {
			JCheckBox checkBox = new JCheckBox(location);
			boxList.add(checkBox);
			neighborPanel.add(checkBox);
		}

		JLabel neighborLabel = new JLabel("Select Neighbors:");
		neighborLabel.setAlignmentX(SwingConstants.LEFT);
		this.add(neighborLabel);
		this.add(neighborPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.addButton);
		buttonPanel.add(this.cancelButton);
		this.addButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		this.add(buttonPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.picButton) {
			int action = this.picChooser.showOpenDialog(new JFrame());
			if (action != JFileChooser.APPROVE_OPTION) {
				return;
			}
			this.picture = this.picChooser.getSelectedFile();
		}
		if (e.getSource() == this.addButton) {
			ArrayList<String> neighborList = new ArrayList<String>();
			for (JCheckBox box : boxList) {
				if (box.isSelected()) {
					neighborList.add(box.getText());
				}
			}
			Point2D.Double point = new Point2D.Double(
					Integer.parseInt(this.locationX.getText()),
					Integer.parseInt(this.locationY.getText()));

			if (this.nameField.getText() == null
					|| this.desField.getText() == null)
				return;
			if (this.picture == null) {
				this.picture = new File("RHITDefault.jpg");
			}

			nodeController.newNode(point, this.nameField.getText(),
					neighborList,
					new ImageIcon(this.picture.toString()).getImage(),
					this.desField.getText(), 00, 0);
			parentFrame.dispose();
		}

		if (e.getSource() == this.cancelButton) {
			parentFrame.dispose();
		}
	}
}

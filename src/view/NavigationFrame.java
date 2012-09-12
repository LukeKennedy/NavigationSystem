package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

import model.Node;
import model.TESTNode;
import controller.MasterController;

@SuppressWarnings("serial")
public class NavigationFrame extends JFrame implements PropertyChangeListener,
		ActionListener {
	private ImagePanel mainPanel;
	private InfoPanel infoPanel;
	private JComboBox<String> fromBox;
	private JComboBox<String> toBox;
	private JTextArea searchBar = new JTextArea("");
	public JComboBox<String> searchBox;
	private MasterController masterController;

	public NavigationFrame(final HashMap<String, Node> hashTable,
			MasterController master) {
		masterController = master;

		setFrameProperties();

		mainPanel = new ImagePanel(masterController, "map.jpg", this);
		mainPanel.setMaximumSize(new Dimension(1024, 503));
		infoPanel = new InfoPanel();

		mainPanel.setPreferredSize(new Dimension(800, 503));
		infoPanel.setPreferredSize(new Dimension(224, 503));
		infoPanel.setBackground(Color.WHITE);

		this.add(createMenuBar());
		this.add(mainPanel);
		this.add(infoPanel);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu();
		JMenuItem Open = new JMenuItem();
		JMenuItem Exit = new JMenuItem();
		JMenu ViewMenu = new JMenu();
		JRadioButtonMenuItem radioButtonMapView = new JRadioButtonMenuItem();
		JRadioButtonMenuItem radioButtonSatiliteView = new JRadioButtonMenuItem();
		// JMenuItem displayTopAttr = new JMenuItem("Top Attractions");
		// ViewMenu.add(displayTopAttr);
		//
		// displayTopAttr.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// ArrayList<Attractions> temp = frame.displayTopAttr();
		// infoPanel.hide();
		// infoPanel.getDirections().setVisible(true);
		// String tempStr = "";
		// for (int count = 0; count < temp.size(); count++) {
		// tempStr = tempStr
		// + temp.get(temp.size() - count - 1).name
		// + "\n                                                 Rating: "
		// + temp.get(temp.size() - count - 1).getRating()
		// + "\n";
		// }
		// infoPanel.getDirections().setText(tempStr);
		// }
		// });

		fileMenu.setText("File");
		menuBar.setVisible(true);
		Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		Open.setText("Add Location");
		fileMenu.add(Open);

		Open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_MASK));
		Exit.addActionListener(this);
		Exit.setText("Exit");
		fileMenu.add(Exit);

		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menuBar.add(fileMenu);

		ViewMenu.setText("View");

		radioButtonMapView.setSelected(true);
		radioButtonMapView.setText("Map");
		radioButtonMapView.addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				NavigationFrame.this.mainPanel.setImage("map.jpg");
				NavigationFrame.this.mainPanel.repaint();
			}

		}));
		ViewMenu.add(radioButtonMapView);

		radioButtonSatiliteView.setSelected(false);
		radioButtonSatiliteView.setText("Satilite");
		radioButtonSatiliteView.addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				NavigationFrame.this.mainPanel.setImage("Satilite.jpg");
				NavigationFrame.this.mainPanel.repaint();
			}

		}));
		ViewMenu.add(radioButtonSatiliteView);

		ButtonGroup mapView = new ButtonGroup();
		mapView.add(radioButtonMapView);
		mapView.add(radioButtonSatiliteView);

		menuBar.add(ViewMenu);
		JLabel toLabel = new JLabel();
		toLabel.setText("  To:  ");
		menuBar.add(toLabel);

		toBox = createLocationSelectorComboBox();
		menuBar.add(toBox);
		JLabel fromLabel = new JLabel();
		fromLabel.setText("  From:  ");
		menuBar.add(fromLabel);

		fromBox = createLocationSelectorComboBox();
		menuBar.add(fromBox);

		JLabel searchLabel = new JLabel();
		searchLabel.setText("  Navigation Method:  ");
		menuBar.add(searchLabel);

		searchBox = new JComboBox<String>();
		searchBox.addItem("Shortest Distance");
		searchBox.addItem("Least Time");
		searchBox.addItem("Most Girls");
		searchBox.setEditable(false);
		searchBox.setMaximumSize(new Dimension(175, 20));

		menuBar.add(searchBox);
		searchBar.setVisible(true);
		searchBar.setAlignmentX(RIGHT_ALIGNMENT);
		menuBar.add(searchBar);

		JButton searchButton = new JButton("Navigate");
		menuBar.add(searchButton);
		searchButton.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fromBox.getSelectedItem() != null
						&& toBox.getSelectedItem() != null) {
					String startLocation = fromBox.getSelectedItem().toString();
					String endLocation = toBox.getSelectedItem().toString();
					masterController.doNavigation(getHeuristic(),
							startLocation, endLocation, mainPanel, infoPanel);
				}
			}
		}));
		return menuBar;
	}

	public String getHeuristic() {
		if (searchBox.getSelectedIndex() == 0)
			return "Least Distance";
		else if (searchBox.getSelectedIndex() == 1)
			return "Least Time";
		else
			return "Most Girls";
	}

	private JComboBox<String> createLocationSelectorComboBox() {
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(null);
		for (String nodeName : masterController.getNodeList()) {
			comboBox.addItem(nodeName);
		}
		comboBox.setEditable(true);
		comboBox.setMaximumSize(new Dimension(250, 20));
		return comboBox;
	}

	private void setFrameProperties() {
		this.setSize(new Dimension(1045, 570));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("RHIT Navigation System");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setVisible(true);
		this.setIconImage(new ImageIcon("globe_green.png").getImage());
		this.setMinimumSize(new Dimension(1024, 503));
		this.setPreferredSize(new Dimension(1024, 503));
	}

	// public ArrayList<Attractions> displayTopAttr() {
	// ArrayList<Attractions> RAWR = new ArrayList<Attractions>();
	// double min = 0.0;
	// Attractions smallAttr = null;
	// for (Node K : graph.getListOfNodes()) {
	// for (Attractions T : K.getAttractions()) {
	// if (RAWR.size() < 10) {
	// RAWR.add(T);
	// } else {
	// for (Attractions F : RAWR) {
	// if (F.getRating() < min) {
	// min = F.getRating();
	// smallAttr = F;
	// }
	// }
	// if (T.getRating() > min) {
	// RAWR.remove(smallAttr);
	// RAWR.add(T);
	// }
	// }
	// }
	// }
	// return RAWR;
	// }

	public void resetInfoPanel() {
		this.infoPanel.changeNode(new TESTNode());
		this.infoPanel.show();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		//
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//
	}

	public void updateLists() {
		toBox.removeAllItems();
		fromBox.removeAllItems();
		toBox.addItem(null);
		fromBox.addItem(null);
		for (String locationName : masterController.getNodeList()) {
			toBox.addItem(locationName);
			fromBox.addItem(locationName);
		}
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
}
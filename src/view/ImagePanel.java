package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import model.Node;
import controller.MasterController;

public class ImagePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MasterController masterController;
	private Image img;
	private NavigationFrame parent;
	private ArrayList<Point2D.Double> directionPath;
	private ArrayList<Node> tempArray = new ArrayList<Node>();
	public boolean drawn;
	private boolean ready;
	private Point clickCoord;
	private Point selectedLocation;
	private JPopupMenu rightClickMenu = new JPopupMenu();

	public ImagePanel(MasterController master, String img, NavigationFrame host) {
		this(master, new ImageIcon(img).getImage(), host);
	}

	public ImagePanel(MasterController master, Image pic, NavigationFrame host) {
		masterController = master;
		parent = host;
		img = pic;
		directionPath = new ArrayList<Point2D.Double>();

		rightClickMenu = createRightClickMenu();

		addMouseListener(this);
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void setImage(String img) {
		this.img = new ImageIcon(img).getImage();

	}

	public void drawPath(ArrayList<Point2D.Double> pointList) {
		directionPath = pointList;
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 0, 0, null);
		if (selectedLocation != null) {
			Point2D.Double realPoint = masterController
					.findClosestLocationPoint(selectedLocation);
			g2.setStroke(new BasicStroke(3));
			g2.drawOval((int) realPoint.getX() - 25,
					(int) realPoint.getY() - 25, 50, 50);
		}
		if (directionPath.size() > 1) {
			for (int i = directionPath.size() - 1; i > 0; i--) {
				g2.setStroke(new BasicStroke(3));
				g2.drawLine((int) directionPath.get(i - 1).getX(),
						(int) directionPath.get(i - 1).getY(),
						(int) directionPath.get(i).getX(), (int) directionPath
								.get(i).getY());
				// if (array.get(i)!=array.get(array.size()-1)) {
				g2.drawOval((int) directionPath.get(i - 1).getX() - 15,
						(int) directionPath.get(i - 1).getY() - 15, 30, 30);
			}
			g2.drawOval(
					(int) directionPath.get(directionPath.size() - 1).getX() - 25,
					(int) directionPath.get(directionPath.size() - 1).getY() - 25,
					50, 50);
		}
		if (ready) {
			for (int i = tempArray.size() - 1; i > 0; i--) {
				g2.setStroke(new BasicStroke(3));
				g2.setColor(Color.BLUE);
				g2.drawLine((int) tempArray.get(i - 1).getPoint().getX(),
						(int) tempArray.get(i - 1).getPoint().getY(),
						(int) tempArray.get(i).getPoint().getX(),
						(int) tempArray.get(i).getPoint().getY());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		clickCoord = evt.getPoint();

		if (evt.getButton() == MouseEvent.BUTTON1) {
			clearRoute();
			if (selectedLocation == null) {
				selectedLocation = clickCoord;

			} else {
				masterController.doNavigationByPoints(parent.getHeuristic(),
						selectedLocation, clickCoord, this,
						parent.getInfoPanel());
				selectedLocation = null;
			}
			repaint();
		}
		if (evt.getButton() == MouseEvent.BUTTON3) {
			rightClickMenu.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	public void clearRoute() {
		directionPath.clear();
		repaint();
	}

	private JPopupMenu createRightClickMenu() {
		JPopupMenu popUp = new JPopupMenu();
		JMenuItem popupInsert = new JMenuItem("Insert Destination");
		popupInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// masterController.showNewNodeFrame((int) coord.getX(),
				// (int) coord.getY());
			}
		});
		popUp.add(popupInsert);

		JMenuItem popupClear = new JMenuItem("Clear Route");
		popupClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRoute();
			}
		});
		popUp.add(popupClear);
		return popUp;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
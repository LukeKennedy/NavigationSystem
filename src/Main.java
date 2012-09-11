import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import model.Attractions;
import model.Graph;
import model.Node;
import controller.MasterController;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author mooremo.
 */
public class Main
{
	/**
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args)
	{
		Graph graph = new Graph();
		HashMap<String, Node> hashTable = new HashMap<String, Node>();
		setUpCrap(graph, hashTable);
		
		new MasterController(graph, hashTable);
	}

	private static void setUpCrap(Graph graph, HashMap<String, Node> hashTable) {
		Node ato = new Node(new Point2D.Double(629, 200),
				"Alpha Tau Omega Fraternity", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("ato.jpg")
						.getImage(),
				"Alpha Tau Omega Fraternity House of Rose-Hulman Institute of Technology", 0,100);
		Node triangle = new Node(new Point2D.Double(630, 236),
				"Triangle Fraternity", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("triangle.jpg")
						.getImage(),
				"Triangle Fraternity House of Rose-Hulman Institute of Technology", 0, 100);
		Node lambdaChi = new Node(new Point2D.Double(634, 272),
				"Lambda Chi Alpha Fraternity", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("lambdachi.jpg")
						.getImage(),
				"Lambda Chi Alpha Fraternity House of Rose-Hulman Institute of Technology", 0, 100);
		Node sigmaNu = new Node(new Point2D.Double(690, 228),
				"Sigma Nu Fraternnity", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("signu.jpg")
						.getImage(),
				"Sigma Nu Fraternity House of Rose-Hulman Institute of Technology", 0, 100);
		Node hatfield = new Node(
				new Point2D.Double(566, 335),
				"Hatfield Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("hatfield.jpg").getImage(),
				"Hatfield Hall is used as a concert hall for many of Rose-Hulman's Performing Art Series events", 0, 80);
		Node olin = new Node(new Point2D.Double(437, 294), "Olin Hall",
				new ArrayList<Node>(), new ArrayList<Attractions>(),
				new ImageIcon("olin.jpg").getImage(),
				"Olin Hall contains classrooms and laboratories.", 50, 80);
		Node hadley = new Node(
				new Point2D.Double(472, 285),
				"Hadley Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("hadley.jpg").getImage(),
				"Hadley Hall contains the many of the executive offices and registrars office alongside many classrooms for HSS Courses", 50, 80);
		Node moench = new Node(
				new Point2D.Double(487, 246),
				"Moench Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("moench.jpg").getImage(),
				"Moench Hall Contains many Classrooms for a great variety of courses as well as the mailroom and a large common area", 50, 80);
		Node crapo = new Node(new Point2D.Double(451, 228), "Crapo Hall",
				new ArrayList<Node>(), new ArrayList<Attractions>(),
				new ImageIcon("crapo.jpg").getImage(),
				"Crapo Hall contains many of the classrooms used for classes for math.", 50, 80);
		Node logan = new Node(
				new Point2D.Double(431, 248),
				"Logan Library",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("logan.jpg").getImage(),
				"The Logan Library is the schools library that contains a large volume of books as well as the Learning center in the basement.", 50, 80);
		Node deming = new Node(
				new Point2D.Double(380, 246),
				"Deming Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("deming.jpg").getImage(),
				"Deming Hall is an all boys freshman dormitory that has an attic that is used to house upperclassmen", 0, 100);
		Node bsb = new Node(
				new Point2D.Double(383, 314),
				"BSB Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("bsb.jpg").getImage(),
				"Baur-Sames-Bogart Hall was opened to residents in 1956. This is a three story residence hall built in the shape of an L with accommodations for 120 freshmen and 24 upperclassmen. It is located at the east end of the two campus lakes. The campus radio station is housed in BSB Hall.", 0, 66);
		Node speed = new Node(
				new Point2D.Double(327, 337),
				"Speed Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("speed.jpg").getImage(),
				"Speed Hall was opened in 1963. Speed is a three-story residence hall with accommodations for 116 freshmen. It is located on the south side of the campus lake. Speed Hall has a kitchen, several study areas, a main lounge, ping pong, laundry room, and vending machines. All rooms are carpeted.", 0, 100);
		Node percopo = new Node(
				new Point2D.Double(243, 338),
				"Percopo Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("percopo.jpg").getImage(),
				"The sophomore residence hall commonly referred to as Percopo Hall opened during the Winter Quarter of the 1999-2000 school year. The hall is designed to enhance the learning experience of sophomores through the use of live-in peer tutors, scheduled study sessions, and numerous group study areas. The hall has 109 double rooms - each sharing a restroom with a second room. The hall is fully air conditioned and carpeted, has a library, classroom, and several lounges and study areas.", 0, 80);
		Node chapel = new Node(
				new Point2D.Double(188, 307),
				"White Chapel",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("chapel.jpg").getImage(),
				"The White Chapel is dedicated space in which students can worship and seek spiritual refuge in time of doubt or troubles. It is a non-denominational chapel for the worship services of recognized campus organizations.", 0, 70);
		Node apartmentseast = new Node(
				new Point2D.Double(213, 222),
				"Apartments East",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("apartmentseastwest.jpg").getImage(),
				"The east section of our newest residence hall houses around 120 students opened in the fall of 2004. The 75,000-square-foot residential complex is located west and slightly north of the upperclass residence halls. The complex consists of two, three-story, brick buildings connected by a single story commons area. The commons includes a convenience store, Subway restaurant, coffee house and dining area.", 0, 70);
		Node apartmentswest = new Node(
				new Point2D.Double(168, 245),
				"Apartments West",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("apartmentseastwest.jpg").getImage(),
				"The west section of our newest residence hall houses around 120 students opened in the fall of 2004. The 75,000-square-foot residential complex is located west and slightly north of the upperclass residence halls. The complex consists of two, three-story, brick buildings connected by a single story commons area. The commons includes a convenience store, Subway restaurant, coffee house and dining area.", 0, 70);
		Node blum = new Node(
				new Point2D.Double(240, 250),
				"Blumberg Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("blum.jpg").getImage(),
				"Blumberg Hall was opened in 1966. It is a four-story brick residence hall. Each floor is in the shape of a H containing twelve two-person rooms. The hall is air-conditioned. The hall accommodates 76 students. It has a lounge area, a laundry room, and vending machines.", 0, 10);
		Node scharp = new Node(
				new Point2D.Double(252, 233),
				"Scharpenberg Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("scharp.jpg").getImage(),
				"Scharpenberg Hall was opened in 1966. It is a four-story brick residence hall. Each floor is in the shape of a H containing twelve two-person rooms. The hall is air-conditioned. The hall accommodates 76 students. It has a lounge area, a laundry room, and vending machines.", 0, 100);
		Node mees = new Node(
				new Point2D.Double(272, 241),
				"Mees Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("mees.jpg").getImage(),
				"Mees Hall was opened in 1966. It is a four-story brick residence hall. Each floor is in the shape of a H containing twelve two-person rooms. The hall is air-conditioned. The hall accommodates 76 students. It has a lounge area, a laundry room, and vending machines.", 0, 100);
		Node union = new Node(
				new Point2D.Double(328, 236),
				"Hulman Memorial Union",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("union.jpg").getImage(),
				"The Grace and Anton Hulman Memorial Union is a hub of activity on campus.  The facility is the home to a variety of meeting rooms, lounge space, Chauncey’s Game Room, the Vonderschmidt Dining Room, and Faculty Dining Room. There are also a number of offices located in the building.", 0, 80);
		Node src = new Node(
				new Point2D.Double(292, 133),
				"SRC",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("src.jpg").getImage(),
				"The Rose-Hulman Sports and Recreation Center is a state of the art recreational and competitive sports venue, which also serves as a convocation center for special events. The SRC serves the Rose-Hulman community including students, faculty, staff, board of trustees, retirees, alumni, immediate family members, and guests.", 50, 80);
		Node skinner = new Node(
				new Point2D.Double(644, 324),
				"Skinner Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("skinner.jpg").getImage(),
				"Skinner Hall was built in 1976. The apartment lifestyle is one for the more independent student. The hall has air-conditioned apartments (each with two bedrooms, a living room, and a bathroom). The apartment complex has vending machine and laundry facilities. The hall is fully carpeted.", 0, 70);
		Node myers = new Node(
				new Point2D.Double(535, 218),
				"Myers Hall",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("myers.jpg").getImage(),
				"John T. Myers Center for Technological Research with Industry is a research complex with a nanofabrication lab.", 0, 80);
		Node facilities = new Node(new Point2D.Double(589, 141),
				"Facilities Building", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("facilities.jpg")
						.getImage(),
				"Houses equipment for Rose-Hulman's grounds maintenence and incoming packages", 0, 95);
		Node chio = new Node(new Point2D.Double(697, 338), "Chi Omega House",
				new ArrayList<Node>(), new ArrayList<Attractions>(),
				new ImageIcon("chio.jpg").getImage(),
				"House of the officers of the Chi Omega Sorority", 0, 0);
		Node publicSaftey = new Node(new Point2D.Double(667, 355),
				"Public Saftey", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("publicsaftey.jpg")
						.getImage(),
				"Houses Rose-Hulmans public saftey officers and their offices.", 0, 100);
		Node rotz = new Node(
				new Point2D.Double(516, 229),
				"Rotz Labratory",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("rotz.jpg").getImage(),
				"Located just east of Moench Hall, Rotz Lab houses wind tunnels and engine testing equipment for the Department of Mechanical engineering.", 0, 80);
		Node cook = new Node(
				new Point2D.Double(399, 108),
				"Cook Stadium",
				new ArrayList<Node>(),
				new ArrayList<Attractions>(),
				new ImageIcon("cook.jpg").getImage(),
				"Cook Stadium was made possible through the generosity of Bill and Gayle Cook. The Stadium seats 3,500 for activities at Phil Brown Field, the football field. Underneath the south stands are a concession area and a rifle range.", 0, 100);
		Node tennis = new Node(new Point2D.Double(490, 90), "Tennis Courts",
				new ArrayList<Node>(), new ArrayList<Attractions>(),
				new ImageIcon("tennis.jpg").getImage(),
				"Rose-Hulmans tennis courts used for intermural tennis.", 0, 100);
		Node soccerfield = new Node(new Point2D.Double(28, 428),
				"Soccer Field", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("soccer.jpg")
						.getImage(), "Soccer Field named for James Rendel", 0, 100);
		Node baseball = new Node(new Point2D.Double(104, 461),
				"Baseball/Softball Fields", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("baseball.jpg")
						.getImage(),
				"Rose-Hulman's baseball and softbal fields", 0, 0);
		Node imFields = new Node(new Point2D.Double(622, 27),
				"Itramural Fields", new ArrayList<Node>(),
				new ArrayList<Attractions>(), new ImageIcon("im.jpg")
						.getImage(),
				"Fields where many of Rose-Hulmans intramural sports are played.", 0, 100);
		// linking them
		// atos neighbors
		ato.addNeighbor(triangle);
		// triangle
		triangle.addNeighbor(ato);
		triangle.addNeighbor(lambdaChi);
		triangle.addNeighbor(moench);
		triangle.addNeighbor(rotz);
		// lambda chi
		lambdaChi.addNeighbor(sigmaNu);
		lambdaChi.addNeighbor(triangle);
		lambdaChi.addNeighbor(hatfield);
		lambdaChi.addNeighbor(skinner);
		// sig nu
		sigmaNu.addNeighbor(lambdaChi);
		// hatfield
		hatfield.addNeighbor(moench);
		hatfield.addNeighbor(lambdaChi);
		hatfield.addNeighbor(skinner);
		// olin
		olin.addNeighbor(moench);
		olin.addNeighbor(crapo);
		olin.addNeighbor(bsb);
		olin.addNeighbor(logan);
		olin.addNeighbor(deming);
		olin.addNeighbor(hadley);
		// hadley
		hadley.addNeighbor(olin);
		hadley.addNeighbor(moench);
		// moench
		moench.addNeighbor(hadley);
		moench.addNeighbor(olin);
		moench.addNeighbor(crapo);
		moench.addNeighbor(myers);
		moench.addNeighbor(rotz);
		moench.addNeighbor(triangle);
		// crapo
		crapo.addNeighbor(logan);
		crapo.addNeighbor(moench);
		crapo.addNeighbor(olin);
		// logan
		logan.addNeighbor(crapo);
		logan.addNeighbor(deming);
		logan.addNeighbor(moench);
		logan.addNeighbor(olin);
		logan.addNeighbor(src);
		logan.addNeighbor(bsb);
		// deming
		deming.addNeighbor(union);
		deming.addNeighbor(bsb);
		deming.addNeighbor(src);
		deming.addNeighbor(olin);
		deming.addNeighbor(cook);
		// bsb
		bsb.addNeighbor(speed);
		bsb.addNeighbor(deming);
		bsb.addNeighbor(olin);
		// speed
		speed.addNeighbor(percopo);
		speed.addNeighbor(union);
		speed.addNeighbor(bsb);
		// percopo
		percopo.addNeighbor(speed);
		percopo.addNeighbor(chapel);
		percopo.addNeighbor(baseball);
		// chapel
		chapel.addNeighbor(percopo);
		chapel.addNeighbor(apartmentswest);
		chapel.addNeighbor(apartmentseast);
		// apartments east
		apartmentseast.addNeighbor(chapel);
		apartmentseast.addNeighbor(blum);
		apartmentseast.addNeighbor(soccerfield);
		apartmentseast.addNeighbor(apartmentswest);
		// apartments west
		apartmentswest.addNeighbor(apartmentseast);
		
		// blum
		blum.addNeighbor(scharp);
		blum.addNeighbor(mees);
		blum.addNeighbor(apartmentseast);
		// scharp
		scharp.addNeighbor(blum);
		scharp.addNeighbor(mees);
		scharp.addNeighbor(src);
		// mees
		mees.addNeighbor(scharp);
		mees.addNeighbor(blum);
		mees.addNeighbor(union);
		// union
		union.addNeighbor(speed);
		union.addNeighbor(mees);
		union.addNeighbor(src);
		union.addNeighbor(deming);
		union.addNeighbor(bsb);
		// src
		src.addNeighbor(scharp);
		src.addNeighbor(union);
		src.addNeighbor(logan);
		src.addNeighbor(deming);
		src.addNeighbor(cook);
		// skinner
		skinner.addNeighbor(lambdaChi);
		skinner.addNeighbor(hatfield);
		skinner.addNeighbor(publicSaftey);
		// myers
		myers.addNeighbor(rotz);
		myers.addNeighbor(moench);
		myers.addNeighbor(facilities);
		// facilities
		facilities.addNeighbor(myers);
		facilities.addNeighbor(imFields);
		// chio
		chio.addNeighbor(publicSaftey);
		// pub saftey
		publicSaftey.addNeighbor(chio);
		publicSaftey.addNeighbor(skinner);
		// rotz
		rotz.addNeighbor(myers);
		rotz.addNeighbor(moench);
		rotz.addNeighbor(hatfield);
		rotz.addNeighbor(triangle);
		// cook
		cook.addNeighbor(src);
		cook.addNeighbor(tennis);
		cook.addNeighbor(deming);
		// tennis courts
		tennis.addNeighbor(cook);
		tennis.addNeighbor(imFields);
		// soccerfieds
		soccerfield.addNeighbor(baseball);
		soccerfield.addNeighbor(apartmentswest);
		// baseball fields
		baseball.addNeighbor(soccerfield);
		baseball.addNeighbor(percopo);
		// im fields
		imFields.addNeighbor(tennis);
		imFields.addNeighbor(facilities);
		// adding attractions
		speed
				.addAttraction(new Attractions("Speed Beach",
						"The beach on Speed lake a great place to have campfires and socialize"));
		speed
				.addAttraction(new Attractions("Eric Hayes' Aparment",
						"Home of the Assistant director of student affairs and his family."));
		apartmentseast
				.addAttraction(new Attractions("Subway",
						"Our own on campus Subway featuring overpriced subs and the subwaycam"));
		apartmentseast.addAttraction(new Attractions("C-Store",
				"Rose-Hulmans on campus convenience store"));
		apartmentswest.addAttraction(apartmentseast.getAttractions().get(0));
		apartmentswest.addAttraction(apartmentseast.getAttractions().get(1));
		src.addAttraction(new Attractions("Pool",
				"Rose-Hulmans Olympic sized swimming pool with lifeguards."));
		src
				.addAttraction(new Attractions("Basketball Courts",
						"Multiple large basketball courts good for pickup games with other students"));
		cook
				.addAttraction(new Attractions(
						"Football Games",
						"Rose-Hulman's football teams home field as well as the summer training ground for the Indianapolis Colts."));
		union
				.addAttraction(new Attractions(
						"Noble Romans",
						"The on campus pizza place, as they say 'Noble Romans, The better pizza people.'"));
		union.addAttraction(new Attractions("Aramark Cafeteria",
				"The campus cafeteria"));
		// adding them to graph and hash table
		graph.add(ato);
		hashTable.put(ato.name.toLowerCase(), ato);
		graph.add(triangle);
		hashTable.put(triangle.name.toLowerCase(), triangle);
		graph.add(lambdaChi);
		hashTable.put(lambdaChi.name.toLowerCase(), lambdaChi);
		graph.add(sigmaNu);
		hashTable.put(sigmaNu.name.toLowerCase(), sigmaNu);
		graph.add(hatfield);
		hashTable.put(hatfield.name.toLowerCase(), hatfield);
		graph.add(olin);
		hashTable.put(olin.name.toLowerCase(), olin);
		graph.add(hadley);
		hashTable.put(hadley.name.toLowerCase(), hadley);
		graph.add(moench);
		hashTable.put(moench.name.toLowerCase(), moench);
		graph.add(crapo);
		hashTable.put(crapo.name.toLowerCase(), crapo);
		graph.add(logan);
		hashTable.put(logan.name.toLowerCase(), logan);
		graph.add(deming);
		hashTable.put(deming.name.toLowerCase(), deming);
		graph.add(bsb);
		hashTable.put(bsb.name.toLowerCase(), bsb);
		graph.add(speed);
		hashTable.put(speed.name.toLowerCase(), speed);
		graph.add(percopo);
		hashTable.put(percopo.name.toLowerCase(), percopo);
		graph.add(chapel);
		hashTable.put(chapel.name.toLowerCase(), chapel);
		graph.add(apartmentseast);
		hashTable.put(apartmentseast.name.toLowerCase(), apartmentseast);
		graph.add(apartmentswest);
		hashTable.put(apartmentswest.name.toLowerCase(), apartmentswest);
		graph.add(blum);
		hashTable.put(blum.name.toLowerCase(), blum);
		graph.add(scharp);
		hashTable.put(scharp.name.toLowerCase(), scharp);
		graph.add(mees);
		hashTable.put(mees.name.toLowerCase(), mees);
		graph.add(union);
		hashTable.put(union.name.toLowerCase(), union);
		graph.add(src);
		hashTable.put(src.name.toLowerCase(), src);
		graph.add(skinner);
		hashTable.put(skinner.name.toLowerCase(), skinner);
		graph.add(myers);
		hashTable.put(myers.name.toLowerCase(), myers);
		graph.add(facilities);
		hashTable.put(facilities.name.toLowerCase(), facilities);
		graph.add(chio);
		hashTable.put(chio.name.toLowerCase(), chio);
		graph.add(publicSaftey);
		hashTable.put(publicSaftey.name.toLowerCase(), publicSaftey);
		graph.add(rotz);
		hashTable.put(rotz.name.toLowerCase(), rotz);
		graph.add(cook);
		hashTable.put(cook.name.toLowerCase(), cook);
		graph.add(tennis);
		hashTable.put(tennis.name.toLowerCase(), tennis);
		graph.add(soccerfield);
		hashTable.put(soccerfield.name.toLowerCase(), soccerfield);
		graph.add(baseball);
		hashTable.put(baseball.name.toLowerCase(), baseball);
		graph.add(imFields);
		hashTable.put(imFields.name.toLowerCase(), imFields);
	}
}

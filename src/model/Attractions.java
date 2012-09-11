package model;
import java.util.ArrayList;


/**
 * @author Luke Kennedy. Created May 10, 2010.
 */
public class Attractions {

	private ArrayList<Ratings> ratings = new ArrayList<Ratings>();
	protected String description;
	public String name;

	public Attractions(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public boolean addRating(Double r) {
		return (this.ratings.add(new Ratings(r)));
	}

	public Double getRating() {
		if (this.ratings.isEmpty())
			return 0.0;
		Double sum = 0.0;
		for (Ratings rating : ratings) {
			sum += rating.getRating();
		}
		return sum / ratings.size();
	}

	public void clearRatings() {
		this.ratings = new ArrayList<Ratings>();
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String toString() {
		return this.name;
	}
}

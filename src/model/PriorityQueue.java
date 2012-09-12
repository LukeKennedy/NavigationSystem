package model;
import java.util.ArrayList;

/**
 * @author Luke Kennedy. Created Apr 12, 2010.
 */
public class PriorityQueue<E extends Comparable<? super E>> extends
		ArrayList<E> {

	private static final long serialVersionUID = 4762899098379886320L;

	public PriorityQueue() {
		// Empty
	}

	public E poll() {
		if (this.size() == 0)
			return null;
		E temp = this.get(0);
		this.remove(temp);
		return temp;
	}

	public boolean offer(E e) {
		return this.add(e);
	}

	public E peek() {
		if (this.size() == 0)
			return null;
		return this.get(0);
	}

	public boolean add(E e) {
		if (e == null)
			throw new NullPointerException();
		int index = this.size();
		add(index, e);
		while (e.compareTo(this.get(index / 2)) < 0) {
			if (index == 2) {
				set(index, this.get(0));
				set(0, e);
			} else {
				if (index % 2 == 0) {
					set(index, this.get((index / 2) - 1));
					set((index / 2) - 1, e);
				} else {
					set(index, this.get(index / 2));
					set(index / 2, e);
				}
			}
			if (index % 2 == 0) {
				index = (index / 2) - 1;
			} else
				index *= .5;

		}

		return true;
	}

	public boolean remove(Object o) {
		if (!contains(o) || this.size() == 0) {
			return false;
		} else {
			boolean returner = super.remove(o);
			int index = 1;
			while ((index * 2 < size() && get(index).compareTo(get(index * 2)) > 0)
					|| (index * 2 + 1 < size() && get(index).compareTo(
							get(index * 2 + 1)) > 0)) {
				if (index * 2 + 1 >= size()
						|| get(index * 2).compareTo(get(index * 2 + 1)) < 0) {
					E temp = get(index);
					set(index, get(index * 2));
					set(index * 2, temp);
					index *= 2;
				} else {
					E temp = get(index);
					set(index, get(index * 2 + 1));
					set(index * 2 + 1, temp);
					index = index * 2 + 1;
				}
			}

			return returner;
		}
	}
}
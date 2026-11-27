package il.ac.tau.cs.software1.inventory;

import javax.naming.InitialContext;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] items;
	private int count;

	public NaiveInventory() {
		this.items = new Collectible[INITIAL_CAPACITY];
		this.count = 0;
	}
	
	@Override
	public void collect(Collectible collectible) {
		if(count == items.length) {
			Collectible[] new_items = new Collectible[2 * (items.length)];
			for( int i = 0 ; i < items.length ; i ++) {
				new_items[i] = items[i];
			}
			items = new_items;
		}

		items[count] = collectible;
		count ++;

	}


	@Override
	public float getTotalWeight() {
		float res = 0;
		for(int i = 0 ; i < count ; i++) {
			res += items[i].getWeight();
		}
		return res;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return items;
	}
}

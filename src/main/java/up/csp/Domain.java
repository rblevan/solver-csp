package up.csp;

import java.util.Arrays;

/**
 * Represents the set of possible values for a {@link Variable}.
 * <p>
 * This class implements a domain using a boolean array to track the presence
 * of values within a specific range [min, max]
 * </p>
 * @author Evan RIBOULEAU
 */
public class Domain {

	private int min;
	private int max;
	private boolean[] presence;

	/**
	 * Constructor for Domain class
	 * @param min minimum value
	 * @param max maximum value
	 */
	public Domain(int min, int max) {
		this.min = min;
		this.max = max;
		if (this.min > this.max) {
			int temp = this.min;
			this.min = this.max;
			this.max = temp;
		}
		this.presence = new boolean[this.max - this.min + 1];
        Arrays.fill(this.presence, true);
    }

	/**
	 * This method remove an integer to the domain
	 * @param value integer to remove
	 */
	public void removeValue(int value) {
		if (value >= this.min && value <= this.max) {
            this.presence[value - this.min] = false;
        }
	}

	/**
	 * This method watch if an integer is in the domain
	 * @param value integer tested
	 * @return boolean
	 */
	public boolean contains(int value) {
        if (value < min || value > max) {
            return false;
        }
        return this.presence[value - this.min];
	}

	public int size() {
        int count = 0;
        for (boolean b : this.presence) {
            if (b) {
                count++;
            }
        }
        return count;
	}


	public int getMin() {
		return this.min;
	}

	public int getMax() {
		return this.max;
	}

}
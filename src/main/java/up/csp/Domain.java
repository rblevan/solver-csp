package up.csp;

import java.util.Arrays;

public class Domain {

	private Variable domain;
	private int min;
	private int max;
	private boolean[] presence;
	/**
	 * 
	 * @param min minimum value
	 * @param max maximum value
	 */
	public Domain(int min, int max) {
		this.min = min;
		this.max = max;
		this.presence = new boolean[this.max - this.min + 1];
        Arrays.fill(this.presence, true);
    }

	/**
	 * 
	 * @param value
	 * This method remove an integer to the domain
	 */
	public void removeValue(int value) {
		if (value >= this.min && value <= this.max) {
            this.presence[value - this.min] = false;
        }
	}

	/**
	 * 
	 * @param value
	 * This method watch if an integer is in the domain
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


	//A AJOUTER DANS MAIN
	public int getMin() {
		return this.min;
	}

	public int getMax() {
		return this.max;
	}

}
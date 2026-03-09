package up.csp;

import java.util.Arrays;

public class Domain {

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
		if (this.min > this.max) {
			int temp = this.min;
			this.min = this.max;
			this.max = temp;
		}
		this.presence = new boolean[this.max - this.min + 1];
        Arrays.fill(this.presence, true);
    }

	/**
	 * 
	 * @param value
	 * This method remove an integer to the domain.
	 */
	public void removeValue(int value) {
		if (value >= this.min && value <= this.max) {
            this.presence[value - this.min] = false;
        }
	}

	/**
	 *
	 * @param value
	 * This method restore an integer to the domain.
	 * */
	public void restoreValue(int value) {
		if (value >= this.min && value <= this.max) {
			this.presence[value - this.min] = true;
		}
	}

	/**
	 * 
	 * @param value
	 * This method watch if an integer is in the domain.
	 */
	public boolean contains(int value) {
        if (value < min || value > max) {
            return false;
        }
        return this.presence[value - this.min];
	}

	/**
	 *
	 * This method return the size of the domain.
	 * */

	public int size() {
        int count = 0;
        for (boolean b : this.presence) {
            if (b) {
                count++;
            }
        }
        return count;
	}

	/**
	 *
	 * @param d Second domain
	 * This method modifies the current domain to keep only the values present in both domains.
	 * */
	public void intersection(Domain d) {
		for (int i = 0; i < this.presence.length; i++) {
			if (this.presence[i]) {
				int val = this.min + i;
				if (!d.contains(val)) {
					this.presence[i] = false;
					d.removeValue(i);
				}
			}
		}
	}

	

	public int getMin() {
		return this.min;
	}

	public int getMax() {
		return this.max;
	}

}
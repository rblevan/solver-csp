package up.csp;

public class Domain {

	private Variable domain;
	private int min;
	private int max;
	private boolean[] presence;

	/**
	 * 
	 * @param min
	 * @param max
	 */
	public Domain(int min, int max) {
		// TODO - implement Domain.Domain
		this.min = min;
		this.max = max;
		this.presence = new boolean[max - min + 1];
	}

	/**
	 * 
	 * @param value
	 * This method remove a integer to the domain
	 */
	public void removeValue(int value) {
		// TODO - implement Domain.removeValue
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param value
	 * This method watch if a integer is in the domain
	 */
	public boolean contains(int value) {
		// TODO - implement Domain.contains
		if (this.presence[this.max - value] == true) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		// TODO - implement Domain.size
		throw new UnsupportedOperationException();
	}

}
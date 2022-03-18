package snakes;

/**
 * A die for rolling random numbers
 */
public class Die{
	protected final int faces;

	/**
	 * Initialize a new die with given faces
	 * @param faces number of sides, must be > 0
	 */
	public Die(int faces) {
		assert faces > 0;
		this.faces = faces;
	}

	/**
	 * Roll the die and obtain the result
	 *
	 * @return a random number between 1 and faces
	 */
	public int roll() {
		int result = 1 + (int) (faces * Math.random());
		assert result >= 1 && result <= faces;
		return result;
	}
}

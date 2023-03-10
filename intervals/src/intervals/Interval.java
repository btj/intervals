package intervals;
/*
 * Procedure for defining a data abstraction:
 * 
 * 1. Define the raw abstract state space
 *    = declare the inspectors
 * 
 * 2. Define the valid abstract state space (= space of valid abstract states)
 *    = write the abstract state invariants
 * 
 * 3. Declare and document the factory methods and the mutator methods
 */

/*
 * Procedure for implementing a data abstraction:
 * 
 * 1. Define the raw concrete state space =
 *    define the fields
 * 
 * 2. Define the valid concrete state space =
 *    write the representation invariants
 *    
 * 3. Define the mapping from concrete states to abstract states =
 *    implement the inspectors
 *    Note: every valid concrete state must map to a valid abstract state
 * 
 * 4. Implement the factory methods and the mutator methods 
 */

/**
 * Abstract state invariants:
 * 
 * @invar The lower bound is not greater than the upper bound
 *      | this.getLowerBound() <= this.getUpperBound()
 * @invar The length equals the difference of the upper bound and the lower bound
 *      | this.getLength() == this.getUpperBound() - this.getLowerBound()
 */
public class Interval {
	
	/**
	 * Representation invariants:
	 * 
	 * @invar | lowerBound <= upperBound
	 */
	private int lowerBound;
	private int upperBound;
	
	public int getLowerBound() { return this.lowerBound; }
	
	public int getUpperBound() { return this.upperBound; }

	public int getLength() { return this.upperBound - this.lowerBound; }
	
	/**
	 * @post | result == (this.getLowerBound() <= x && x < this.getUpperBound())  
	 */
	public boolean contains(int x) {
		return (this.getLowerBound() <= x && x < this.getUpperBound());
	}
	
	/**
	 * @pre | lowerBound <= upperBound
	 * @post | result.getLowerBound() == lowerBound
	 * @post | result.getUpperBound() == upperBound
	 */
	public static Interval create(int lowerBound, int upperBound) {
		Interval result = new Interval();
		result.lowerBound = lowerBound;
		result.upperBound = upperBound;
		return result;
	}
	
	/**
	 * @pre | other != null
	 * @post | result.getLowerBound() == this.getLowerBound() + other.getLowerBound()
	 * @post | result.getLength() == this.getLength() + other.getLength()
	 */
	public Interval plus(Interval other) {
		return create(
				this.lowerBound + other.lowerBound,
				this.upperBound + other.upperBound);
	}
	
}

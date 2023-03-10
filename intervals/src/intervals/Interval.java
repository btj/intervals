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
 *      | getLowerBound() <= getUpperBound()
 * @invar The length equals the difference of the upper bound and the lower bound
 *      | getLength() == getUpperBound() - getLowerBound()
 */
public class Interval {
	
	/**
	 * Representation invariants:
	 * 
	 * @invar | lowerBound <= upperBound
	 */
	private int lowerBound;
	private int upperBound;
	
	public int getLowerBound() { return lowerBound; }
	
	public int getUpperBound() { return upperBound; }

	public int getLength() { return upperBound - lowerBound; }
	
	/**
	 * @post | result == (getLowerBound() <= x && x < getUpperBound())  
	 */
	public boolean contains(int x) {
		return (getLowerBound() <= x && x < getUpperBound());
	}

	/**
	 * @pre | lowerBound <= upperBound
	 * @post | getLowerBound() == lowerBound
	 * @post | getUpperBound() == upperBound
	 */
	public Interval(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
		
	/**
	 * @pre | other != null
	 * @post | result.getLowerBound() == getLowerBound() + other.getLowerBound()
	 * @post | result.getLength() == getLength() + other.getLength()
	 */
	public Interval plus(Interval other) {
		return new Interval(
				lowerBound + other.lowerBound,
				upperBound + other.upperBound);
	}
	
}

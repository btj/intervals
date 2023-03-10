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
 *      | getLowerBound(this) <= getUpperBound(this)
 * @invar The length equals the difference of the upper bound and the lower bound
 *      | getLength(this) == getUpperBound(this) - getLowerBound(this)
 */
public class Interval {
	
	/**
	 * Representation invariants:
	 * 
	 * @invar | lowerBound <= upperBound
	 */
	private int lowerBound;
	private int upperBound;
	
	public static int getLowerBound(Interval interval) { return interval.lowerBound; }
	
	public static int getUpperBound(Interval interval) { return interval.upperBound; }

	public static int getLength(Interval interval) { return interval.upperBound - interval.lowerBound; }
	
	/**
	 * @post | result == (getLowerBound(interval) <= x && x < getUpperBound(interval))  
	 */
	public static boolean contains(Interval interval, int x) {
		return (getLowerBound(interval) <= x && x < getUpperBound(interval));
	}
	
	/**
	 * @pre | lowerBound <= upperBound
	 * @post | getLowerBound(result) == lowerBound
	 * @post | getUpperBound(result) == upperBound
	 */
	public static Interval create(int lowerBound, int upperBound) {
		Interval result = new Interval();
		result.lowerBound = lowerBound;
		result.upperBound = upperBound;
		return result;
	}
	
	/**
	 * @pre | interval != null
	 * @pre | other != null
	 * @post | getLowerBound(result) == getLowerBound(interval) + getLowerBound(other)
	 * @post | getLength(result) == getLength(interval) + getLength(other)
	 */
	public static Interval plus(Interval interval, Interval other) {
		return create(
				interval.lowerBound + other.lowerBound,
				interval.upperBound + other.upperBound);
	}
	
}

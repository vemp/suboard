package suboard.board;

public class Cell {
	private static final int SIZE = 3;
	
	private boolean[] candidates;
	private Integer value;
	
	/**
	 * default constructor, value is not set and all candidates are enabled
	 */
	public Cell() {
		this.candidates = new boolean[SIZE * SIZE];
		for (int i = 0; i < this.candidates.length; i++) {
			this.candidates[i] = true;
		}
		this.value = 0;
	}
	
	/**
	 * constructor with a given value, for a Cell that starts solved
	 */
	public Cell(Integer value) {
		this.value = value;
		this.candidates = new boolean[SIZE * SIZE];
		for (int i = 0; i < this.candidates.length; i++) {
			this.candidates[i] = (i + 1 == value) ? true : false;
		}
	}
	
	/**
	 * constructor with a given array of candidates
	 */
	public Cell(boolean[] candidates) {
		this.candidates = candidates;
		this.value = lookForSolution();
	}
	
	/**
	 * checks if the cell is solved, i.e. if all candidates
	 * are false except for exactly one.
	 */
	private int lookForSolution() {
		int value = 0;
		for (int i = 0; i < this.candidates.length; i++) {
			if (value == 0) {
				value = (this.candidates[i] ? i+1 : value);
			} else {
				return 0;
			}
		}
		return value;
	}
	
	/**
	 * delete a candidate, i.e. say that it's not a possible
	 * solution for the cell.
	 * @param value
	 */
	public void deleteCandidate(int value) {
		this.candidates[value-1] = false;
		this.value = lookForSolution();
	}

	/**
	 * Get the array of booleans representing the valid candidates for the cell.
	 * True values are possible solution, false values are discarded ones.
	 * @return
	 */
	public boolean[] getCandidates() {
		return this.candidates;
	}

	/**
	 * Returns the current cell value if solved, 0 otherwise.
	 * @return
	 */
	public Integer getValue() {
		return this.value;
	}
	
	/**
	 * Returns true if the cell is solved, i.e. it has only one true candidate
	 * and its current value is not 0.
	 * @return
	 */
	public boolean isSolved() {
		return (this.value != 0);
	}
	
	/**
	 * Override toString method to print information about the current state of this cell.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Cell is ");
		if (this.value > 0) {
			sb.append("solved;\n");
			sb.append("Value is " + this.value + ".\n");
		} else {
			sb.append("NOT solved;\n");
			sb.append("Candidates left: [");
			for (int i = 0; i < this.candidates.length; i++) {
				if (this.candidates[i]) {
					sb.append((i+1) + " ");
				}
			}
			sb.append("]\n");
		}
		return sb.toString();
	}
}

package jgogears2;

import java.util.BitSet;
<<<<<<< HEAD:jgogears/Zobrist.java
=======

import jgogears.Random;
import jgogears.gtp.Statics;
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/Zobrist.java

/**
 * Class representing a Zobrist hash, a binary hash of the current board state.
 * 
 * All of the magic is in some static initialisation, the constructor and compareTo()
 * 
 * TODO add proper references
 * 
 * @author syeates@gmail.com
<<<<<<< HEAD:jgogears/Zobrist.java
=======
 * @see ZorbistTest
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/Zobrist.java
 */

public class Zobrist extends BitSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5031699980490524586L;

	/** The Constant MAX_BOARD_SIZE. */
	public static final short MAX_BOARD_SIZE = 25;

	/** The Constant MAX_COLOUR. */
	public static final short MAX_COLOUR = 4;

	/** The Constant ZOBRIST_SIZE. */
	public static final short ZOBRIST_SIZE = 96;

	// initialisers ...
	/** The static grid of all random values */
	static BitSet[][][] grid = null;

	/**
	 * Initialises the static grid of random values
	 */
	static private void init() {
		if (grid == null) {
			grid = new BitSet[MAX_BOARD_SIZE][MAX_BOARD_SIZE][MAX_COLOUR];

			for (int i = 0; i < MAX_BOARD_SIZE; i++)
				for (int j = 0; j < MAX_BOARD_SIZE; j++)
					for (int k = 0; k < MAX_COLOUR; k++) {
						grid[i][j][k] = new BitSet();
						// System.err.println("" + i + " " + j + " " + k);
						for (int l = 0; l < ZOBRIST_SIZE; l++) {
							grid[i][j][k].set(l, Random.nextBoolean());
						}
					}
		}
	}

	/**
	 * Default constructor, represents an empty board.
	 */
	public Zobrist() {
		init();
	}

	/**
	 * Constructor building a Zobrist from an existing Zobrist and a move.
	 * 
	 * @param old
	 *            the old
	 * @param row
	 *            the row
	 * @param column
	 *            the column
	 * @param colour
	 *            the colour
	 */
	public Zobrist(Zobrist old, int row, int column, int colour) {
		init();
<<<<<<< HEAD:jgogears/Zobrist.java
		if (row > MAX_BOARD_SIZE || row < 0)
			throw new Error("" + row);
		if (column > MAX_BOARD_SIZE || column < 0)
			throw new Error("" + column);
		if (colour > Statics.VERTEX_MAX || colour < Statics.VERTEX_MIN)
			throw new Error("" + colour);
=======
		if (row >= MAX_BOARD_SIZE || row < 0)
			throw new Error("Bad row size: " + row);
		if (column >= MAX_BOARD_SIZE || column < 0)
			throw new Error("BAd column size: " + column);
		if (colour >= Statics.VERTEX_MAX || colour < Statics.VERTEX_MIN)
			throw new Error("Bad colour 1: " + colour);
		if (colour >= MAX_COLOUR)
			throw new Error("Bad colour 2:" + colour);
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/Zobrist.java
		this.clear();
		this.xor(old);
		this.xor(grid[row][column][colour]);
	}

	/**
	 * compare this zobrist to another object, potentially another zobrist
	 * 
	 * @param o
	 *            the other Object
	 * @return 0 if equal, otherwise 1/-1
	 */
	public int compareTo(Object o) {
		if (o == null)
			throw new Error();
		if (o.getClass() != this.getClass())
			return this.hashCode() > o.hashCode() ? 1 : -1;
		Zobrist other = (Zobrist) o;
		for (int i = 0; i < this.size(); i++)
			if (this.get(i) != other.get(i))
				return this.get(i) == true ? 1 : -1;
		return 0;
	}

}
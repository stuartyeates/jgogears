/**
 * 
 */
package jgogears2;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardToASCIITest.
 * @author syeates@gmail.com
 */
public class BoardToASCIITest extends TestCase {

	/** The Constant DEBUG. */
	static final public boolean DEBUG = false;

	/**
	 * Test empty.
	 */
	public void testEmpty() {
<<<<<<< HEAD:jgogears/BoardToASCIITest.java
		Board board = Board.newBoard();
=======
		Board board = new Board();
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/BoardToASCIITest.java
		String string = BoardToASCII.Transform(board);
		assertNotNull(board);
		assertNotNull(string);
	}

	/**
	 * Test one.
	 */
	public void testOne() {
<<<<<<< HEAD:jgogears/BoardToASCIITest.java
		Board board = Board.newBoard();
		board = board.newBoard(new Move("w b1"));
=======
		Board board = new Board();
		board = board.playMove(new Move("w b1"));
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/BoardToASCIITest.java
		String string = BoardToASCII.Transform(board);
		assertNotNull(board);
		assertNotNull(string);
		if (DEBUG)
			System.err.println(string);
	}

}

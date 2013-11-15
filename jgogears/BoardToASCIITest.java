/**
 * 
 */
package jgogears;

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
		Board board = Board.newBoard();
		String string = BoardToASCII.Transform(board);
		assertNotNull(board);
		assertNotNull(string);
	}

	/**
	 * Test one.
	 */
	public void testOne() {
		Board board = Board.newBoard();
		board = board.newBoard(new Move("w b1"));
		String string = BoardToASCII.Transform(board);
		assertNotNull(board);
		assertNotNull(string);
		if (DEBUG)
			System.err.println(string);
	}

}

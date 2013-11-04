/**
 * 
 */
package jgogears2;

import jgogears.SmallBoard;
import jgogears.SmallerBoard;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardToASCIITest.
 */
public class BoardToASCIITest extends TestCase {

	/** The Constant DEBUG. */
	static final public boolean DEBUG = false;

	/**
	 * Test empty.
	 */
	public void testEmpty() {
		Board board = new Board();
		String string = BoardToASCII.Transform(board);
		assertNotNull(board);
		assertNotNull(string);
	}

	/**
	 * Test one.
	 */
	public void testOne() {
		Board board = new Board();
		board = board.newBoard(new Move("w b1"));
		String string = BoardToASCII.Transform(board);
		assertNotNull(board);
		assertNotNull(string);
		if (DEBUG)
			System.err.println(string);
	}

}

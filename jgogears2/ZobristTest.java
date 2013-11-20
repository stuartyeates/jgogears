package jgogears2;

import jgogears.BoardI;
import jgogears.Move;
import jgogears.SmallBoard;
import jgogears.SmallerBoard;
import jgogears.gtp.Statics;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * tests for Zobrist hash
 * 
<<<<<<< HEAD:jgogears/ZobristTest.java
 * @author syeates@gmail.com
=======
 * @author syeates
 * @see Zobrist
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
 */

public class ZobristTest extends TestCase {

	/**
	 * Check that all of the hashes are different.
	 */
	public void testEachNotEqual() {
		// this is needed to initialise the random numbers
		Zobrist z = new Zobrist();
		assertNotNull(z);

		for (int i = 0; i < Zobrist.MAX_BOARD_SIZE; i++)
			for (int j = 0; j < Zobrist.MAX_BOARD_SIZE; j++)
				for (int k = 0; k < Zobrist.MAX_COLOUR; k++)
					for (int l = 0; l < Zobrist.MAX_BOARD_SIZE; l++)
						for (int m = 0; m < Zobrist.MAX_BOARD_SIZE; m++)
							for (int n = 0; n < Zobrist.MAX_COLOUR; n++)
								if (i != l || j != m || k != n)
									assertFalse(
											"" + i + " " + j + " " + k + " "
													+ l + " " + m + " " + n,
											Zobrist.grid[i][j][k] == Zobrist.grid[l][m][n]);
	}

	/**
	 * Check that placing a move and then removing it gives the same hash.
	 */
	public void testEachUndoable() {
		for (int i = 0; i < Zobrist.MAX_BOARD_SIZE; i++)
			for (int j = 0; j < Zobrist.MAX_BOARD_SIZE; j++)
				for (int k = 0; k < Zobrist.MAX_COLOUR; k++) {
					Zobrist z = new Zobrist();
					Zobrist z2 = new Zobrist(z, i, j, k);
					Zobrist z3 = new Zobrist(z2, i, j, k);
					Zobrist z4 = new Zobrist(z3, i, j, k);
					Zobrist z5 = new Zobrist(z4, i, j, k);
					Zobrist zz = new Zobrist(z, i, j, k);

					assertNotNull(z);
					assertNotNull(z2);
					assertNotNull(z3);
					assertNotNull(z4);
					assertNotNull(z5);

					assertTrue(z2.equals(zz));
					assertFalse(z2.equals(z));
					assertFalse(z4.equals(z));
					assertTrue(z.equals(z));
					assertTrue(z.compareTo(z) == 0);
					assertTrue(z2.compareTo(z2) == 0);
					assertTrue(z3.compareTo(z3) == 0);
					assertTrue(z4.compareTo(z4) == 0);
					assertTrue(z5.compareTo(z5) == 0);
					assertTrue(z.compareTo(z3) == 0);
					assertTrue(z.compareTo(z5) == 0);
					assertTrue(z3.compareTo(z5) == 0);

				}
	}

	/**
	 * Test each undoable ii.
	 */
	public void testEachUndoableII() {
		for (int i = 0; i < Zobrist.MAX_BOARD_SIZE; i++)
			for (int j = 0; j < Zobrist.MAX_BOARD_SIZE; j++)
				for (int k = 0; k < Zobrist.MAX_COLOUR; k++) {
					Zobrist z = new Zobrist();
					Zobrist z2 = new Zobrist(z, i, j, k);
					Zobrist z3 = new Zobrist(z, i, j, k);

					assertNotNull(z);
					assertNotNull(z2);

					assertFalse(z2.equals(z));
					assertTrue(z2.equals(z3));

<<<<<<< HEAD:jgogears/ZobristTest.java
					Board board1 = Board.newBoard();
					Board board2 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					Board board3 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					// Board board4 = board2.newBoard(new Move((short) 1,
					// (short) 1, Statics.VERTEX_BLACK));
=======
					BoardI board1 = BoardI.newBoard(true);
					BoardI board2 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					BoardI board3 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					// BoardI board4 = board2.newBoard(new Move((short) 1,
					// (short) 1, BoardI.VERTEX_BLACK));
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
					// make sure the hashes are the same
					assertFalse(board1.getZobrist().equals(board2.getZobrist()));
					assertFalse(board1.getZobrist().equals(board3.getZobrist()));
					// assertTrue(board1.getZobrist().equals(board4.getZobrist()));
					assertTrue(board2.getZobrist().equals(board3.getZobrist()));

				}
	}

	/**
	 * Test equality.
	 */
	public void testEquality() {
<<<<<<< HEAD:jgogears/ZobristTest.java
		Board board = Board.newBoard();
		Board board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		Board board3 = board2.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_WHITE));
		Board board4 = Board.newBoard().newBoard(
				new Move((short) 2, (short) 2, Statics.VERTEX_WHITE));
		Board board5 = board4.newBoard(new Move((short) 1, (short) 1,
=======
		BoardI board = BoardI.newBoard(true);
		BoardI board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		BoardI board3 = board2.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_WHITE));
		BoardI board4 = BoardI.newBoard(true).newBoard(
				new Move((short) 2, (short) 2, Statics.VERTEX_WHITE));
		BoardI board5 = board4.newBoard(new Move((short) 1, (short) 1,
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
				Statics.VERTEX_BLACK));
		assertTrue(board.getZobrist()
				.equals(Board.newBoard().getZobrist()));
		assertTrue(board3.getZobrist().equals(board5.getZobrist()));
		assertFalse(board2.getZobrist().equals(board4.getZobrist()));
	}

	/**
	 * Test instantiation.
	 */
	public void testInstantiation() {
		Zobrist z = new Zobrist();
		assertNotNull(z);
	}

	/**
	 * Test trivial.
	 */
	public void testTrivial() {
		Zobrist z = new Zobrist();
		Zobrist z2 = new Zobrist(z, 1, 1, 1);
		assertNotNull(z2);
		assertFalse(z2 == z);

		z = z2;
		z2 = new Zobrist(z, 1, 1, 1);
		assertNotNull(z2);
		assertFalse(z2 == z);
		assertFalse(z2 == new Zobrist());
	}

	/**
	 * Test with board.
	 */
	public void testWithBoard() {
<<<<<<< HEAD:jgogears/ZobristTest.java
		Board board = Board.newBoard();
		Board board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		Board board3 = board.newBoard(new Move((short) 1, (short) 1,
=======
		BoardI board = BoardI.newBoard(true);
		BoardI board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		BoardI board3 = board.newBoard(new Move((short) 1, (short) 1,
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
				Statics.VERTEX_BLACK));
		assertTrue(board2.getZobrist().equals(board3.getZobrist()));
		assertTrue(board3.getZobrist().equals(board2.getZobrist()));
		assertFalse(board.getZobrist().equals(board2.getZobrist()));
		assertFalse(board2.getZobrist().equals(board.getZobrist()));
		assertFalse(board.getZobrist().equals(board3.getZobrist()));
		assertFalse(board3.getZobrist().equals(board.getZobrist()));
	}

	/**
	 * Test with board.
	 */
	public void testWithBoardBasic() {
<<<<<<< HEAD:jgogears/ZobristTest.java
		Board board = Board.newBoard();
=======
		BoardI board = BoardI.newBoard();
		if (Statics.DEFAULT_ZOBRIST)
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
			assertTrue(board.getZobrist() != null);
	}

	/**
	 * Test with board order.
	 */
	public void testWithBoardOrder() {
<<<<<<< HEAD:jgogears/ZobristTest.java
		Board board = Board.newBoard();
		Board board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		Board board3 = board2.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_WHITE));
		Board board4 = board.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_WHITE));
		Board board5 = board4.newBoard(new Move((short) 1, (short) 1,
=======
		BoardI board = BoardI.newBoard(true);
		BoardI board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		BoardI board3 = board2.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_WHITE));
		BoardI board4 = board.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_WHITE));
		BoardI board5 = board4.newBoard(new Move((short) 1, (short) 1,
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
				Statics.VERTEX_BLACK));
		assertTrue(board3.getZobrist().equals(board5.getZobrist()));
		assertFalse(board2.getZobrist().equals(board4.getZobrist()));

<<<<<<< HEAD:jgogears/ZobristTest.java
		Board board6 = board.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_BLACK));
		Board board7 = board6.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_WHITE));
		if (DEBUG) {
			System.err.println(board5.getZobrist());
			System.err.println(board7.getZobrist());
		}
		assertTrue(board5.getZobrist().equals(board7.getZobrist()));

		Board board8 = board.newBoard(new Move((short) 1, (short) 1,
=======
		BoardI board6 = board.newBoard(new Move((short) 2, (short) 2,
				Statics.VERTEX_BLACK));
		BoardI board7 = board6.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_WHITE));

		assertTrue(board5.getZobrist().equals(board7.getZobrist()));

		BoardI board8 = board.newBoard(new Move((short) 1, (short) 1,
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
				Statics.VERTEX_WHITE));
		assertTrue(board8.getZobrist().equals(board2.getZobrist()));
	}

	/**
	 * Test with board remove.
	 */
	public void testWithBoardRemove() {
<<<<<<< HEAD:jgogears/ZobristTest.java
		Board board = Board.newBoard();
		Board board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		Board board3 = board2.newBoard(new Move((short) 1, (short) 1,
=======
		BoardI board = BoardI.newBoard(true);
		BoardI board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		BoardI board3 = board2.newBoard(new Move((short) 1, (short) 1,
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
				Statics.VERTEX_EMPTY));
		assertFalse(board2.getZobrist().equals(board3.getZobrist()));
		assertFalse(board3.getZobrist().equals(board2.getZobrist()));
		assertFalse(board2.getZobrist().equals(board.getZobrist()));
		assertFalse(board.getZobrist().equals(board2.getZobrist()));
		assertTrue(board3.getZobrist().equals(board.getZobrist()));
		assertTrue(board.getZobrist().equals(board3.getZobrist()));
	}

	/**
	 * Test with board.
	 */
	public void testWithBoardSizes() {
		for (short i = 0; i < Zobrist.MAX_BOARD_SIZE; i++) {
			Board board = new Board((short)19);
			Board board2 = new Board(i);
			assertNotNull(board);
			assertNotNull(board2);
		}

	}
<<<<<<< HEAD:jgogears/ZobristTest.java
=======

	/**
	 * Test with board.
	 */
	public void testWithFastBoard() {
		BoardI board = new SmallBoard(true);
		BoardI board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		BoardI board3 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));

		assertTrue(board2.getZobrist().equals(board3.getZobrist()));
		assertTrue(board3.getZobrist().equals(board2.getZobrist()));
		assertFalse(board.getZobrist().equals(board2.getZobrist()));
		assertFalse(board2.getZobrist().equals(board.getZobrist()));
		assertFalse(board.getZobrist().equals(board3.getZobrist()));
		assertFalse(board3.getZobrist().equals(board.getZobrist()));
	}

	/**
	 * Test with board.
	 */
	public void testWithFasterBoard() {
		BoardI board = new SmallerBoard(true);
		BoardI board2 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		BoardI board3 = board.newBoard(new Move((short) 1, (short) 1,
				Statics.VERTEX_BLACK));
		assertTrue(board2.getZobrist().equals(board3.getZobrist()));
		assertTrue(board3.getZobrist().equals(board2.getZobrist()));
		assertFalse(board.getZobrist().equals(board2.getZobrist()));
		assertFalse(board2.getZobrist().equals(board.getZobrist()));
		assertFalse(board.getZobrist().equals(board3.getZobrist()));
		assertFalse(board3.getZobrist().equals(board.getZobrist()));
	}
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears2/ZobristTest.java
}

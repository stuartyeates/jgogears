package jgogears;

import junit.framework.TestCase;

public class BoardTest2 extends TestCase {

	public final void testBoard() {
		Board board = new Board();
		Board board2 = new Board();
		assertTrue(board2.equals(board));
		assertFalse(board2.equals(this));
	}

	public final void testBoardBoardMove() {
		Board board = new Board();
		for (short i = 0; i <= Statics.MAX_BOARD_SIZE; i++) 
			for (short j = 0; j <= Statics.MAX_BOARD_SIZE; j++) {
				{
						Move move = new Move(i,j, Statics.COLOUR_BLACK);
						Board board2 = new Board(board, move);
			assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
				}
			}
	}


	public final void testBoardInt() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoardIntRuleSet() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoardRuleSet() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoardShort() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoardShortRuleSet() {
		fail("Not yet implemented"); // TODO
	}

	public final void testCopydata() {
		fail("Not yet implemented"); // TODO
	}

	public final void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetAllLegalMoves() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetAllLegalVertexes() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetColourIntInt() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetColourVertex() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetRuleSet() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetSize() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetZobrist() {
		fail("Not yet implemented"); // TODO
	}

	public final void testInit() {
		fail("Not yet implemented"); // TODO
	}

	public final void testIsOffBoard() {
		fail("Not yet implemented"); // TODO
	}

	public final void testIsWayOffBoard() {
		fail("Not yet implemented"); // TODO
	}

	public final void testNewBoardMove() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetColour() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetZobrist() {
		fail("Not yet implemented"); // TODO
	}

	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

}

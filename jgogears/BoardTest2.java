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
		Board board = new Board(Statics.MAX_BOARD_SIZE);
		for (short i = 0; i < Statics.MAX_BOARD_SIZE; i++)
			for (short j = 0; j < Statics.MAX_BOARD_SIZE; j++) {
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
				}
				{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_WHITE);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
				}
			}
	}

	public final void testBoardInt() {
		Board board = new Board((int)Statics.MAX_BOARD_SIZE);
		for (short i = 0; i < Statics.MAX_BOARD_SIZE; i++)
			for (short j = 0; j < Statics.MAX_BOARD_SIZE; j++) {
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
				}
				{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_WHITE);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
				}
			}
	}

	public final void testBoardIntRuleSet() {
		Board board = new Board((int)Statics.MAX_BOARD_SIZE,NoKoRuleSet.DEFAULT);
		for (short i = 0; i < Statics.MAX_BOARD_SIZE; i++)
			for (short j = 0; j < Statics.MAX_BOARD_SIZE; j++) {
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
				{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_WHITE);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
			}
	}

	public final void testBoardRuleSet() {
		Board board = new Board(NoKoRuleSet.DEFAULT);
		for (short i = 0; i < Statics.DEFAULT_BOARD_SIZE; i++)
			for (short j = 0; j < Statics.DEFAULT_BOARD_SIZE; j++) {
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
				{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_WHITE);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
			}
	}

	public final void testBoardShort() {
		Board board = new Board(Statics.MAX_BOARD_SIZE);
		for (short i = 0; i < Statics.MAX_BOARD_SIZE; i++)
			for (short j = 0; j < Statics.MAX_BOARD_SIZE; j++) {
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() == NoKoRuleSet.DEFAULT);
				}
				{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_WHITE);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
			}
	}

	public final void testBoardShortRuleSet() {
		Board board = new Board(Statics.MAX_BOARD_SIZE,NoKoRuleSet.DEFAULT);
		for (short i = 0; i < Statics.MAX_BOARD_SIZE; i++)
			for (short j = 0; j < Statics.MAX_BOARD_SIZE; j++) {
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_BLACK);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
				{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Board board2 = new Board(board, move);
					assertTrue(board2.getColour(i, j) == Statics.COLOUR_WHITE);
					assertFalse(board2.equals(board));
					assertNotNull(board2.getRuleSet());
					assertTrue(board2.getRuleSet() ==NoKoRuleSet.DEFAULT);
				}
			}
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

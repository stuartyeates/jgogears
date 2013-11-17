package jgogears;

import junit.framework.TestCase;

public class BoardTest2 extends TestCase {

	public final void testColourString() {
		for (short i = 0; i <= Statics.MAX_BOARD_SIZE; i++) 
			for (short j = 0; j <= Statics.MAX_BOARD_SIZE; j++) 
				for (short k = 0; k <= Statics.DEFAULT_BOARD_SIZE; k++) {
					{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Move move2 = new Move(move.toString());
					}
					{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Move move2 = new Move(move.toString());
					}
				}
				
				{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					String string = move.toString();
					Move move2 = new Move(string);
					assertNotNull(move2);
					assertTrue(move.toString().compareTo(move2.toString()) == 0);
					assertTrue(move.getRow() == move2.getRow());
					assertTrue(move.getColumn() == move2.getColumn());
					assertTrue(move.getColour() == move2.getColour());

				}
		

	}

	public final void testNewBoard() {
		fail("Not yet implemented"); // TODO
	}

	public final void testNewBoardBoolean() {
		fail("Not yet implemented"); // TODO
	}

	public final void testNewBoardInt() {
		fail("Not yet implemented"); // TODO
	}

	public final void testNewBoardIntRuleSet() {
		fail("Not yet implemented"); // TODO
	}

	public final void testParseColour() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoard() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoardBoardMove() {
		fail("Not yet implemented"); // TODO
	}

	public final void testBoardBoolean() {
		fail("Not yet implemented"); // TODO
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

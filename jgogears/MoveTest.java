package jgogears;

<<<<<<< HEAD
import jgogears.SGF.auto.ParseException;
=======
import jgogears.gtp.Statics;
import jgogears.sgf.auto.ParseException;
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class MoveTest.
 * @author syeates@gmail.com
 */
public class MoveTest extends TestCase {

	public final void testColourString() {
		for (short i = 0; i <= Statics.MAX_BOARD_SIZE; i++) 
			for (short j = 0; j <= Statics.MAX_BOARD_SIZE; j++) 
				for (short k = 0; k <= Statics.DEFAULT_BOARD_SIZE; k++) {
					{
					Move move = new Move(i, j, Statics.COLOUR_BLACK);
					Move move2 = new Move(move.toString());
					assertNotNull(move);
					assertNotNull(move2);
					assertTrue(move.toString() + "/" +move2.toString(), move.equals(move2));
					}
					{
					Move move = new Move(i, j, Statics.COLOUR_WHITE);
					Move move2 = new Move(move.toString());
					assertNotNull(move);
					assertNotNull(move2);
					assertTrue(move.equals(move2));
					}
				}
		

	}
	/**
	 * Test bad.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	public void testBad() throws ParseException {
		try {
			new Move("green b1");
			fail();
		} catch (Throwable t) {
		}
		try {
			new Move("white !3");
			fail();
		} catch (Throwable t) {
		}
		try {
			new Move("white");
			fail();
		} catch (Throwable t) {
		}
		try {
			new Move("b2");
			fail();
		} catch (Throwable t) {
		}
		try {
			new Move("");
			fail();
		} catch (Throwable t) {
		}
		try {
			new Move("ZERBA 56");
			fail();
		} catch (Throwable t) {
		}
		try {
			new Move("help");
			fail();
		} catch (Throwable t) {
		}
	}

	/**
	 * Test gtp constructor.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	public void testGTPConstructor() throws ParseException {
		assertTrue(new Move("w ReSiGn").getResign() == true);
		assertTrue(new Move("w resign").getColour() == Statics.VERTEX_WHITE);
		assertNotNull(new Move("w PASS"));
		assertNotNull(new Move("w pass"));
		assertTrue(new Move("w b2").getColumn() == 1);
		assertTrue(new Move("white b2").getRow() == 1);

		assertTrue(new Move("white t19").getRow() == 18);
		assertTrue(new Move("white t19").getColumn() == 18);
		assertTrue(new Move("white t19").getColour() == Statics.VERTEX_WHITE);
		assertTrue(new Move("white t19").getResign() == false);
		assertTrue(new Move("white t19").getPass() == false);

		assertTrue(new Move("black t19").getRow() == 18);
		assertTrue(new Move("black t19").getColumn() == 18);
		assertTrue(new Move("black t19").getColour() == Statics.VERTEX_BLACK);
		assertTrue(new Move("black t19").getResign() == false);
		assertTrue(new Move("black t19").getPass() == false);

		assertTrue(("" + new Move("black q10").getRow()),
				new Move("black q10").getRow() == 15);
		assertTrue(("" + new Move("black q10").getColumn()), new Move(
				"black q10").getColumn() == 9);
		assertTrue(new Move("black q10").getColour() == Statics.VERTEX_BLACK);
		assertTrue(new Move("black q10").getResign() == false);
		assertTrue(new Move("black q10").getPass() == false);

		assertTrue(new Move("white pass").getResign() == false);
		assertTrue(new Move("white pass").getPass() == true);

		assertTrue(new Move("white resign").getResign() == true);
		assertTrue(new Move("white resign").getPass() == false);
	}

	/*
	 * Test method
	 */
	/**
	 * Test string conversions.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	public void testStringConversions() throws ParseException {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				Move move = new Move(i, j, Statics.VERTEX_WHITE);
				assertNotNull(move);
				assertTrue("" + i + " " + j, move.getRow() == i);
				assertTrue("" + i + " " + j, move.getColumn() == j);
				assertTrue(move.getColour() == Statics.VERTEX_WHITE);
				Move move2 = new Move(move.toString());
				assertNotNull(move2);
				assertTrue("" + i + " " + j + " " + move + " " + move2,
						move2.getRow() == i);
				assertTrue("" + i + " " + j + " " + move + " " + move2,
						move2.getColumn() == j);
				assertTrue(move2.getColour() == Statics.VERTEX_WHITE);
			}
		}
	}

	/*
	 * Test method
	 */
	/**
	 * Test to string.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	public void testToString() throws ParseException {
		System.err.println(new Move(0, 0, Statics.VERTEX_WHITE));
		assertTrue(new Move(0, 0, Statics.VERTEX_WHITE).toString().compareTo(
				"white a1") == 0);
		assertTrue(new Move(18, 18, Statics.VERTEX_WHITE).toString().compareTo(
				"white t19") == 0);
	}

}

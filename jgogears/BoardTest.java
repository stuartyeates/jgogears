package jgogears;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

import junit.framework.TestCase;

/**
 * The Class BoardTest.
 * 
 * @author syeates@gmail.com
 */
public class BoardTest extends TestCase {
	/** are we being verbose ? */
	static final private boolean DEBUG = false;

	/**
	 * Test all sizes.
	 */
	public void testAllSizes() {
		this.testAllVertexesN((short)3);
		this.testAllVertexesN((short)6);
		this.testAllVertexesN((short)7);
		this.testAllVertexesN((short)8);
		this.testAllVertexesN((short)9);
		this.testAllVertexesN((short)10);
		this.testAllVertexesN((short)11);
		this.testAllVertexesN((short)12);
		this.testAllVertexesN((short)13);
		this.testAllVertexesN((short)14);
		this.testAllVertexesN((short)15);
		this.testAllVertexesN((short)16);
		this.testAllVertexesN((short)17);
		this.testAllVertexesN((short)18);
		this.testAllVertexesN((short)19);
		this.testAllVertexesN((short)20);
		this.testAllVertexesN((short)21);
		this.testAllVertexesN((short)22);
	}

	/**
	 * Test all vertexes n.
	 * 
	 * @param size
	 *            the size
	 */
	public void testAllVertexesN(short size) {
		Board board = new Board(size);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Move move = new Move(i, j, Statics.VERTEX_BLACK);
				board = board.newBoard(move);
				assertTrue(board.getColour(i, j) == Statics.VERTEX_BLACK);

				for (int l = 0; l < size; l++) {
					for (int m = 0; m < size; m++) {
						if (l != i && m != j)
							assertTrue(board.getColour(l, m) == Statics.VERTEX_EMPTY);
					}
				}
				move = new Move(i, j, Statics.VERTEX_EMPTY);
				board = board.newBoard(move);
				assertTrue(board.getColour(i, j) == Statics.VERTEX_EMPTY);

				for (int l = 0; l < size; l++) {
					for (int m = 0; m < size; m++) {
						if (l != i && m != j)
							assertTrue(board.getColour(i, j) == Statics.VERTEX_EMPTY);
					}
				}
				move = new Move(i, j, Statics.VERTEX_WHITE);
				board = board.newBoard(move);
				assertTrue(board.getColour(i, j) == Statics.VERTEX_WHITE);

				for (int l = 0; l < size; l++) {
					for (int m = 0; m < size; m++) {
						if (l != i && m != j)
							assertTrue(board.getColour(l, m) == Statics.VERTEX_EMPTY);
					}
				}
				move = new Move(i, j, Statics.VERTEX_KO);
				board = board.newBoard(move);
				assertTrue(board.getColour(i, j) == Statics.VERTEX_KO);

				for (int l = 0; l < size; l++) {
					for (int m = 0; m < size; m++) {
						if (l != i && m != j)
							assertTrue(board.getColour(l, m) == Statics.VERTEX_EMPTY);
					}
				}
				move = new Move(i, j, Statics.VERTEX_EMPTY);
				board = board.newBoard(move);
				assertTrue(board.getColour(i, j) == Statics.VERTEX_EMPTY);

				for (int l = 0; l < size; l++) {
					for (int m = 0; m < size; m++) {
						if (l != i && m != j)
							assertTrue(board.getColour(l, m) == Statics.VERTEX_EMPTY);
					}
				}
			}
		}
	}

	/**
	 * Test colours.
	 */
	public void testColours() {
//		assertTrue(Statics.VERTEX_BLACK == Statics.VERTEX_BLACK);
		assertTrue(Statics.VERTEX_BLACK != Statics.VERTEX_WHITE);
		assertTrue(Statics.VERTEX_BLACK != Statics.VERTEX_EMPTY);
		assertTrue(Statics.VERTEX_BLACK != Statics.VERTEX_KO);
		assertTrue(Statics.VERTEX_BLACK != Statics.VERTEX_OFF_BOARD);

		assertTrue(Statics.VERTEX_WHITE != Statics.VERTEX_BLACK);
//		assertTrue(Statics.VERTEX_WHITE == Statics.VERTEX_WHITE);
		assertTrue(Statics.VERTEX_WHITE != Statics.VERTEX_EMPTY);
		assertTrue(Statics.VERTEX_WHITE != Statics.VERTEX_KO);
		assertTrue(Statics.VERTEX_WHITE != Statics.VERTEX_OFF_BOARD);

		assertTrue(Statics.VERTEX_EMPTY != Statics.VERTEX_BLACK);
		assertTrue(Statics.VERTEX_EMPTY != Statics.VERTEX_WHITE);
//		assertTrue(Statics.VERTEX_EMPTY == Statics.VERTEX_EMPTY);
		assertTrue(Statics.VERTEX_EMPTY != Statics.VERTEX_OFF_BOARD);

		assertTrue(Statics.VERTEX_KO != Statics.VERTEX_BLACK);
		assertTrue(Statics.VERTEX_KO != Statics.VERTEX_WHITE);
		assertTrue(Statics.VERTEX_KO != Statics.VERTEX_EMPTY);
//		assertTrue(Statics.VERTEX_KO == Statics.VERTEX_KO);
		assertTrue(Statics.VERTEX_KO != Statics.VERTEX_OFF_BOARD);

		assertTrue(Statics.VERTEX_OFF_BOARD != Statics.VERTEX_BLACK);
		assertTrue(Statics.VERTEX_OFF_BOARD != Statics.VERTEX_WHITE);
		assertTrue(Statics.VERTEX_OFF_BOARD != Statics.VERTEX_EMPTY);
		assertTrue(Statics.VERTEX_OFF_BOARD != Statics.VERTEX_KO);
//		assertTrue(Statics.VERTEX_OFF_BOARD == Statics.VERTEX_OFF_BOARD);

	}

	/**
	 * 
	 */
	public void testEachUndoableI() {
		for (int i = 0; i < Zobrist.MAX_BOARD_SIZE; i++)
			for (int j = 0; j < Zobrist.MAX_BOARD_SIZE; j++)
				for (int k = 0; k < Zobrist.MAX_COLOUR; k++) {

					Board board1 = new Board();
					Board board2 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					Board board3 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					// Board board4 = board2.newBoard(new Move((short) 1,
					// (short) 1, Statics.VERTEX_BLACK));

					assertTrue(board1.equals(board1));
					assertTrue(board2.equals(board2));
					assertTrue(board3.equals(board3));
					// assertTrue(board4.equals(board4));

					assertFalse(board1.equals(board2));
					assertFalse(board2.equals(board1));
					assertFalse(board1.equals(board3));
					assertFalse(board3.equals(board1));
					// assertTrue(board4.equals(board1));
					// assertTrue(board1.equals(board4));
					assertTrue(board2.equals(board3));
					assertTrue(board3.equals(board2));

				}
	}

	/**
	 * 
	 */
	public void testEachUndoableII() {
		for (int i = 0; i < Zobrist.MAX_BOARD_SIZE; i++)
			for (int j = 0; j < Zobrist.MAX_BOARD_SIZE; j++)
				for (int k = 0; k < Zobrist.MAX_COLOUR; k++) {

					Board board1 = new Board();
					Board board2 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					Board board3 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					// Board board4 = board2.newBoard(new Move((short) 1,
					// (short) 1, Statics.VERTEX_BLACK));

					assertTrue(board1.equals(board1));
					assertTrue(board2.equals(board2));
					assertTrue(board3.equals(board3));
					// assertTrue(board4.equals(board4));

					assertFalse(board1.equals(board2));
					assertFalse(board2.equals(board1));
					assertFalse(board1.equals(board3));
					assertFalse(board3.equals(board1));
					// assertTrue(board4.equals(board1));
					// assertTrue(board1.equals(board4));
					assertTrue(board2.equals(board3));
					assertTrue(board3.equals(board2));

				}
	}

	/**
	 * 
	 */
	public void testEachUndoableIII() {
		for (int i = 0; i < Zobrist.MAX_BOARD_SIZE; i++)
			for (int j = 0; j < Zobrist.MAX_BOARD_SIZE; j++)
				for (int k = 0; k < Zobrist.MAX_COLOUR; k++) {

					Board board1 = new Board();
					Board board2 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					Board board3 = board1.newBoard(new Move((short) 1,
							(short) 1, Statics.VERTEX_BLACK));
					// Board board4 = board2.newBoard(new Move((short) 1,
					// (short) 1, Statics.VERTEX_BLACK));

					assertTrue(board1.equals(board1));
					assertTrue(board2.equals(board2));
					assertTrue(board3.equals(board3));
					// assertTrue(board4.equals(board4));

					assertFalse(board1.equals(board2));
					assertFalse(board2.equals(board1));
					assertFalse(board1.equals(board3));
					assertFalse(board3.equals(board1));
					assertTrue(board2.equals(board3));
					assertTrue(board3.equals(board2));

				}
	}

	/**
	 * Loads a ton of SGF files and tests the resulting boards
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void testLoadAllSGFfiles() throws IOException {
		Stack<String> files = new Stack<String>();
		files.push("sgf/2004-12");

		while (files.size() > 0) {
			String filename = files.pop();
			File file = new File(filename);
			if (DEBUG)
				System.err.println("examining \"" + filename + "\"");
			if (file.exists()) {
				if (!file.isDirectory()) {
					// System.err.println("\"" + filename + "\" is not a
					// directory, parsing as an SGF file");

					Game game = Game.loadFromFile(file);
					if (game.getSize() == 19) {
						Iterator<Move> i = game.getMoves();
						Move move = null;
						Board board = new Board(game.getSize());
						// System.err.println("board size is: \"" +
						// goGame.getSize()
						// + "\"");
						while (i.hasNext()) {
							move = i.next();
							assertNotNull(move);
							// System.err.print("move: \"" + move + "\"");
							// assertTrue("" + board + "\n" +
							// move.toString(),board.isLegalMove(move));
							board = board.newBoard(move);
							// System.err.println(" board size is: \"" +
							// board.getSize() + "\"");
						}
						// System.err.println();
					}
				} else {
					if (DEBUG)
						System.err.println("\"" + filename
								+ "\" is a directory");
					String[] children = file.list();
					if (!file.getName().contains(".svn"))
						for (int i = 0; i < children.length; i++) {
							// System.err.println("pushing \"" + children[i] +
							// "\"");
							files.push(filename + "/" + children[i]);
						}
				}
			}
		}

	}

	/**
	 * Test load simple gnugo.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void testLoadSimpleGnugo() throws IOException {

		Game game = Game.loadFromFile(new File("sgf/testing/simpleGnuGo.sgf"));
		Iterator<Move> i = game.getMoves();
		Move move = null;
		Board board = new Board(game.getSize());
		while (i.hasNext()) {
			move = i.next();
			assertNotNull(move);
			board = board.newBoard(move);
		}
		// System.err.println(g);
	}

	/**
	 * Test to string.
	 */
	public void testToString() {
		Board working = new Board((short) 19);
		assertNotNull(working);
		working = working.newBoard(new Move("B q10"));
		// System.out.println(working);
	}

}

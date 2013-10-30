package jgogears2;

import java.util.List;

/**
 * A Board represents a particular state of the board at a particular point in
 * time.
 * 
 * It doesn't store complete game state, since some Ko rules traverse all
 * previous board states.
 * 
 * @author syeates@gmail.com
 * 
 */

public class Board {

	private short[][] board;
	private short size = 19;

	public Board() {
		init();
	}

	public Board(short size) {
		this.size = size;
		init();
	}

	public Board(int size) {
		this.size = (short) size;
		init();
	}

	public Board(Board board) {
		throw new Error();
		// this.size = (short) size;
		// init();
	}

	protected void init() {
		board = new short[size][size];
	}

	/**
	 * What colour is this vertex?
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public short getColour(short row, short column) {
		return board[row][column];
	}

	/**
	 * Return a new Board based on the current board and the given move
	 * 
	 * @param move
	 * @return
	 */
	public Board playMove(Move move);

	/**
	 * Is the given move legal?
	 * 
	 * @param move
	 * @return
	 */
	public boolean isLegal(Move move);

	/**
	 * What are all the legal moves?
	 * 
	 * @return
	 */
	public List<Move> getLegalMoves();

	/**
	 * Is black to play next?
	 * 
	 * @return
	 */
	public boolean blackToPlay();

	/**
	 * What game is this board a part of?
	 * 
	 * @return
	 */
	public Game getGame();

	public short getSize();
}

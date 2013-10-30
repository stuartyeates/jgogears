package jgogears2;

import java.util.Stack;
import java.util.Collection;


final public class Liberty {

	/**
	 * Captures.
	 * 
	 * @param game
	 *            the game
	 * @param move
	 *            the move
	 * @param board
	 *            the board
	 * @return the tree set< vertex>
	 */
	public Collection<Vertex> captures(Game game, Board board, Move move){
		
	}

	/**
	 * Count liberties.
	 * 
	 * @param rowb
	 *            the rowb
	 * @param columnb
	 *            the columnb
	 * @param board
	 *            the board
	 * @return the short
	 */
	public short countLiberties(int rowb, int columnb, Board board) {
		return this.countLiberties((short) rowb, (short) columnb, board);
	}

	/**
	 * Count liberties.
	 * 
	 * @param rowb
	 *            the rowb
	 * @param columnb
	 *            the columnb
	 * @param board
	 *            the board
	 * @return the short
	 */
	public short countLiberties(short rowb, short columnb, Board board) {
		return (short) this.getLiberties(rowb, columnb, board).size();
	}


	/**
	 * Get all the legal moves
	 * 
	 * @param game
	 *            the game being played
	 * @param board
	 *            the current state of the baord
	 * @param colour
	 *            the colour being played
	 * @return the collection of vertexes
	 */
	static public Collection<Vertex> getAllLegalVertexes(Game game, Board board,
			short colour) {
		Stack<Vertex> moves = new Stack<Vertex>();
		for (int i = 0; i < board.getSize(); i++)
			for (int j = 0; j < board.getSize(); j++)
				if (board.isLegal( new Move(i, j, colour)))
					moves.push(new Vertex(i, j));
		return moves;
	}

	/**
	 * Gets the liberties.
	 * 
	 * @param rowb
	 *            the rowb
	 * @param columnb
	 *            the columnb
	 * @param board
	 *            the board
	 * @return the liberties
	 */
	public Collection<Vertex> getLiberties(int rowb, int columnb, Board board) {
		return this.getLiberties((short) rowb, (short) columnb, board);
	}

	/**
	 * Gets the liberties.
	 * 
	 * @param rowb
	 *            the rowb
	 * @param columnb
	 *            the columnb
	 * @param board
	 *            the board
	 * @return the liberties
	 */
	public Collection<Vertex> getLiberties(short rowb, short columnb,
			Board board){
	}

}

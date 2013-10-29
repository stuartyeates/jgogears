package jgogears2;

import java.util.List;

public interface Board {
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
		public short getColour(short row, short column);
		/**
		 * 
		 * @param move
		 * @return
		 */
		public Board playMove(Move move);
		/**
		 * 
		 * @param move
		 * @return
		 */
		public boolean isLegal(Move move);
		/**
		 * 
		 * @return
		 */
		public List<Move> getLegalMoves();
		/**
		 * 
		 * @return
		 */
		public boolean blackToPlay();
		/**
		 * 
		 * @return
		 */
		public Game getGame();
}

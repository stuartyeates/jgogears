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
		
		public Board playMove(Move move);
		
		public boolean isLegal(Move move);
		
		public List<Move> getLegalMoves();
		

}

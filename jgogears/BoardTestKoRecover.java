package jgogears;

import junit.framework.TestCase;

public class BoardTestKoRecover extends TestCase {
	
	public void testFloating(){
		Board board = new Board();
		board = board.newBoard(new Move("b b3"));
		assertNotNull(board);
		board = board.newBoard(new Move("b b4"));
		assertNotNull(board);
		board = board.newBoard(new Move("b a5"));
		assertNotNull(board);
		board = board.newBoard(new Move("b c5"));
		assertNotNull(board);
		board = board.newBoard(new Move("w b5"));
		assertNotNull(board);
		board = board.newBoard(new Move("b b6"));
		assertNotNull(board);
		short colour = board.getColour(5, 2);
		assertTrue(colour == Board.VERTEX_EMPTY);
		//assertNotNull();

		System.err.println(board);

		
//		BoardI board2 = board1.newBoard(new Move((short) 1,
//				(short) 1, BoardI.VERTEX_BLACK));
//		BoardI board3 = board1.newBoard(new Move((short) 1,
//				(short) 1, BoardI.VERTEX_BLACK));

	}

}

package jgogears;

import jgogears.gtp.Statics;
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
		board = board.newBoard(new Move("w a6"));
		assertNotNull(board);
		board = board.newBoard(new Move("w c6"));
		assertNotNull(board);
		board = board.newBoard(new Move("w b7"));
		assertNotNull(board);
		
		//
		board = board.newBoard(new Move("b b6"));
		assertNotNull(board);
		
		short colour = board.getColour(5, 2);
		assertTrue(Statics.VERTEX_KO == colour);

		System.err.println(board);

		//assertNotNull();


		
//		BoardI board2 = board1.newBoard(new Move((short) 1,
//				(short) 1, BoardI.VERTEX_BLACK));
//		BoardI board3 = board1.newBoard(new Move((short) 1,
//				(short) 1, BoardI.VERTEX_BLACK));

	}

}

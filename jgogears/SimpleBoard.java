/**
 * 
 */
package jgogears;

/**
 * @author stuartyeates
 *
 */
public interface SimpleBoard {
	
	public short getColour(short row, short column);
	
	public void isLegalMove(short row, short column, short colour);
	
	public SimpleBoard move(short row, short column, short colour);

}

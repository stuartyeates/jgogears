/**
 * 
 */
package jgogears;

/**
 * @author syeates@gmail.com
 *
 */
public interface SimpleBoard {
	
	public short getColour(short row, short column);
	
	public void isLegalMove(short row, short column, short colour);
	
	public SimpleBoard move(short row, short column, short colour);

}

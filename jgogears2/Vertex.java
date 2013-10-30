package jgogears2;
/**
 * 
 * @author syeates@gmail.com
 *
 */
public class Vertex {
	public short row;
	public short column;
	public Vertex(short row, short column){
			this.row=row;
			this.column=column;
	}
	/**
	 * 
	 * @param row
	 * @param column
	 */
	public Vertex(int row, int column){
		this.row=(short)row;
		this.column=(short)column;
	
	}
	/**
	 * 
	 * @return
	 */
	public short getRow() {
		return row;
	}
	/**
	 * 
	 * @param row
	 */
	public void setRow(short row) {
		this.row = row;
	}
	/**
	 * 
	 * @return
	 */
	public short getColumn() {
		return column;
	}
	/**
	 * 
	 * @param column
	 */
	public void setColumn(short column) {
		this.column = column;
	}
}

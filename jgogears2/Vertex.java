package jgogears2;
/**
 * 
 * @author syeates@gmail.com
 *
 */
public class Vertex {
	/**
	 * 
	 */
	public short row;
	/**
	 * 
	 */
	public short column;
	/**
	 * 
	 * @param row
	 * @param column
	 */
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
	 * @param vertex
	 */
	public Vertex(Vertex vertex){
		this.row=vertex.row;
		this.column=vertex.column;
	
	}
	/**
	 * 
	 * @return
	 */
	public short getRow() {
		return this.row;
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
		return this.column;
	}
	/**
	 * 
	 * @param column
	 */
	public void setColumn(short column) {
		this.column = column;
	}
	public String toString(){
		return "(" + row + "," + column + ")";
		
	}
}

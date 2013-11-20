package jgogears2;
/**
 * 
 * @author syeates@gmail.com
 *
 */
public class Move {
	protected short row;
	protected short column;
	protected short colour;
	public Move(String s){
		
	}
	public Move(Vertex vertex,short colour){
		this.row=vertex.row;
		this.column= vertex.column;
		this.colour= colour;
				
	}
	public Move(short row, short column,short colour){
		
	}
	public Move(int row, int column,short colour){
		
	}
	/**
	 * 
	 * @return
	 */
	public String toString(){
		//TODO
		throw new Error();
	}
	
	
}

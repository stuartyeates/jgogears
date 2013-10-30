package jgogears2;

public class Vertex {
	public short row;
	public short column;
	public Vertex(short row, short column){
			this.row=row;
			this.column=column;
	}
	public Vertex(int row, int column){
		this.row=(short)row;
		this.column=(short)column;
	
	}

}

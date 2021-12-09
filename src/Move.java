
public class Move {
	private int movenum;
	private int moverow;
	private int movecolumn;
	
	public Move(int num, int row, int column) {
		this.movenum = num;
		this.moverow = row;
		this.movecolumn = column;
	}

	public int getMovenum() {
		return this.movenum;
	}
	public int getMoverow() {
		return this.moverow;
	}

	public int getMovecolumn() {
		return this.movecolumn;
	}
}

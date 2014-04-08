

public class MineField{
	
	private int rows;
	private int columns;
	private final char MINE = '*';
	private final char NOT_MINE = '.';
	private char[][] mineField;
	
	public MineField() {
		this.rows = 100;
		this.columns = 100;
		this.mineField = layMines();
	}
	
	public MineField(int rows, int cols) {
		this.rows = rows;
		this.columns = cols;
		this.mineField = new char[this.rows][this.columns];
		//this.mineField = layMines();
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public char[][] getField() {
		return mineField;
	}

	public char getMINE() {
		return MINE;
	}

	public char getNOT_MINE() {
		return NOT_MINE;
	}
	
	public void layMines(int row, char[] fieldRow) {
		if (row >= this.rows) {
			throw new IllegalArgumentException("row out of bounds");
		}
		for(int i = 0; i < fieldRow.length; i++) {
			this.mineField[row][i] = fieldRow[i];
		}
	}//layMines(int row, char[] fieldRow)

	private char[][] layMines() {
		char[][] theField = new char[this.rows][this.columns];
		for(int n = 0; n < this.rows; n++) {
			for(int m = 0; m < this.columns; m++) {
				theField[n][m] = plantMine();
			}
		}
		return theField;
	}//layMines()
	
	private char plantMine() {
		double randomNum = java.lang.Math.random();
		if (randomNum <= 0.05)
			return MINE;
		return NOT_MINE;
	}//plantMine()
	
	public String toString() {
		String str = "";
		for(char[] row : this.mineField) {
			for (char col : row) {
					str += "" + col;
			}
			str += "\n";
		}
		return str;
	}//toString()

}//MineField.class

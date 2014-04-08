
public class SweptField {

	private Object[][] sweptField;
	
	SweptField() {}

	SweptField(MineField aField) {
		detectMines(aField);
	}
	
	public Object[][] getSweptField() {
		return sweptField;
	}

	private void detectMines(MineField aField) {
		int rows = aField.getRows();
		int cols = aField.getColumns();
		char MINE = aField.getMINE();
		char[][] theField = aField.getField();
		sweptField = new Object[rows][cols];
		int mineCount;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineCount = 0;
				if (theField[i][j] != MINE) {
					if (i - 1 >= 0 && theField[i-1][j] == MINE) //up
						mineCount++;
					if (i + 1 < rows && theField[i+1][j] == MINE) //down
						mineCount++;
					if (j - 1 >= 0 && theField[i][j-1] == MINE) //left
						mineCount++;
					if (j + 1 < cols && theField[i][j+1] == MINE) //right
						mineCount++;
					if (j + 1 < cols && i + 1 < rows && theField[i+1][j+1] == MINE) //lower right
						mineCount++;
					if (j + 1 < cols && i - 1 >= 0 && theField[i-1][j+1] == MINE) //upper right
						mineCount++;
					if (j - 1 >= 0 && i + 1 < rows && theField[i+1][j-1] == MINE) //lower left
						mineCount++;
					if (j - 1 >= 0 && i - 1 >= 0 && theField[i-1][j-1] == MINE) //upper left
						mineCount++;
					sweptField[i][j] = mineCount;
				} else {
					sweptField[i][j] = MINE;
				}
			}
		}
	}//detectMines()
	
	public String toString() {
		String str = "";
		for(Object[] row : this.sweptField) {
			for (Object o : row) {
					str += "" + o;
			}
			str += "\n";
		}
		return str;
	}
	
}//SweptField.class

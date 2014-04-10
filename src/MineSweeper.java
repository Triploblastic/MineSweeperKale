/*Richard Kale Sipes
*CSCD350
*Lab1 MineSweeper
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MineSweeper {

	public static void main(String[] args) {
		ArrayList<MineField> fields = retrieveFields();
		printSweptFields(fields);
	}
	
	private static ArrayList<MineField> retrieveFields() {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in/*new File("TestCases.txt")*/);
		} catch (Exception ex) {
			System.out.print(ex);
		}
		ArrayList<MineField> fields = new ArrayList<MineField>();
		while(sc.hasNext()) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			if (rows == 0 || cols == 0) {
					break;
			}
				sc.nextLine();
				int rowNum = 0;
				MineField field = new MineField(rows, cols);	
				while (rowNum < rows) {			
					char[] fieldRow = sc.nextLine().toCharArray();
					field.layMines(rowNum, fieldRow);
					rowNum++;
				}
				fields.add(field);
						
		}
		return fields;
	}//retrieveFields()
	
	private static void printSweptFields(ArrayList<MineField> fields) {
		int fieldNum = 1;
		for (MineField field: fields) {
			char[][] sweptField = field.detectMines();
			System.out.println("Field #" + fieldNum + ":");
			for(char[] row : sweptField) {
				for (char c : row) {
					System.out.print(c);
				}
				System.out.println();
			}
			fieldNum++;
		}
	}//printSweptFields()

}

import java.util.Scanner;
import java.util.ArrayList;

public class MineSweeper {

	public static void main(String[] args) {
		ArrayList fields = retrieveFields();
		printSweptFields(fields);
	}

	private static ArrayList retrieveFields() {
		int[] dimensions = getFieldDimensions();
		ArrayList fields = new ArrayList();
		while (dimensions[0] != 0){
			MineField field = new MineField(dimensions[0], dimensions[1]);
			fillField(field);
			fields.add(field);
			dimensions = getFieldDimensions();
		}
		return fields;
	}//retrieveFields()

	private static int[]  getFieldDimensions() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number of rows & columns separated by a space: ");
		int[] dimensions = new int[2];
		dimensions[0] = sc.nextInt();
		dimensions[1] = sc.nextInt();
		return dimensions;
	}//getFieldDimensions()

	private static void fillField(MineField field) {
		int rows = field.getRows();
		int index = 0;
		Scanner sc = new Scanner(System.in);
		while (rows > 0) {
			System.out.print("Enter the mine field below: " + index + ": ");
			String fieldRow = sc.nextLine();
			field.layMines(index, fieldRow.toCharArray());
			rows--;
			index++;
		}
	}//fillField()
	
	private static void printSweptFields(ArrayList fields) {
		int count = 1;
		for (Object field : fields) {
			MineField theField = (MineField)field;
			//System.out.println(theField.toString());
			SweptField sweptField = new SweptField(theField);
			System.out.print("Field #" + count + ":\n" + sweptField.toString());
			count++;
		}
	}//printSweptFields()
}

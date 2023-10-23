import java.util.Random;
import java.util.Scanner;

public class inputHandler {
	
	private final Scanner scanner;
	
	private final String row = "row";  // 'row' string for the print method in the 'userInput()' method
	private final String column = "column";  // 'column' string for the print method in the 'userInput()' method
	
	private int enemyRow; // declaring the enemy row variable
	private int enemyColumn; // declaring the enemy column variable
	
	public inputHandler(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public int getEnemyRow() {
		return enemyRow;
	}

	public int getEnemyColumn() {
		return enemyColumn;
	}

	public int inputRowIsDigit() {  // input method to the row value
		return userInput(row);	
	}
	
	public int inputColumnIsDigit() {  // input method to the column value
		return userInput(column);		
	}
	
	private int userInput(String axis) { // player input process
		
		boolean correctUserInput;
		String userInput;
		
		do {
			System.out.println("Select "+ axis +":" );
			userInput = scanner.nextLine();
			correctUserInput = true;
			if (!userInput.matches("^[0-4]{1}")) {
				System.out.println("Invalid input!");
				correctUserInput = false;
			}
		} while (!correctUserInput);
		
		int userNumber = Integer.parseInt(userInput);
		return userNumber;
	}
	
	public void enemyInput() {  // select row and column process by the enemy
		enemyRow = new Random().nextInt(5);
		System.out.println("Choosed enemy row: " + enemyRow);
		enemyColumn = new Random().nextInt(5);
		System.out.println("Choosed enemy column: " + enemyColumn);
	}
}

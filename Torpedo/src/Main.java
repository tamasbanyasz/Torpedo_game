
import java.util.Scanner;

/*--------------- Simple Torpedo ---------------------
 * 
 * It's just a simple torpedo game.
 * 
 * One map for the player and one for the enemy. The map size is 5*5.
 * The code creates ship for the players and these ships length are 3 index.
 * And the code places one ship with vertical or horizontal on the players map.
 * 
 * So we have one variable for the line: If the ship is horizontal the line equals the number of rows.
 * 										 IF the ship is vertical the number line equals the number of columns. 
 * 
 * The ships indexes will store in an ArrayList. For example line: '3' , indexes: [0, 1, 2] or line: '3', indexes :[1, 2, 3] 
 * If the player or the enemy hit one of them indexes it will remove from the list. For example [0, 2] or [1, 2] 
 * 
 * If removed all of indexes from one of them lists the game will be ended.
 * 
 * 		 X  -  -  -  -   ship is horizontal
 		 -  -  -  -  X 
 		 -  -  -  -  - 
 		 -  -  @  @  @ 
 		 -  -  X  -  - 

	   ------------------

 		 -  -  -  -  -   ship is vertical
 		 X  -  -  @  - 
 		 -  -  X  @  - 
 		 -  -  -  @  - 
 		 X  -  -  X  - 
 		 
 */

public class Main {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			new Main().run(scanner);
		}		
	}
	
	private void run(Scanner scanner) {

		Map mapPlayer = new Map("Player");  // call map of player
		Ship shipPlayer = new Ship("Player");  // call ship of player
		
		Map mapEnemy = new Map("Enemy");  // call map of enemy
		Ship shipEnemy = new Ship("Enemy");  // call map of enemy
		
		inputHandler input = new inputHandler(scanner);  // call the input handler class
		
		shipPlayer.determineShipCoordinates();  // determine the player ships coordinates
		shipEnemy.determineShipCoordinates();	// determine the enemy ships coordinates
		
		int playerTurn = 0;  // switch the turn between the player and the enemy
		
		do {
			System.out.println(shipPlayer.getShipHealth());
			System.out.println(shipEnemy.getShipHealth());
			System.out.println();
			System.out.println(mapPlayer.toString());
			mapPlayer.printMap();
			
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			
			System.out.println(mapEnemy.toString());
			mapEnemy.printMap();
			
			System.out.println();
			System.out.println(shipPlayer.line);
			System.out.println(shipPlayer.shipHorizontalStanding);
			
			System.out.println();
			System.out.println(shipEnemy.line);
			System.out.println(shipEnemy.shipHorizontalStanding);
			shipPlayer.printCoors();
			shipEnemy.printCoors();
			
			if (playerTurn==0) {  // if the turn is on the player
				boolean playerHit;										// if the hit succeed
				do {
					playerHit = mapEnemy.inputHitMethod(shipEnemy.getListshipCoordinates(),  
											  input.inputRowIsDigit(), 
											  input.inputColumnIsDigit(), 
											  shipEnemy.line,  
											  shipEnemy.shipHorizontalStanding);
				}while(playerHit == false);
			}
			
			if (playerTurn==1) {  // if the turn is on the enemy
				boolean enemyHit;
				do {
					input.enemyInput(); // enemy input method
					enemyHit = mapPlayer.inputHitMethod(shipPlayer.getListshipCoordinates(), 
											   input.getEnemyRow(), 
											   input.getEnemyColumn(), 
											   shipPlayer.line, 
											   shipPlayer.shipHorizontalStanding);
				}while(enemyHit == false);
				playerTurn -= 2;
			}
			
			playerTurn += 1;  // switch player or enemy turn with counting 

		} while ((shipEnemy.getShipHealth() != 0) && (shipPlayer.getShipHealth() != 0));  // end the loop if the coordinates list is empty
		
		mapPlayer.printMap();					 // Show the game result
		System.out.println();
		System.out.println("------------------");  
		System.out.println();
		mapEnemy.printMap();
		endGame(shipPlayer, shipEnemy);  
	}
	
	private void endGame(Ship player, Ship enemy) {
		if (player.getShipHealth() == 0) {
			
			System.out.println(player.toString() + " has lost the game.");
			System.out.println(enemy.toString() + " has WON the game.");
		}
		if (enemy.getShipHealth() == 0) {
			System.out.println(enemy.toString() + " has lost the game.");
			System.out.println(player.toString() + " has WON the game.");
		}
	}
}

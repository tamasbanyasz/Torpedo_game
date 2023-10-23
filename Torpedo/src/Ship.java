import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
	
	private String shipName; // ship name

	final List<Integer> listshipCoordinates = new ArrayList<>();  // here we store the ship indexes
	
	final boolean shipHorizontalStanding = chooseStand();  // ship standing on the map is horizontal or vertical
	final int line = new Random().nextInt(5);  // index of column or the row. It depends if the ship is horizontal or vertical
	
	
	public Ship(String name) {
		this.shipName = name;
	}

	public List<Integer> getListshipCoordinates() {
		return listshipCoordinates;
	}
	
	public boolean chooseStand() {  // If the ship will be horizontal or vertical it depends by the random boolean method
		return new Random().nextBoolean();
	}
	
	public boolean isShipHorizontalStanding() {
		return shipHorizontalStanding;
	}
	
	public int getShipHealth() {
		return listshipCoordinates.size(); // size of the list determine for the health of ship
	}

	public void determineShipCoordinates() {  // create the coordinates of ship
			
		int start = new Random().nextInt(3);  // starting index...
		
		for (int i = start; i < start + 3; i++) { // ... further indexes
			listshipCoordinates.add(i);	
		}
	}
	
	public void printCoors() {
		System.out.println(listshipCoordinates);
	}

	@Override
	public String toString() {
		return "Ship " + shipName;
	}
}

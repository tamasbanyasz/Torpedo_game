import java.util.List;

public class Map {
	
	private String playerMap;  // Map name
	
	final String[][] matrix = {{" -"," -"," -"," -"," -"}, {" -", " -"," -"," -"," -"}, {" -"," -"," -"," -"," -"}, {" -"," -"," -"," -"," -"}, {" -"," -"," -"," -"," -"}};
	// Game map marks in nested list
	
	public Map(String playerMap) {
		this.playerMap = playerMap;
	}

	public boolean inputHitMethod(List<Integer> list, int row, int column, int line, boolean isShipIsHorizontal) { // refresh the map with hit marks
		
			if (matrix[row][column] != " -" || matrix[row][column] != " -") {  // If you hit the same place
				System.out.println("You have already hit this place ...");
				return false;
					}
			if (row != line || !list.contains(column)) { // if you miss the hit
				matrix[row][column] = " X";
					
					}
			if ((row == line & list.contains(column) & isShipIsHorizontal) || (list.contains(row) & column == line) &!isShipIsHorizontal) {  // if you hit the ship
				matrix[row][column] = " @";	
				if(isShipIsHorizontal == true) {
					list.remove(Integer.valueOf(column)); // remove the index from the list if the ship is horizontal
				}
				if(isShipIsHorizontal == false) {
					list.remove(Integer.valueOf(row));  // remove the index from the list if the ship is vertical
				}
			}
			
		return true; 
	}
    
	public void printMap() {
		
		for (int i = 0; i < matrix.length; i++) {
		 for (int j = 0; j < matrix[i].length; j++) {
		    System.out.print(matrix[i][j] + " ");
		 }
	    System.out.println();
	   }
	}

	@Override
	public String toString() {
		return "" + playerMap + " battle map: ";
	}
}

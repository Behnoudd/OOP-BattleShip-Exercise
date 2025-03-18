import java.util.Random;

class ShipPlacer {
    public static void placeShips(Board grid) {
        int[] shipSizes = {5, 4, 3, 3, 2};
        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int row = Utils.generateRandomNumber(0, 9);
                int col = Utils.generateRandomNumber(0, 9);
                boolean horizontal = new Random().nextBoolean();
                if (grid.canPlaceShip(row, col, size, horizontal)) {
                    grid.placeShip(row, col, size, horizontal);
                    placed = true;
                }
            }
        }
    }
}

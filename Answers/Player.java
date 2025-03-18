import java.util.Scanner;

class Player {
        private String name;
        private Board grid;
        private Board trackingGrid;
        private Scanner scanner;

        public Player(String name) {
            this.name = name;
            this.grid = new Board();
            this.trackingGrid = new Board();
            this.scanner = new Scanner(System.in);
        }

        public void placeShips() {
            ShipPlacer.placeShips(grid);
        }

        public void takeTurn(Player opponent) {
            System.out.print("Enter coordinates to attack (e.g., A5): ");
            String input = scanner.nextLine().toUpperCase();
            if (!Utils.isValidInput(input)) {
                System.out.println("Invalid input. Try again.");
                return;
            }

            int row = input.charAt(0) - 'A';
            int col = Integer.parseInt(input.substring(1)) - 1;

            if (opponent.grid.attack(row, col)) {
                System.out.println("Hit!");
                trackingGrid.setHit(row, col);
            } else {
                System.out.println("Miss!");
                trackingGrid.setMiss(row, col);
            }
        }

        public boolean allShipsSunk() {
            return grid.allShipsSunk();
        }

        public void printTrackingGrid() {
            trackingGrid.print();
        }
    }


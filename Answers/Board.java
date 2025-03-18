class Board {
    private char[][] grid;
    private static final int GRID_SIZE = 10;

    public Board() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '~';
            }
        }
    }

    public boolean canPlaceShip(int row, int col, int size, boolean horizontal) {
        if (horizontal) {
            if (col + size > GRID_SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] != '~') return false;
            }
        } else {
            if (row + size > GRID_SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (grid[row + i][col] != '~') return false;
            }
        }
        return true;
    }

    public void placeShip(int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            if (horizontal) {
                grid[row][col + i] = 'S';
            } else {
                grid[row + i][col] = 'S';
            }
        }
    }
    public boolean attack(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';
            return true;
        } else {
            grid[row][col] = 'O';
            return false;
        }
    }

    public boolean allShipsSunk() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 'S') return false;
            }
        }
        return true;
    }

    public void setHit(int row, int col) {
        grid[row][col] = 'X';
    }

    public void setMiss(int row, int col) {
        grid[row][col] = 'O';
    }

    public void print() {
        System.out.print("  ");
        for (int i = 1; i <= GRID_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


}

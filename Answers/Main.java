import java.util.Random;
import java.util.Scanner;

public class Main {

     int GRID_SIZE = 10;

    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        player1.placeShips();
        player2.placeShips();

        boolean player1Turn = true;

        while (!isGameOver(player1, player2)) {
            if (player1Turn) {
                System.out.println("Player 1's turn:");
                player1.printTrackingGrid();
                player1.takeTurn(player2);
            } else {
                System.out.println("Player 2's turn:");
                player2.printTrackingGrid();
                player2.takeTurn(player1);
            }
            player1Turn = !player1Turn;
        }

        System.out.println("Game Over!");
    }

    static boolean isGameOver(Player player1, Player player2) {
        return player1.allShipsSunk() || player2.allShipsSunk();
    }
}
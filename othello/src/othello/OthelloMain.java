package othello;
import othello.positions.InvalidPositionException;

public class OthelloMain {
    public static void main(String[] args) throws InvalidPositionException {
        if (args.length != 2) {
            System.out.println("Usage: java GameMain <player1> <player2>");
            System.exit(1);
        }
        Othello othello = new Othello(8, args[0], args[1]);
        System.out.println("Welcome to Othello");
        System.out.println("Black pawns are represented by X");
        System.out.println("White pawns are represented by O");
        while (!othello.gameOver()) {
            int x = 0;
            int y = 0;
            othello.displayBoard();
            System.out.println(othello.getCurrentPlayer().getName() + " plays " + othello.getCurrentPlayer().getColor() + " Pawns" );
            System.out.println("Enter the position line of your pawn: ");
            x = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the position column of your pawn: ");
            y = Integer.parseInt(System.console().readLine());
            if (x < 1 || x > othello.getBoard().length || y < 1 || y > othello.getBoard().length ) {
                System.out.println("Invalid position");
                continue;
            }
            othello.positions.Position pos = new othello.positions.Position(x-1, y-1);
            if (!(othello.checkIfPlayIsValid(pos))){
                System.out.println("Invalid position");
            } else {
                othello.playAtPosition(pos);
                System.out.println("Pawn played");
                if (othello.gameOver()){
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Game Over");
                    othello.displayBoard();
                    System.out.println("There is" + othello.numberOfBlackPawns() + "black pawns");
                    System.out.println("There is" + othello.numberOfWhitePawns() + "white pawns");
                    System.out.println("The winner is " + othello.isWinner().getName());
                    System.out.println("-----------------------------------------------------------");
                }
            
            }
            
        }
    }
}


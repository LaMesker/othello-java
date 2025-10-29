package othello.positions;

/**
 * InvalidPositionException is an exception that is thrown when a position is invalid.
 * A position is invalid if it is out of the board or if it is already occupied.
 * 
 */

public class InvalidPositionException extends Exception {
    public InvalidPositionException(String arg0) {
        super(arg0);
    }
}

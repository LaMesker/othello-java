package othello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import othello.positions.InvalidPositionException;
import othello.positions.Position;
import othello.util.Color;
import othello.positions.Direction;




public class GameTest {
    /**
     * Test method testPlayAtPosition
     */
    @Test
    public void testPlayAtPosition() throws InvalidPositionException{
        Othello g = new Othello(8, "J1" ,"J2");
        g.playAtPosition(new Position(3,2));
        assertEquals(Color.BLACK, g.getPawnAt(new Position(3,2)).getColor());
        g.playAtPosition(new Position(2,2));
        assertEquals(Color.WHITE, g.getPawnAt(new Position(2,2)).getColor());

    }
    /**
     * Test method testGameOver
     */

    @Test
    public void checkIfPlayIsValidTest() throws InvalidPositionException {
        Othello g = new Othello(8, "Emine", "Ouari");
        assertTrue(g.checkIfPlayIsValid(new Position(3,2)));
        assertFalse(g.checkIfPlayIsValid(new Position(4,2)));
        assertFalse(g.checkIfPlayIsValid(new Position(4,1)));
        assertFalse(g.checkIfPlayIsValid(new Position(5,1)));
        g.playAtPosition(new Position(3,2));
        assertFalse(g.checkIfPlayIsValid(new Position(3,2)));
        assertTrue(g.checkIfPlayIsValid(new Position(2,2)));
        g.playAtPosition(new Position(2,2));
        assertFalse(g.checkIfPlayIsValid(new Position(2,2)));
    }

    /**
     * Test method testGameOver
     */

    @Test
    public void applyConsequencesTest() throws InvalidPositionException{
        Othello b = new Othello(8, "Joueur1", "Joueur2");
        b.playAtPosition(new Position(3,2));
        assertEquals(b.getBoard()[3][3].getColor(),b.getBoard()[3][2].getColor());
        b.playAtPosition(new Position(2,2));
        assertEquals(b.getBoard()[3][3].getColor(),b.getBoard()[2][2].getColor());
    }
    /**
     * Test method testGameOver
     */

    @Test
    public void additionPosDirectionTest() throws InvalidPositionException {
        Othello g = new Othello(8,"j","j");
        Position p = new Position(3,2);
        Position a = g.additionPosDirection(p, Direction.UP);
        assertEquals(2, a.getPosX());
        assertEquals(2,a.getPosY());
        }
}
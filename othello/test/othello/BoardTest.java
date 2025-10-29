package othello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import othello.positions.InvalidPositionException;
import othello.positions.Position;
import othello.util.Color;



public class BoardTest {
    
    /**
     * Test method getSize
     */
    
    @Test
    public void testGetSize() throws InvalidPositionException {
        Board board = new Board(8);
        assertEquals(8, board.getSize(), "Board size should be 8");
    }

    /**
     * Test method getPawnAt
     */

    @Test
    public void testIsFull() throws InvalidPositionException{
        Board b = new Board(4);
        assertFalse(b.isFull());
        Board b1 = new Board(4);
        b1.putPawnAt(new Pawn(Color.BLACK), new Position(0,0));
        assertFalse(b1.isFull());
        Board b2 = new Board(2);
        assertTrue(b2.isFull());
    }

    @Test
    public void testGetBoard() throws InvalidPositionException {
        Board board = new Board(8);
        assertNotNull(board, "Board state should not be null");
        assertEquals(8, board.getBoard().length, "Board should have 8 rows");
        assertEquals(8, board.getBoard()[0].length, "Board should have 8 columns");
    }
    
    /**
     * Test method PutPawnAt vu en cours
     */
    @Test
    public void testPutPawnAtInvalidPosition()throws InvalidPositionException {
        Board b = new Board(4);
        Pawn p = new Pawn(Color.BLACK);
        assertThrows(InvalidPositionException.class, () -> b.putPawnAt(p, new Position(0,b.getSize())));
        assertThrows(InvalidPositionException.class, () -> b.putPawnAt(p, new Position(b.getSize(),0)));
        assertThrows(InvalidPositionException.class, () -> b.putPawnAt(p, new Position(-1,0)));
        assertThrows(InvalidPositionException.class, () -> b.putPawnAt(p, new Position(0,-1)));
    }

    /**
     * Test method PutPawnAt
     */
    @Test
    public void testPutPawnAtValidPosition() throws InvalidPositionException {
        Board b = new Board(6);
        Pawn p = new Pawn(Color.BLACK);
        Position pos = new Position(2,2);
        b.putPawnAt(p,pos);
        assertEquals(p,b.getPawnAt(pos));
    }

}
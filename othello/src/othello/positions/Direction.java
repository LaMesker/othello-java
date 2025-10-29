package othello.positions;

/**
 * Enumerates the possible directions in which a player can move is pawn.
 */

public enum Direction {
    UP(-1,0), DOWN(+1,0), LEFT(0,-1), RIGHT(0,+1), UP_LEFT(-1,-1), UP_RIGHT(-1,+1), DOWN_LEFT(+1,-1), DOWN_RIGHT(+1,+1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the X factor of the direction
     * @return the X factor of the direction
     */

    public int getX(){
        return this.x;
    }

    /**
     * returns the Y factor of the direction
     * @return the Y factor of the direction
     */

    public int getY(){
        return this.y;
    }
}
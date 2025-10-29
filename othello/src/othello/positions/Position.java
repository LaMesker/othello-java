package othello.positions;

/**
 * Position defines where a case is in the board
 * it has two attributes x and y that decides where the case is vertically and horizontaly
 * x and y cannot be greater than the board size
 */
public class Position {

    private int x;
    private int y;
    
    /**
     * Constructor of the class Position
     * @param x the vertical position of the case
     * @param y the horizontal position of the case
     */

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * gets the X position
     * @return the X position
     */

    public int getPosX() {
        return this.x;

    }

    /**
     * gets the Y position
     *  @return the Y position
     */

    public int getPosY() {
        return this.y;
    }

    /**
     * verify if two postitions are equal
     * @return if two positions are equal
     */
    
    public boolean equals (Object obj) {
        if (!(obj instanceof Position)){
            return false;
        }
        Position other = (Position) obj;
        
        return this.x == other.x && this.y == other.y ;
    }

    
    
}
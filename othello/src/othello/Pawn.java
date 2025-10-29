package othello;

import othello.util.Color;

/**
 * A case contains pawns or not it is part of a board
 * it has a position
 * it is empty or colored (white and black)
 */

public class Pawn {
    private Color color;

    /**
     * Constructor of the class Case
     * @param color
     */

    public Pawn(Color col) {
        this.color = col;
    }

    
    /**
     * Return the color of the case
     * @return the color of the case
     */

    public Color getColor() {
        if(this.color == null){
            return null;
        }
        return this.color;
    }
    
    /**
     * Verify if two pawns are equal
     * @param Object obj
     * @return if two pawns are equal
     */

    public boolean equals(Object obj){
        if (!(obj instanceof Pawn)){
            return false;
        }
        Pawn pawn = (Pawn) obj;
        
        return this.color == pawn.color;
    }
}
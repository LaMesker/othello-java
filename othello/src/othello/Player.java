package othello;

import othello.util.Color;

/**
 * Create a player with a color and a name
 */

public class Player {
    private Color color;
    private String name;

    /**
     * Constructor of the class Player
     * @param color the color of this player , @param name the name of this player
     */

    public Player(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    /**
     * returns the color of this player
     * @return the color of this player
     */

    public Color getColor(){
        return this.color;
    }

    /**
     * returns the name of this player
     * @return the name of this player
     */

    public String getName(){
        return this.name;
    }
}
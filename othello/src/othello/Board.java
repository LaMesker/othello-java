package othello;
import othello.util.Color;
import othello.positions.*;

/**
 * A board has dimensions and cases 
 * 
 */

public class Board {
    private int size;
    private Pawn[][] pawns;

    /**
     * builds a board
     * @throws InvalidPositionException
     * @return a board with 4 pawns in the middle
     */

    public Board(int size) throws InvalidPositionException{
        this.size = size;
        this.pawns = new Pawn[size][size];
        putPawnAt(new Pawn(Color.WHITE), new Position(size/2,size/2));
        putPawnAt(new Pawn(Color.WHITE), new Position(size/2-1,size/2-1));
        putPawnAt(new Pawn(Color.BLACK), new Position(size/2-1,size/2));
        putPawnAt(new Pawn(Color.BLACK), new Position(size/2,size/2-1));
        }

      
    
    
    /**
     *returns the size of the board
     */

    public int getSize(){
        return this.pawns.length;
    }
    
    /**
     * returns true if the board is full else return false
     * @return a boolean
     */
    
    public boolean isFull() {
        for(int i = 0 ; i<this.size ; i++){
            for(int j = 0 ; j<this.size ; j++){
                if (this.pawns[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * checks if the board only contains black pawns
     * @return boolean if the board is full of black pawns
     */

    public boolean onlyBlack(){
        //cheks if all the pawns are black if the case is null just skip it
        for(int i = 0 ; i<this.size ; i++){
            for(int j = 0 ; j<this.size ; j++){
                if (this.pawns[i][j]==null){
                    continue;
                }
                if (this.pawns[i][j].getColor()== Color.WHITE){
                    return false;
                    }
                }
        }
        return true;
    }

    /**
     * checks if the board only contains white pawns
     * @return boolean if the board is full of white pawns
     */

    public boolean onlyWhite(){
        for(int i = 0 ; i<this.size ; i++){
            for(int j = 0 ; j<this.size ; j++){
                if (this.pawns[i][j]==null){
                    continue;
                }
                if (this.pawns[i][j].getColor()== Color.BLACK){
                    return false;
                    }
                }
        }
        return true;
    }

    /**
     * returns the board
     * @return the board
     */

    public Pawn[][] getBoard() {
        return this.pawns;
    }

    /**
     * returns the pawn at the given position in the board or null if no pawn
     * @param Position pos
     * @return the pawn at given pos
     * @throws InvalidPositionException
     */

    public Pawn getPawnAt(Position pos) throws InvalidPositionException {
        if (!(this.pawns[pos.getPosX()][pos.getPosY()] instanceof Pawn)){
            return null;
        }
        return this.pawns[pos.getPosX()][pos.getPosY()];
    }

    /**
     * places the given Pawn at the given position in the pawn
     * @param Pawn pawn
     * @param Position pos
     * @throws InvalidPositionException
     */
    
    public void putPawnAt(Pawn pawn, Position pos) throws InvalidPositionException{
        try{
            this.pawns[pos.getPosX()][pos.getPosY()] = pawn;
        } catch (ArrayIndexOutOfBoundsException e){
            throw new InvalidPositionException("position invalide");
        }
    }
}
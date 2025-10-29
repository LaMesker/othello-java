package othello;
import othello.positions.InvalidPositionException;
import othello.positions.Position;
import othello.util.Color;
import othello.positions.Direction;

public class Othello {
    private boolean running;
    private Player currentPlayer;
    private Player otherPlayer;
    private Board board;
    public Direction[] directions;

    /**
     * Creates a game with the size of the board and the names of both players
     * @param int size
     * @param String player1
     * @param String player2
     * @throws InvalidPositionException
     */

    public Othello(int size, String player1, String player2) throws InvalidPositionException {
        this.running = true;
        this.board = new Board(size);
        this.currentPlayer = new Player(Color.BLACK, player1);
        this.otherPlayer = new Player(Color.WHITE, player2);
        this.directions = Direction.values();

    }

    /**
     * returns the pawn at the given position in the board
     * @return the pawn at given pos
     * @throws InvalidPositionException
     */

    public Pawn getPawnAt(Position pos) throws InvalidPositionException {
        return this.board.getBoard()[pos.getPosX()][pos.getPosY()];
    }
    
    /**
     * defines if the game should be continued or not
     * @return boolean
     * @throws InvalidPositionException 
     */

    public boolean gameOver() throws InvalidPositionException {
        return this.board.isFull() || this.board.onlyBlack() || this.board.onlyWhite() || !this.stillPlayable();
    }

    /**
     * checks if there is still playable positons
     * @return boolean
     */

    public boolean stillPlayable() throws InvalidPositionException {
        //checks if there is still a playable position
        for (int i = 0 ; i<this.board.getSize() ; i++){
            for (int j = 0 ; j<this.board.getSize() ; j++){
                if (this.checkIfPlayIsValid(new Position(i,j))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * counts the number of pawns of each player and returns the player with the most pawns
     * @return the player with most pawns
     */

    public Player isWinner() throws InvalidPositionException {
        
        int black = 0;
        int white = 0;
        for (int i = 0 ; i<this.board.getSize() ; i++){
            for (int j = 0 ; j<this.board.getSize() ; j++){
                if (this.board.getBoard()[i][j] instanceof Pawn){
                    if (this.board.getBoard()[i][j].getColor() == Color.BLACK){
                        black++;
                    }
                    else {
                        white++;
                    }
                }
            }
        }
        return black > white ? this.currentPlayer : this.otherPlayer;
    }

    /**
     * counts the number of black pawns
     * @return the number of black pawns
     */

    public int numberOfBlackPawns()
    {
        int black = 0;
        for (int i = 0 ; i<this.board.getSize() ; i++){
            for (int j = 0 ; j<this.board.getSize() ; j++){
                if (this.board.getBoard()[i][j] instanceof Pawn){
                    if (this.board.getBoard()[i][j].getColor() == Color.BLACK){
                        black++;
                    }
                }
            }
        }
        return black;
    }

    /**
     * counts the number of white pawns
     * @return the number of white pawns
     */

    public int numberOfWhitePawns()
    {
        int white = 0;
        for (int i = 0 ; i<this.board.getSize() ; i++){
            for (int j = 0 ; j<this.board.getSize() ; j++){
                if (this.board.getBoard()[i][j] instanceof Pawn){
                    if (this.board.getBoard()[i][j].getColor() == Color.WHITE){
                        white++;
                    }
                }
            }
        }
        return white;
    }
    

    /**
     * changes the turn
     */
    public void changeTurn(){
        Player temp = this.currentPlayer;
        this.currentPlayer = this.otherPlayer;
        this.otherPlayer = temp;
    }

    /**
     * returns the board
     * @return the board
     */
    public Pawn [][] getBoard() {
        return this.board.getBoard();
    }

    /**
     * Displays the board with X as black pawns and O as white pawns
     */
    public void displayBoard(){
        for (int i = 0 ; i<this.board.getSize() ; i++){
            for (int j = 0 ; j<this.board.getSize() ; j++){
                if (this.board.getBoard()[i][j] instanceof Pawn){
                    if (this.board.getBoard()[i][j].getColor() == Color.BLACK){
                        System.out.print(" X ");
                    }
                    else {
                        System.out.print(" O ");
                    }
                }
                else {
                    System.out.print("   ");
                }
                if (j != this.board.getSize()-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != this.board.getSize()-1){
                for (int k = 0 ; k<this.board.getSize() ; k++){
                    System.out.print("---");
                    if (k != this.board.getSize()-1){
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }        
        
    }

    /**
     * returns the state of the game
     * @return the state of the game
     */
    public boolean stillRunning() {
        return this.running;
    } 

    /**
     * returns the current player
     * @return the current player
     */

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    /**
     * @param pos
     * @param direction
     * @return position after adding direction
     */
    
    public Position additionPosDirection(Position pos, Direction direction) {
        return new Position(pos.getPosX() + direction.getX(), pos.getPosY() + direction.getY());
    }

    /**
     * checks if position is in the board
     */

    public boolean inBoard(Position pos) {
        return pos.getPosX() > -1 && pos.getPosX() < this.board.getSize() && pos.getPosY() > -1 && pos.getPosY() < this.board.getSize();
    }

    /**
     * checks if play is valid
     * @return boolean
     */

    public boolean checkIfPlayIsValid(Position pos) throws InvalidPositionException {
        if (this.board.getPawnAt(pos) instanceof Pawn){
            return false;
        }
        for (int i = 0 ; i<8 ; i++) {
            Position temp = additionPosDirection(pos, this.directions[i]);
            if (inBoard(temp) && this.board.getPawnAt(temp) instanceof Pawn) {
                if (this.board.getPawnAt(temp).getColor() == this.otherPlayer.getColor()) {
                    temp = additionPosDirection(pos, this.directions[i]);
                    while (inBoard(temp) && this.board.getPawnAt(temp) instanceof Pawn) {
                        if (this.board.getPawnAt(temp) instanceof Pawn && this.board.getPawnAt(temp).getColor() != null && this.board.getPawnAt(temp).getColor() == this.currentPlayer.getColor()) {
                            return true;
                        }
                        temp = additionPosDirection(temp, this.directions[i]);
                    }
                }
            }
        }
        return false;
    }
    



    /**
     * Apply the consequences of the last play
     * @param lPositions
     */
    public void applyConsequences(Position pos) throws InvalidPositionException {
        for (int i = 0 ; i<8 ; i++) {
            Position temp = additionPosDirection(pos, this.directions[i]);
            if (inBoard(temp) && this.board.getPawnAt(temp) instanceof Pawn) {
                if (this.board.getPawnAt(temp).getColor() == this.otherPlayer.getColor()) {
                    temp = additionPosDirection(pos, this.directions[i]);
                    while (inBoard(temp) && this.board.getPawnAt(temp) instanceof Pawn) {
                        if (this.board.getPawnAt(temp) instanceof Pawn && this.board.getPawnAt(temp).getColor() != null && this.board.getPawnAt(temp).getColor() == this.currentPlayer.getColor()) {
                            Position temp2 = additionPosDirection(pos, this.directions[i]);
                            while (inBoard(temp2) && this.board.getPawnAt(temp2) instanceof Pawn && this.board.getPawnAt(temp2).getColor() == this.otherPlayer.getColor()) {
                                this.board.putPawnAt(new Pawn(this.currentPlayer.getColor()), temp2);
                                temp2 = additionPosDirection(temp2, this.directions[i]);
                            }
                        }
                        temp = additionPosDirection(temp, this.directions[i]);
                    }
                }
            }
        }
        

    }

    /**
     * Makes the play made by the player
     * @param position
     * @throws InvalidPositionException
     */

    public void playAtPosition(Position pos) throws InvalidPositionException {       
        this.board.putPawnAt(new Pawn(this.currentPlayer.getColor()), pos);
        this.applyConsequences(pos);
        if (!gameOver()){
            this.changeTurn();
        }
        else {
            this.running = false;
        }
    }


}
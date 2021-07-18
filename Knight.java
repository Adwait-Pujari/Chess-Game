public class Knight extends ChessPiece{
    /**
     * Constructor of Knight class called in BoardLoader
     * @param newColor sets the colour of the piece.
     * @param theBoard object of board class.
     */
    public Knight(String newColor, Board theBoard)
    {
        super("Knight", newColor,theBoard);
        super.setGraphics("KnightBlack.png","KnightWhite.png");
    }
    public Knight(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("KnightBlack.png","KnightWhite.png");


    }

    /**
     * Overridden function of chessPiece class
     * @param currentRow Gives the row of the piece selected.
     * @param currentCol Gives the column of the piece selected.
     * @param futureRow Gives the row position of all the valid moves.
     * @param futureCol Gives the column position of all the valid moves.
     * @return validity: if the move is valid.
     */
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity=false;

        /*
        String which gives the current and future tile colour
         */
        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);

        //Movement of the knight- 2 and a half step.
        if(futureRow==currentRow+2 && futureCol==currentCol+1 || futureRow==currentRow-2&& futureCol==currentCol+1 ||
        futureRow==currentRow+2 && futureCol==currentCol-1 || futureRow==currentRow-2&& futureCol==currentCol-1 ||
        futureCol==currentCol+2 && futureRow==currentRow+1 || futureCol==currentCol-2&& futureRow==currentRow+1 ||
        futureCol==currentCol+2 && futureRow==currentRow-1 || futureCol==currentCol-2&& futureRow==currentRow-1)
            validity=true;

        //The piece does not eat the same colour
        if(currentTileColour.equalsIgnoreCase(futureTileColour) )
            validity=false;

        return validity;
    }
}

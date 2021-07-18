public class King extends ChessPiece{
    /**
     * Constructor of king class called in BoardLoader
     * @param newColor sets the colour of the piece.
     * @param theBoard object of board class.
     */
    public King(String newColor, Board theBoard)
    {
        super("King", newColor,theBoard);
        super.setGraphics("KingBlack.png","KingWhite.png");
    }
    public King(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("KingBlack.png","KingWhite.png");
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
        boolean Validity=false; // Check if a move is valid or not

        /*
        String which gives the current and future tile colour
         */
        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);

        //Condition to make the king move one tile.
        if(futureCol==currentCol+1 && futureRow==currentRow || futureCol==currentCol-1 && futureRow==currentRow
        || futureRow==currentRow+1 && futureCol==currentCol || futureRow==currentRow-1 && futureCol==currentCol)
            Validity=true;
        if((futureCol==currentCol+1 && futureRow==currentRow+1) || (futureCol==currentCol-1 && futureRow==currentRow+1)
                ||(futureCol==currentCol+1 && futureRow==currentRow-1)||(futureCol==currentCol-1 && futureRow==currentRow-1))
            Validity=true;

        //The piece does not eat the same colour
        if(futureTileColour.equals(currentTileColour))
            Validity=false;

        return Validity;
    }
}

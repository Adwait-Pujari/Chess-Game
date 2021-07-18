public class Pawn extends ChessPiece {
    /**
     * Constructor of pawn class called in BoardLoader
     * @param newColor sets the colour of the piece.
     * @param theBoard object of board class.
     */
    public Pawn(String newColor, Board theBoard) {
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
        // super.toString();

    }

    public Pawn(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

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
        boolean validity = false;

        /*
        String which gives the current and future tile colour
         */
        String futureTileColour = super.getBoard().getPieceColor(futureRow, futureCol);
        String currentTileColour = super.getBoard().getPieceColor(currentRow, currentCol);

        //For making the piece move two step.
        boolean checkPieceForWhite = super.getBoard().hasPiece(3, currentCol);
        boolean checkPieceForBlack = super.getBoard().hasPiece(4, currentCol);

        //Moving white pawn.
        if (currentTileColour == "WHITE") {

                if (currentRow == 1 && !checkPieceForWhite && futureRow == currentRow + 2 && futureCol == currentCol)
                    validity = true;
                if (futureRow == currentRow + 1 && futureCol == currentCol) {
                    validity = true;
                }
                if (futureTileColour == "BLACK") {
                    validity = false;
                }
                if (futureCol == currentCol + 1 && futureRow == currentRow + 1 && getBoard().hasPiece(futureRow, futureCol)
                        || futureCol == currentCol - 1 && futureRow == currentRow + 1 && getBoard().hasPiece(futureRow, futureCol))
                    validity = true;




        }
        //Moving black pawn.
        else if (currentTileColour == "BLACK") {
            if (currentRow == 6 && !checkPieceForBlack && futureRow == currentRow - 2 && futureCol == currentCol)
                validity = true;
            if (futureRow == currentRow - 1 && futureCol == currentCol) {
                validity = true;
            }
            if (futureTileColour == "WHITE") {
                validity = false;
            }
            if (futureCol == currentCol + 1 && futureRow == currentRow - 1 && getBoard().hasPiece(futureRow, futureCol)
                    || futureCol == currentCol - 1 && futureRow == currentRow - 1 && getBoard().hasPiece(futureRow, futureCol))
                validity = true;

        }
        //The piece does not eat the same colour
        if (currentTileColour.equalsIgnoreCase(futureTileColour))
            validity = false;
        return validity;
    }
}

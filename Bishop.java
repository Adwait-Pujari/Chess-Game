public class Bishop extends ChessPiece{
    /**
     * Constructor of bishop class called in BoardLoader
     * @param newColor sets the colour of the piece.
     * @param theBoard object of board class.
     */
    public Bishop(String newColor, Board theBoard)
    {
        super("Bishop", newColor,theBoard);
        super.setGraphics("BishopBlack.png","BishopWhite.png");
    }
    public Bishop(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("BishopBlack.png","BishopWhite.png");
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
        Absolute value. To find the distance.
         */
        int absRow=Math.abs(futureRow-currentRow);
        int absCol=Math.abs(futureCol-currentCol);
        /*
        String which gives the current and future tile colour
         */
        String futureTileColour = super.getBoard().getPieceColor(futureRow, futureCol);
        String currentTileColour = super.getBoard().getPieceColor(currentRow, currentCol);

        if(absRow==absCol)
            validity=true;
        //Movement from north west to south east .
        if(currentRow+currentCol==futureRow+futureCol && absRow==absCol && absRow+absCol>0) {
            for (int i = 1; i < absRow; i++) {
                if (futureRow > currentRow ) {
                    if (getBoard().hasPiece(futureRow - i, futureCol + i))
                        validity = false;
                } else if (futureRow < currentRow) {

                    if (getBoard().hasPiece(futureRow + i, futureCol - i))
                        validity = false;
                }
            }
        }
        //Movement from north east to south west.
        if(currentRow+currentCol!=futureRow+futureCol && absRow==absCol && absRow+absCol>0) {
            for (int i = 1; i < absRow; i++) {
                if (futureRow > currentRow ) {
                    if (getBoard().hasPiece(futureRow - i, futureCol - i))
                        validity = false;
                } else if (futureRow < currentRow) {

                    if (getBoard().hasPiece(futureRow + i, futureCol + i))
                        validity = false;
                }
            }
        }
        //The piece does not eat the same colour
        if (currentTileColour.equalsIgnoreCase(futureTileColour))
            validity = false;


        return validity;
    }
}

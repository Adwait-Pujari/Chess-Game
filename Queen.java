public class Queen extends ChessPiece{

    public Queen(String newColor, Board theBoard)
    {
        super("Queen", newColor,theBoard);
        super.setGraphics("QueenBlack.png","QueenWhite.png");

    }
    public Queen(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("QueenBlack.png","QueenWhite.png");
    }
    
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity = false;
        int absRow = Math.abs(futureRow - currentRow);
        int absCol = Math.abs(futureCol - currentCol);
        String futureTileColour = super.getBoard().getPieceColor(futureRow, futureCol);
        String currentTileColour = super.getBoard().getPieceColor(currentRow, currentCol);


        if (futureCol >= 0 && futureCol <= 7 && futureRow == currentRow)
            validity = true;
        if (futureRow >= 0 && futureRow <= 7 && futureCol == currentCol)
            validity = true;

       /*
       For upward n downward  movement
        */
        for (int i = 1; i < absRow; i++) {
            if (futureRow > currentRow) {
                if (getBoard().hasPiece(futureRow - i, currentCol))
                    validity = false;
            } else if (futureRow < currentRow) {
                if (getBoard().hasPiece(futureRow + i, currentCol))
                    validity = false;
            }
        }
        /*
        For left and right movement
         */
        for (int i = 1; i < absCol; i++) {
            if (futureCol > currentCol) {
                if (getBoard().hasPiece(currentRow, futureCol - i))
                    validity = false;
            } else if (futureCol < currentCol) {
                if (getBoard().hasPiece(currentRow, futureCol + i))
                    validity = false;
            }
        }
        if (currentTileColour.equalsIgnoreCase(futureTileColour))
            validity = false;

        if(absRow==absCol)
            validity=true;

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
        if (currentTileColour.equalsIgnoreCase(futureTileColour))
            validity = false;
        return validity;
    }
}

public class Bishop extends ChessPiece{

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


    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity=false;

        int absRow=Math.abs(futureRow-currentRow);
        int absCol=Math.abs(futureCol-currentCol);
        String futureTileColour = super.getBoard().getPieceColor(futureRow, futureCol);
        String currentTileColour = super.getBoard().getPieceColor(currentRow, currentCol);

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

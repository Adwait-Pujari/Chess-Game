public class King extends ChessPiece{

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


    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean Validity=false; // Check if a move is valid or not

        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);


//&& futureTileColour!=currentTileColour
        if(futureCol==currentCol+1 && futureRow==currentRow || futureCol==currentCol-1 && futureRow==currentRow
        || futureRow==currentRow+1 && futureCol==currentCol || futureRow==currentRow-1 && futureCol==currentCol)
            Validity=true;
        if((futureCol==currentCol+1 && futureRow==currentRow+1) || (futureCol==currentCol-1 && futureRow==currentRow+1)
                ||(futureCol==currentCol+1 && futureRow==currentRow-1)||(futureCol==currentCol-1 && futureRow==currentRow-1))
            Validity=true;
        if(futureTileColour.equals(currentTileColour))
            Validity=false;
        return Validity;
    }


}

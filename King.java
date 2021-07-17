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

    @Override
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean Validity=false; // Check if a move is valid or not

        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);

        if(futureCol==currentCol+1 || futureRow==currentRow+1 || futureRow==currentRow-1 || futureCol==currentCol-1  )
            Validity=true;

        if(futureTileColour==currentTileColour)
            Validity=false;
        return Validity;
    }


}

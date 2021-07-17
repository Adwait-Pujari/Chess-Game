public class Knight extends ChessPiece{

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


    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity=false;

        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);

        if(futureRow==currentRow+2 && futureCol==currentCol+1 || futureRow==currentRow-2&& futureCol==currentCol+1 ||
        futureRow==currentRow+2 && futureCol==currentCol-1 || futureRow==currentRow-2&& futureCol==currentCol-1 ||
        futureCol==currentCol+2 && futureRow==currentRow+1 || futureCol==currentCol-2&& futureRow==currentRow+1 ||
        futureCol==currentCol+2 && futureRow==currentRow-1 || futureCol==currentCol-2&& futureRow==currentRow-1)
            validity=true;

        if(currentTileColour==futureTileColour )
            validity=false;

        return validity;
    }
}

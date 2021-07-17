public class Castle extends ChessPiece{

    public Castle(String newColor, Board theBoard)
    {
        super("Castle", newColor,theBoard);
        super.setGraphics("CastleBlack.png","CastleWhite.png");
    }
    public Castle(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("CastleBlack.png","CastleWhite.png");
    }


    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity=false;

        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);

        for(int i=0;i<=7;i++)
        {


            if(futureCol==i && futureRow==currentRow)
                validity=true;
            if(futureRow==i && futureCol==currentCol)
                validity=true;
            if(currentTileColour.equalsIgnoreCase(futureTileColour) ) {
                validity = false;
            }
        }

        return validity;
    }
}

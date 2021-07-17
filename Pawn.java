public class Pawn extends ChessPiece{

    public Pawn(String newColor, Board theBoard)
    {
        super("Pawn", newColor,theBoard);
        super.setGraphics("PawnBlack.png","PawnWhite.png");
       // super.toString();

    }
    public Pawn(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("PawnBlack.png","PawnWhite.png");

    }

    @Override
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity=false;

        String futureTileColour=super.getBoard().getPieceColor(futureRow,futureCol);
        String currentTileColour=super.getBoard().getPieceColor(currentRow,currentCol);



        if(currentTileColour=="WHITE" )
        {
            if(futureRow==currentRow+1 && futureCol==currentCol)
            {
                validity=true;
            }
            if(futureTileColour=="BLACK")
            {
                validity=false;
            }
        }
        else if(currentTileColour=="BLACK")
        {
            if(futureRow==currentRow-1 && futureCol==currentCol)
            {
                validity=true;
            }
            if(futureTileColour=="WHITE")
            {
                validity=false;
            }
        }

        if(currentTileColour==futureTileColour )
            validity=false;
        return validity;
    }
}

public class Pawn extends ChessPiece{
    private String newColor;
    private Board theBoard;
    private String name;
    public Pawn(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;
    }
    public Pawn(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("PawnBlack.png","PawnWhite.png");
    }
}

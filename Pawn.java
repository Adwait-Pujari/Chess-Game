public class Pawn extends ChessPiece{
    private String newColor;
    private Board theBoard;
    public Pawn(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;
    }
    public Pawn(String name, String newColor, Board theBoard)
    {

    }
}

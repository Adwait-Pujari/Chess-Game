public class Queen extends ChessPiece{
    private String newColor;
    private Board theBoard;
    private String name;
    public Queen(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;

    }
    public Queen(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
    }

}

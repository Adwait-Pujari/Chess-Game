public class Bishop extends ChessPiece{
    private String newColor;
    private Board theBoard;
    private String name;
    public Bishop(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;
    }
    public Bishop(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
    }
}

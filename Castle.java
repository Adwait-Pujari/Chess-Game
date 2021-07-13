public class Castle extends ChessPiece{
    private String newColor;
    private Board theBoard;
    private String name;
    public Castle(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;
    }
    public Castle(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
    }
}

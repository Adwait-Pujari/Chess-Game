public class Knight extends ChessPiece{
    private String newColor;
    private Board theBoard;
    private String name;
    public Knight(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;
    }
    public Knight(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("KnightBlack.png","KnightWhite.png");
    }
}

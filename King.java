public class King extends ChessPiece{
    private String newColor;
    private Board theBoard;
    private String name;
    public King(String newColor, Board theBoard)
    {
        this.newColor=newColor;
        this.theBoard=theBoard;
    }
    public King(String name, String newColor, Board theBoard)
    {
        super(name,newColor,theBoard);
        super.setGraphics("KingBlack.png","KingWhite.png");
    }
}

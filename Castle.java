import javax.swing.*;

public class Castle extends ChessPiece {
    /**
     * Constructor of castle class called in BoardLoader
     * @param newColor sets the colour of the piece.
     * @param theBoard object of board class.
     */
    public Castle(String newColor, Board theBoard) {
        super("Castle", newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public Castle(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    /**
     * Overridden function of chessPiece class
     * @param currentRow Gives the row of the piece selected.
     * @param currentCol Gives the column of the piece selected.
     * @param futureRow Gives the row position of all the valid moves.
     * @param futureCol Gives the column position of all the valid moves.
     * @return validity: if the move is valid.
     */
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity = false;
        /*
        Absolute value. To find the distance.
         */
        int absRow = Math.abs(futureRow - currentRow);
        int absCol = Math.abs(futureCol - currentCol);

        /*
        String which gives the current and future tile colour
         */
        String futureTileColour = super.getBoard().getPieceColor(futureRow, futureCol);
        String currentTileColour = super.getBoard().getPieceColor(currentRow, currentCol);


        if (futureCol >= 0 && futureCol <= 7 && futureRow == currentRow)
            validity = true;
        if (futureRow >= 0 && futureRow <= 7 && futureCol == currentCol)
            validity = true;

       /*
       For upward n downward  movement of castle
        */
        for (int i = 1; i < absRow; i++) {
            if (futureRow > currentRow) {
                if (getBoard().hasPiece(futureRow - i, currentCol))
                    validity = false;
            } else if (futureRow < currentRow) {
                if (getBoard().hasPiece(futureRow + i, currentCol))
                    validity = false;
            }
        }
        /*
        For left and right movement of castle
         */
        for (int i = 1; i < absCol; i++) {
            if (futureCol > currentCol) {
                if (getBoard().hasPiece(currentRow, futureCol - i))
                    validity = false;
            } else if (futureCol < currentCol) {
                if (getBoard().hasPiece(currentRow, futureCol + i))
                    validity = false;
            }
        }
        //The piece does not eat the same colour
        if (currentTileColour.equalsIgnoreCase(futureTileColour))
            validity = false;

        return validity;
    }
}

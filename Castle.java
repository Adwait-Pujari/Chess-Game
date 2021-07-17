import javax.swing.*;

public class Castle extends ChessPiece {

    public Castle(String newColor, Board theBoard) {
        super("Castle", newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public Castle(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }


    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean validity = true;
        int absRow = Math.abs(futureRow - currentRow);
        int absCol = Math.abs(futureCol - currentCol);
        String futureTileColour = super.getBoard().getPieceColor(futureRow, futureCol);
        String currentTileColour = super.getBoard().getPieceColor(currentRow, currentCol);


//        for(int i=0;i<=7;i++)
//        {
//            if(futureCol==i && futureRow==currentRow)
//                validity=true;
//            if(futureRow==i && futureCol==currentCol)
//                validity=true;
//            if(currentTileColour.equalsIgnoreCase(futureTileColour) ) {
//
//
//                validity = false;
//            }
//        }


//        int obstacleVal = currentRow;
//        if (futureRow >= 0 && futureRow <= 7 && futureCol == currentCol) {
//
//            validity = true;
//
//            for (int i = currentRow + 1; i <= 7; i++) {
//                if (getBoard().hasPiece(i, currentCol)) {
//                    obstacleVal = i;
//                    validity = false;
//                }
//            }

       /*
       For upward n downward  movement
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
        for (int i = 1; i < absCol; i++) {
            if (futureCol > currentCol) {
                if (getBoard().hasPiece(currentRow, futureCol - i))
                    validity = false;


            } else if (futureCol < currentCol) {
                if (getBoard().hasPiece(currentRow, futureCol + i))
                    validity = false;
            }
        }
        if (currentTileColour.equalsIgnoreCase(futureTileColour))
            validity = false;


//            //validity=true;
//        }


        return validity;
    }
}

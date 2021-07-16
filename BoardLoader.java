import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class BoardLoader {
    private static String[][] boardFile;

//    public static void main(String args[]) {
//        parseFile(".//Boards//StandardBoard.txt");
//
//    }

    public static void loadBoardState(Board theBoard, String fileName) {
        parseFile(fileName);
        loadPiecesFromString(theBoard, parseFile(fileName));


    }

    private static String[][] parseFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String row = br.readLine();
            Scanner sc = new Scanner(row);

            int arrayLengthRow = sc.nextInt();
            int arrayLengthCol = sc.nextInt();
            boardFile = new String[arrayLengthRow][arrayLengthCol];

            while (row!=null) {
                for (int i = boardFile.length-1; i >=0; i--) {
                    row = br.readLine();
                    sc = new Scanner(row);
                    for (int j = boardFile[i].length-1; j >=0; j--) {
                        String temp = sc.next();
                        boardFile[i][j] = temp;
                    }
                    System.out.println("");
                }
            }
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

        return boardFile;
    }

    private static void loadPiecesFromString(Board targetBoard, String[][] boardCodes) {

        for(int i=0;i<boardCodes.length;i++)
        {
            for(int j=0;j<boardCodes[i].length;j++)
            {
                targetBoard.setPiece(i,j,BoardLoader.loadChessPiece(targetBoard,boardCodes[i][j]));
                targetBoard.drawPieces();
            }
        }

    }

    private static ChessPiece loadChessPiece(Board targetBoard, String code) {
        ChessPiece loadPiece=null;
        String Piece_colour="BLACK";
        if(code.charAt(0)=='W')
        {
            Piece_colour="WHITE";
        }
        if (code.charAt(0) == 'B' || code.charAt(0)=='W') {
            if (code.charAt(code.length() - 1) == 'P')
                loadPiece = new Pawn(Piece_colour, targetBoard);
            else if (code.charAt(code.length() - 1) == 'K')
                loadPiece = new King(Piece_colour, targetBoard);
            else if (code.charAt(code.length() - 1) == 'Q')
                loadPiece = new Queen(Piece_colour, targetBoard);
            else if (code.charAt(code.length() - 1) == 'B')
                loadPiece = new Bishop(Piece_colour, targetBoard);
            else if (code.charAt(code.length() - 1) == 'C')
                loadPiece = new Castle(Piece_colour, targetBoard);
            else if (code.charAt(code.length() - 1) == 'N')
                loadPiece = new Knight(Piece_colour, targetBoard);

        }
//        else if (code.charAt(0) == 'W') {
//            if (code.charAt(code.length() - 1) == 'P')
//                loadPiece = new Pawn("WHITE", targetBoard);
//            else if (code.charAt(code.length() - 1) == 'K')
//                loadPiece = new King("WHITE", targetBoard);
//            else if (code.charAt(code.length() - 1) == 'Q')
//                loadPiece = new Queen("WHITE", targetBoard);
//            else if (code.charAt(code.length() - 1) == 'B')
//                loadPiece = new Bishop("WHITE", targetBoard);
//            else if (code.charAt(code.length() - 1) == 'C')
//                loadPiece = new Castle("WHITE", targetBoard);
//            else if (code.charAt(code.length() - 1) == 'N')
//                loadPiece = new Knight("WHITE", targetBoard);
//
//        }
          else
            loadPiece = null;

        return loadPiece;
    }
}

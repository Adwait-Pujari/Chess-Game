import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class BoardLoader {
    private static String[][] boardFile;

    public static void main(String args[]) {
        parseFile(".//Boards//StandardBoard.txt");
        
    }

    public static void loadBoardState(Board theBoard, String fileName) {
        parseFile(fileName);
        loadPiecesFromString(theBoard, parseFile(fileName));
        //loadChessPiece(theBoard,);

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

            while (row != null) {
                for (int i = 0; i < boardFile.length; i++) {
                    row = br.readLine();
                    sc = new Scanner(row);
                    for (int j = 0; j < boardFile[i].length; j++) {
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
        for (int i = 0; i < boardFile.length; i++) {
            for (int j = 0; j < boardFile[i].length; j++) {
                System.out.print(boardFile[i][j] + " ");
            }
            System.out.println("");
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
        if (code.charAt(0) == 'B') {
            if (code.charAt(code.length() - 1) == 'P')
                loadPiece = new Pawn("BLACK", targetBoard);
            else if (code.charAt(code.length() - 1) == 'K')
                loadPiece = new King("BLACK", targetBoard);
            else if (code.charAt(code.length() - 1) == 'Q')
                loadPiece = new Queen("BLACK", targetBoard);
            else if (code.charAt(code.length() - 1) == 'B')
                loadPiece = new Bishop("BLACK", targetBoard);
            else if (code.charAt(code.length() - 1) == 'C')
                loadPiece = new Castle("BLACK", targetBoard);
            else if (code.charAt(code.length() - 1) == 'N')
                loadPiece = new Knight("BLACK", targetBoard);

        } else if (code.charAt(0) == 'W') {
            if (code.charAt(code.length() - 1) == 'P')
                loadPiece = new Pawn("WHITE", targetBoard);
            else if (code.charAt(code.length() - 1) == 'K')
                loadPiece = new King("WHITE", targetBoard);
            else if (code.charAt(code.length() - 1) == 'Q')
                loadPiece = new Queen("WHITE", targetBoard);
            else if (code.charAt(code.length() - 1) == 'B')
                loadPiece = new Bishop("WHITE", targetBoard);
            else if (code.charAt(code.length() - 1) == 'C')
                loadPiece = new Castle("WHITE", targetBoard);
            else if (code.charAt(code.length() - 1) == 'N')
                loadPiece = new Knight("WHITE", targetBoard);

        } else
            loadPiece = null;

        return loadPiece;
    }
}

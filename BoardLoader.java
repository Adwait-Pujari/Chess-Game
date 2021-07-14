import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;
public class BoardLoader {
    private static String[][] boardFile ;
    public static  void  main(String args[])
    {
        parseFile(".//Boards//StandardBoard.txt");
    }
    public static void loadBoardState(Board theBoard, String fileName)
    {

    }
    private static String[][] parseFile(String fileName)
    {
        try
        {
            FileReader fr =new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String row = br.readLine();
            Scanner sc =new Scanner(row);

            int arrayLengthRow= sc.nextInt();
            int arrayLengthCol= sc.nextInt();
            boardFile=new String[arrayLengthRow][arrayLengthCol];

            while(row!=null)
            {

                for(int i=0;i<boardFile.length;i++)
                {
                    row= br.readLine();
                    sc=new Scanner(row);
                    for(int j =0;j<boardFile[i].length;j++)
                    {


                        String temp=sc.next();
                        boardFile[i][j]=temp;

                    }

                }
            }
            fr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        for(int i=0;i<boardFile.length;i++)
        {
            for(int j =0;j<boardFile[i].length;j++) {
                System.out.print(boardFile[i][j] + " ");
            }
            System.out.println("");
        }
        return boardFile;
    }
}

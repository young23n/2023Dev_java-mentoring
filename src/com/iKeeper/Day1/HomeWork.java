package Day1;
import java.util.*;
import java.io.*;
public class HomeWork {
    private static String[] tmp = new String[2];
    public static void main(String[] args) throws Exception
    {
        gameStart();
        //코드작성
        //tmp[0] -> player1
        //tmp[1] -> player2
    }
    public static void gameStart()throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tmp[0]=st.nextToken();
        tmp[1]=st.nextToken();
    }
}

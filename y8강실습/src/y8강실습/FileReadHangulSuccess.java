package y8강실습;
import java.io.*;

public class FileReadHangulSuccess {
    public static void main(String[] args) {
        try (
            FileInputStream fin = new FileInputStream("//Users//imdabin//Desktop//javaTxt//hangul.txt");
            InputStreamReader in = new InputStreamReader(fin, "UTF-8");
            BufferedReader reader = new BufferedReader(in);
        ) {
            int c;
            System.out.println("인코딩 문자 집합은 " + in.getEncoding());

            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("입출력 오류");
        }
    }
}


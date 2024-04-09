package y8강실습;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class filerevers {
    public static void main(String[] args) {
        try {
            // 입력 파일과 출력 파일의 경로를 설정
            String inputFilePath = "input.txt";
            String outputFilePath = "output.txt";

            // 입력 파일을 읽기 위한 BufferedReader 생성
            BufferedReader input = new BufferedReader(new FileReader(inputFilePath));

            // 출력 파일을 쓰기 위한 PrintWriter 생성
            PrintWriter output = new PrintWriter(new FileWriter(outputFilePath));

            // 파일의 각 줄을 읽어서 리스트에 저장
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }

            // 리스트를 뒤집음
            Collections.reverse(lines);

            // 뒤집힌 리스트의 각 줄을 출력 파일에 쓰기
            for (String reversedLine : lines) {
                output.println(reversedLine);
            }

            // 리소스를 닫음
            input.close();
            output.close();

            System.out.println("File reversed successfully and saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

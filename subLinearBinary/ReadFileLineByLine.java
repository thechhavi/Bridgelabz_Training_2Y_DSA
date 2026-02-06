import java.io.*;

public class ReadFileLineByLine {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
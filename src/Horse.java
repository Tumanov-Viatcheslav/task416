import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Horse {
    public static void main(String[] args) {
        int numberOfChoices = 0;
        String buffer = "";
        List<int[]> results;

        // https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = input.readLine()) != null) {
                buffer += line;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int[] horsemanPositionMatrix = {(int)buffer.charAt(0) - (int)'a', (int)buffer.charAt(1) - (int)'1'};
        Horseman horseman = new Horseman(horsemanPositionMatrix[0], horsemanPositionMatrix[1]);
        results = horseman.eat();

        try(FileWriter output = new FileWriter("output.txt")) {
            for (int[] result: results) {
                output.write((char)(result[0] + (int)'a') + ((char)(result[1] + (int)'1') + "\n"));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

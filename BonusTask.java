import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BonusTask {
    public static void main(String[] args) {
        var fileLines = readFile();
        if (fileLines.size() == 0) {
            System.out.println("File is empty or couldn't read file.");
            return;
        }

        printArray(processList(fileLines));

    }

    public static ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileReader("input.txt"));
            while(in.hasNextLine())
                lines.add(in.nextLine());
            return lines;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<String>();
    }

    public static ArrayList<String> processList(ArrayList<String> lines) {
        ArrayList<String> withNumbers = new ArrayList<String>();
        Pattern numberPattern = Pattern.compile("([1-9][0-9]+)");
        for(String line : lines) {
            if(numberPattern.matcher(line).find()) {
                withNumbers.add(line);
            }
        }
        return withNumbers;
    }

    public static void printArray(ArrayList<String> output) {
        for(String line : output) {
            System.out.println(line);
        }
    }
}
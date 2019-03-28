package workWithFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileWork {

    public static ArrayList<String> readingFile(String pathToFile) {
        ArrayList<String> arr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static void writeToFile(String skuList, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(skuList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The file has been written");
    }

    public static List<String> getFilteredData(ArrayList<String> listOfLines, String regex) {

        ArrayList<String> skuLists = new ArrayList<>();

        Predicate<String> linesFilter = Pattern
                .compile(regex)
                .asPredicate();

        List<String> desiredLines = listOfLines
                .stream()
                .filter(linesFilter)
                .collect(Collectors.toList());

        return desiredLines.stream().map(desiredLine -> desiredLine.substring(0, desiredLine.indexOf(' '))).collect(Collectors.toList());
    }

    public void readSortWriteFile(String inputPath, String outputPath, ArrayList<String> listOfLines, String regex) {
        readingFile(inputPath);
        getFilteredData(listOfLines, regex);
        writeToFile(listOfLines.toString(), outputPath);
    }
}

package workWithFile;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileWork {

    public static ArrayList<String> readingFile(String pathToFile) {
        ArrayList<String> arr = new ArrayList<String>();
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

        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] buffer = skuList.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");
    }

    public static List<String> getFilteredData(ArrayList<String> listOfLines, String regex) {

        ArrayList<String> skuLists = new ArrayList<String>();

        Predicate<String> linesFilter = Pattern
                .compile(regex)
                .asPredicate();

        List<String> desiredLines = listOfLines
                .stream()
                .filter(linesFilter)
                .collect(Collectors.toList());

        for (String s : desiredLines) {
            skuLists.add(s.substring(0, s.indexOf(' '))+"\n");
        }
        return skuLists;
    }

    public void readSortWriteFile(String inputPath, String outputPath, ArrayList<String> listOfLines, String regex){
        readingFile(inputPath);
        getFilteredData(listOfLines,regex);
        writeToFile(listOfLines.toString(),outputPath);
    }
}

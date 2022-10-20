import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.*;

public class WordStatWords {
    public static void main(String[] args) {
        TreeMap<String, Integer> words = new TreeMap<>();
        String word = "";
        try {
            MyScanner reader = new MyScanner(args[0]);
            String line;
            while (reader.hasInput()) {
                line = reader.readString();
                line = line.toLowerCase();
                line += " ";
                int i = 0;
                while (i < line.length()) {
                    while ((Character.isLetter(line.charAt(i))) || (line.charAt(i) == '\'') || (Character.DASH_PUNCTUATION == Character.getType(line.charAt(i))) && !(Character.isWhitespace(line.charAt(i)))) {
                        word += line.charAt(i);
                        i++;
                    }
                    if (!word.isBlank()) {
                        if (!words.containsKey(word)) {
                            words.put(word, 1);
                        } else {
                            int k = words.get(word);
                            k++;
                            words.replace(word, k);
                        }
                    }
                    word = "";
                    i++;
                }
            }
            try (
                    BufferedWriter writter = new BufferedWriter(new FileWriter(args[1]))) {
                for (String j : words.keySet()) {
                    writter.write(j + " " + words.get(j) + "\n");
                }
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
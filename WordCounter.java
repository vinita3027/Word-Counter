import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter File Name : ");
            String s = scanner.next();
            File file = new File(s);
            scanner.close();
            StringBuilder builder = new StringBuilder();
            if (file.exists()) {
                Scanner sc;

                sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    builder.append(sc.nextLine() + "\n");
                }
                sc.close();

                String text = builder.toString();
                System.out.println(text);

                String[] words = text.split("\\s");
                System.out.println("Number of Words : " + words.length);

                frequencyOfWords(words);
                frequencyOfChars(words);
                
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println("\nAverage Word Length : " + df.format(averageWordLength(words)));
            }
            else {
                System.out.println("File not exists");
            }

            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static double averageWordLength(String[] words) {
        int totalChar = 0;
        for (int i = 0; i < words.length; i++) {
            int k = words[i].length();
            totalChar += k;
        }
        System.out.println("\nTotal number of Characters : " + totalChar);
        return (double) totalChar / (words.length);
    }

    private static void frequencyOfWords(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                int k = map.get(words[i]);
                map.put(words[i], ++k);
            } else {
                map.put(words[i], 1);
            }
        }
        System.out.println("\nFrequency of Each Words ... ");
        for (String s : map.keySet()) {
            System.out.println(s + " : " + map.get(s));
        }
    }

    private static void frequencyOfChars(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (map.containsKey(words[i].charAt(j))) {
                    int k = map.get(words[i].charAt(j));
                    map.put(words[i].charAt(j), ++k);
                } else {
                    map.put(words[i].charAt(j), 1);
                }
            }
        }
        System.out.println("\nFrequency of Each Character ... ");
        for (Character c : map.keySet()) {
            System.out.print(c + " : " + map.get(c)+"\n");
        }
    }
}

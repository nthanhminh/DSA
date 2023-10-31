import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập văn bản: ");
        String inputText = scanner.nextLine();
        
        List<String> words = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        
        String[] wordArray = inputText.split("\\s+");

        for (String word : wordArray) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            
            if (word.length() > 0) {
                int index = words.indexOf(word);
                if (index != -1) {
                    int count = counts.get(index);
                    counts.set(index, count + 1);
                } else {
                    words.add(word);
                    counts.add(1);
                }
            }
        }

        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).compareTo(words.get(j)) > 0) {
                    String tempWord = words.get(i);
                    int tempCount = counts.get(i);
                    words.set(i, words.get(j));
                    counts.set(i, counts.get(j));
                    words.set(j, tempWord);
                    counts.set(j, tempCount);
                }
            }
        }
        
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + ": " + counts.get(i));
        }
    }
}

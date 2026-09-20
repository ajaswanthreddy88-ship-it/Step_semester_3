import java.util.*;

class Main {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split into words
        String[] words = cleanedText.trim().split("\\s+");

        // Stop words
        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        HashSet<String> stopWordSet = new HashSet<>();

        for (String word : stopWords) {
            stopWordSet.add(word);
        }

        // Store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWordSet.contains(word)) {
                continue;
            }

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        // Convert HashMap entries to a list
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency descending
        entries.sort(
                (a, b) -> b.getValue() - a.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}

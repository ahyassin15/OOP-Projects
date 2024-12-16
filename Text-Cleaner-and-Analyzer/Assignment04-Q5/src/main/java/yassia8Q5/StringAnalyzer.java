package yassia8Q5;

import java.util.HashMap;
import java.util.Map;

public class StringAnalyzer {
    
    public static void main(String[] args) {

        //Create instance of StringCleaner
        StringCleaner cleaner = new StringCleaner();
        //Create instance of StringAnalyzer
        StringAnalyzer analyzer = new StringAnalyzer();

        //Initialize text example
        String text = "  !This! is. a  ?     STRING!  pUncTuations  LowErCasE Spaces  tEst. ";
        
        //Clean text using StringCleaner
        String cleanedText = cleaner.removeExtraSpaces(cleaner.convertToLowerCase(cleaner.removePunct(text)));
        
        //Word frequency count
        Map<String, Integer> freqMap = analyzer.wordFrequency(cleanedText);
        System.out.println("Word Frequency: " + freqMap);

        //Find longest word in cleaned text
        try {
            String longestWord = analyzer.findLongestWord(cleanedText);
            System.out.println("Longest Word: " + longestWord);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Check if cleaned text is a palindrome
        try {
            boolean isPalindrome = analyzer.isPalindrome(cleanedText);
            System.out.println("Is Palindrome: " + isPalindrome);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Method to calculate frequency of each word in the cleaned string, returning a map
    public Map<String, Integer> wordFrequency(String text) {
        
        //Create new HashMap for storing word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        //If text is null or empty, return an empty map
        if (text == null || text.isEmpty()) {
            return wordCount;
        }

        //Split text into words based on spaces and put them into a String array
        String[] words = text.split("\\s+");

        //For each word in words
        for (String word : words) {
            //Convert to lowercase to count case-insensitively
            word = word.toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //Return the map containing words and their frequencies
        return wordCount;
    }

    //Method to find the longest word in the cleaned string
    public String findLongestWord(String text) {

        //If text is null or empty after trimming spaces, throw an exception
        if (text == null || text.trim().isEmpty()) {
            throw new ArithmeticException("String is empty. Cannot find the longest word.");
        }

        //Split text into words based on spaces and put them into a String array
        String[] words = text.split("\\s+");
        //Initialize empty string to store longest word
        String longestWord = "";

        //For each word in words
        for (String word : words) {

            //If the current word is longer than the longest word, update the longest word
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        //Return longest word
        return longestWord;
    }

    //Method to checks if the cleaned string is a palindrome
    public boolean isPalindrome(String text) {

        //If text is null or empty after trimming spaces, throw an exception
        if (text == null || text.trim().isEmpty()) {
            throw new ArithmeticException("String is empty. Cannot check for palindrome.");
        }

        //Remove all spaces and convert to lowercase for comparing case-insensitively
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();

        // Initialize left and right pointers of cleaned text
        int left = 0;
        int right = cleanedText.length() - 1;

        //Check if the cleaned text reads the same forwards and backwards
        while (left < right) {

            //If the characters don't match at left and right pointers
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                //Return false because it is not a palindrome
                return false;
            }

            //Move pointers respectively for next comparison
            left++;
            right--;
        }

        //If all the characters matched, return true because it is a palindrome
        return true;
    }
}

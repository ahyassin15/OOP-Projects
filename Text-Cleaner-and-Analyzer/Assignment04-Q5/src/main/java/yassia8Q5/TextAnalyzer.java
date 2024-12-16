package yassia8Q5;

import java.util.*;

public class TextAnalyzer extends StringAnalyzer {
    
    public static void main(String[] args) {

        //Create instance of TextAnalyzer
        TextAnalyzer analyzer = new TextAnalyzer();

        //Initialize text example
        String text = "This is the fourth assignment in the course.";

        //Calculate the average word length and most frequent letter from the text
        try {
            Map<String, Object> result = analyzer.wordLenAndLetterFreq(text);
            //Print average word length
            System.out.println("Average Word Length: " + result.get("averageWordLength"));
            //Print most frequent letter
            System.out.println("Most Frequent Letter: " + result.get("mostFrequentLetter"));

        //If an exception occurs, print error message
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Print unique words in alphabetical order
        try {
            Set<String> sortedWords = analyzer.alphabeticalOrder(text);
            System.out.println("Words in Alphabetical Order: " + sortedWords);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }   
    }

    //Method to calculates the average word length and finds the most frequent-occurring letter in a text
    public Map<String, Object> wordLenAndLetterFreq(String text) {

        //If text is null or empty after trimming spaces, throw an exception
        if (text == null || text.trim().isEmpty()) {
            throw new ArithmeticException("String is empty. Cannot calculate average word length or find most frequent letter.");
        }

        //Split text into words based on spaces and put them into a String array
        String[] words = text.split("\\s+");

        //Initialize total word length and word count to 0
        int totalWordLen = 0;
        int wordCount = 0;

        //Count each letter's frequency
        Map<Character, Integer> letterFreq = new HashMap<>();

        //For each word in words
        for (String word : words) {

            //Increment by 1 to the word count
            wordCount++;
            //Add the length of the current word to the total word length
            totalWordLen += word.length();

            //Count the frequency of each letter in the word (case-insensitive by converting each word to lowercase)
            for (char c : word.toLowerCase().toCharArray()) {

                //If the character in the word is a letter, update the letter frequency map (increase count for the current letter)
                //If the letter is not already in the map, default to a count of 0
                if (Character.isLetter(c)) {
                    letterFreq.put(c, letterFreq.getOrDefault(c, 0) + 1);
                }
            }
        }

        //Check if word count is zero to avoid division by zero error
        if (wordCount == 0) {
            throw new ArithmeticException("No valid words found to calculate average word length.");
        }

        //Calculate the average word length
        double avgWordLen = (double) totalWordLen / wordCount;

        //Find most frequent-occurring letter
        char mostFreqLetter = ' '; //Initialize placeholder
        int maxFreq = 0; //Initialize maxFreq to track the highest letter frequency

        //For each character entry and its count in the letterFreq map
        for (Map.Entry<Character, Integer> entry : letterFreq.entrySet()) {
            
            //If the current letter's frequency is greater than the max frequency
            if (entry.getValue() > maxFreq) {
                //Update mostFreqLetter to current letter
                mostFreqLetter = entry.getKey();
                //Update maxFreq to current letter's frequency
                maxFreq = entry.getValue();
            }
        }

        //Create result map to store and return both averageWordLength and mostFreqLetter
        Map<String, Object> result = new HashMap<>();

        //Add avgWordLen and mostFreqLetter to result map
        result.put("averageWordLength", avgWordLen);
        result.put("mostFrequentLetter", mostFreqLetter);

        //Return result map
        return result;
    }

    //Method to print all the words in the text in alphabetical order; duplicate words are only printed once
    public Set<String> alphabeticalOrder(String text) {
        
        //If text is null or empty after trimming spaces, throw an exception
        if (text == null || text.trim().isEmpty()) {
            throw new ArithmeticException("String is empty. Cannot print words in alphabetical order.");
        }
    
        //Use TreeSet to store words in alphabetical order automatically and remove any duplicates
        Set<String> uniqueWords = new TreeSet<>();
    
        //Split text into words based on spaces and put them into a String array
        String[] words = text.split("\\s+");

        //For word in words
        for (String word : words) {
            //Convert each word to lowercase
            uniqueWords.add(word.toLowerCase());
        }
        
        //Return the sorted set of unique words in alphabetical order without duplicates
        return uniqueWords;
    }
}

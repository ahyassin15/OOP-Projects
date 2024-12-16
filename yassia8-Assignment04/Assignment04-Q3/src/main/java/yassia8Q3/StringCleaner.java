package yassia8Q3;

public class StringCleaner {
    
    public static void main(String[] args) {

        //Create new instance of StringCleaner class to use cleaning methods
        StringCleaner cleaner = new StringCleaner();
        //Text example with punctuation characters, multiple spaces, and a mix of capital and lower case letters
        String text = "  !This! is. a  ?     STRING!  pUncTuations  LowErCasE Spaces  tEst. ";

        //Remove punctuation and print text
        String noPunct = cleaner.removePunct(text);
        System.out.println("Without punctuation: " + noPunct);

        //Convert to lowercase and print text
        String lowerCase = cleaner.convertToLowerCase(text);
        System.out.println("Lowercase: " + lowerCase);

        //Remove extra spaces and print text
        String noExtraSpaces = cleaner.removeExtraSpaces(text);
        System.out.println("Without extra spaces: " + noExtraSpaces);

        //All three cleaning methods in one line and print text
        String cleanedText = cleaner.removeExtraSpaces(cleaner.convertToLowerCase(cleaner.removePunct(text)));
        System.out.println("Cleaned text (all tasks in one line): " + cleanedText);

    }

    //Function removes all punctuation characters from string
    public String removePunct(String text) {

        //If text is null, return empty string
        if (text == null) {
            return "";
        }

        //Replace all punctuation characters with an empty string
        return text.replaceAll("[\\p{Punct}]", "");

    }

    //Function converts all characters in string into lowercase letters
    public String convertToLowerCase(String text) {
        
        //If text is null, return empty string
        if (text == null) {
            return "";
        }

        //Convert text to lowercase
        return text.toLowerCase();

    }

    //Function removes leading, trailing, and extra spaces between words
    public String removeExtraSpaces(String text) {
        
        //If text is null, return empty string
        if (text == null) {
            return "";
        }
        
        //Trim and replace multiple spaces with a single space
        return text.trim().replaceAll("\\s{2,}", " ");

    }
}

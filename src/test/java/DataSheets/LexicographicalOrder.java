package DataSheets;

import java.sql.SQLOutput;

class LexicographicalOrder {
    // Method to check if the array of words is sorted in the alien language order
    public boolean isAlienSorted(String[] words, String order) {
        // Create a mapping of characters to their positions in the alien language alphabet
        char[] map = new char[26]; // e.g. order = "bca" -> map = ['c', 'a', 'b']

        // Populate the mapping array
        for (int i = 0; i < 26; ++i) {
            map[order.charAt(i) - 'a'] = (char) (i + 'a');
        }
        // Iterate through the words array to check if each pair is in sorted order
        for (int i = 0; i + 1 < words.length; ++i)
            if (bigger(words[i], words[i + 1], map)) // If not in order, return false
                return false;

        // If all pairs are in order, return true
        return true;
    }

    // Helper method to compare two words based on the alien language order
    private boolean bigger(final String s1, final String s2, final char[] map) {
        // Iterate through the characters of the two words
        for (int i = 0; i < s1.length() && i < s2.length(); ++i)
            // If characters are different, compare their positions in the mapping
            if (s1.charAt(i) != s2.charAt(i))//hello leetcode
            {
                System.out.println(map[s1.charAt(i) - 'a']);
                System.out.println(map[s2.charAt(i) - 'a']);
                System.out.println(map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a']);
                return map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a']; // Compare positions
            }
        // If one word is a prefix of the other, the longer word is considered greater
        return s1.length() > s2.length(); // Return true if s1 is longer
    }

    public static void main(String[] args) {
        LexicographicalOrder solution = new LexicographicalOrder();

        // Example usage
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean result = solution.isAlienSorted(words, order);
        System.out.println("Words are sorted in alien language order: " + result);
    }
}

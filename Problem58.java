/* 1832. Check if the Sentence Is Pangram
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

 

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters. */


class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26]; // Array to track if each letter is seen
        
        // Iterate through the sentence
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            // If the character is a lowercase letter, mark it as seen
            if (ch >= 'a' && ch <= 'z') {
                seen[ch - 'a'] = true;
            }
        }
        
        // Check if all 26 letters are seen
        for (boolean letter : seen) {
            if (!letter) {
                return false; // If any letter is not seen, return false
            }
        }
        
        return true; // All letters are seen, return true
    }
}

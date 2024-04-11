/* 2325. Decode the Message
You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:

Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
Align the substitution table with the regular English alphabet.
Each letter in message is then substituted using the table.
Spaces ' ' are transformed to themselves.
For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
Return the decoded message.

solution is - */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String decodeMessage(String key, String message) {
        // Step 1: Construct the substitution table
        Map<Character, Character> substitutionTable = new HashMap<>();
        int idx = 0;
        for (char ch : key.toCharArray()) {
            if (ch != ' ' && !substitutionTable.containsKey(ch)) {
                substitutionTable.put(ch, (char) ('a' + idx));
                idx++;
            }
        }
        
        StringBuilder decodedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                decodedMessage.append(ch);
            } else if (substitutionTable.containsKey(ch)) {
                decodedMessage.append(substitutionTable.get(ch));
            }
        }
        
        return decodedMessage.toString();
    }
}
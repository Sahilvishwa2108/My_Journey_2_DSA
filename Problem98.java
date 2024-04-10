/* 557. Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space. */

class Solution {
    public String reverseWords(String s) {
        String[] temp = s.split("\\s");
        StringBuilder[] words = new StringBuilder[temp.length];

        for(int i=0; i<words.length; i++){
            words[i] = new StringBuilder(temp[i]);
        }
        for(int i=0; i<words.length; i++){
            words[i].reverse();
        }
        String reversed = "";
        for(int i=0; i<words.length; i++){
            reversed = reversed + words[i].toString() + " ";
        }
        
        return reversed.trim();
    }
}
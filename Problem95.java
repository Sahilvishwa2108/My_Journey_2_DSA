/* 1249. Minimum Remove to Make Valid Parentheses
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.



solution is - */
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        // Iterate through the string to remove unnecessary parentheses
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i); // Push the index of '(' onto the stack
            } else if (chars[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop the index of the matching '('
                } else {
                    chars[i] = ' '; // Remove the ')' by setting it to an empty character
                }
            }
        }
        
        // Iterate through the stack and remove unmatched opening parentheses
        while (!stack.isEmpty()) {
            chars[stack.pop()] = ' '; // Remove the unmatched '('
        }
        
        // Construct and return the resulting string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') {
                result.append(c);
            }
        }
        return result.toString();
    }
}
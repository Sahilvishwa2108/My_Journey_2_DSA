/* 1678. Goal Parser Interpretation
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

 

Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"
Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 

Constraints:

1 <= command.length <= 100
command consists of "G", "()", and/or "(al)" in some order.



solution is - */
class Solution {
    public String interpret(String command) {
        StringBuilder interpreted = new StringBuilder();
        
        for (int i = 0; i < command.length(); i++) {
            char current = command.charAt(i);
            
            if (current == 'G') {
                interpreted.append('G');
            } else if (current == '(') {
                char next = command.charAt(i + 1);
                if (next == ')') {
                    interpreted.append('o');
                    i++;
                } else if (next == 'a' && command.charAt(i + 2) == 'l') {
                    interpreted.append("al");
                    i += 2;
                }
            }
        }
        
        return interpreted.toString();
    }
}
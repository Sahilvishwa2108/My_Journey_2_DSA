/* 387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 10^5
s consists of only lowercase English letters.
 */




class Solution {
    public int firstUniqChar(String s) {
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            boolean Unique = true;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(j) == s.charAt(i)) {
                    Unique = false;
                    break;
                }
            }
            if (Unique) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}



/*  Qu.  Reverse Integer
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 
Constraints:
-231 <= x <= 231 - 1
 */



class Problem3 {
    public int reverse(int x) {
        try {
            boolean isNegative = x < 0;
            String str = Integer.toString(x);
            StringBuilder num = new StringBuilder(isNegative ? str.substring(1) : str);
            double reversed = Double.parseDouble(num.reverse().toString());

            // Check for overflow
            if (reversed >= Integer.MIN_VALUE && reversed <= Integer.MAX_VALUE) {
                return isNegative ? (int) -reversed : (int) reversed;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}

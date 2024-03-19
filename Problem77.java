/* 60. Permutation Sequence
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!


solution is - */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        for (int i = 1; i <= n; i++) {
            factorial /= (n - i + 1);
            int index = k / factorial;
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial;
        }
        return sb.toString();
    }
}


package in.algo.dynamicProgramming;

public class MobileNumericPath {

/*

* There is a standard numeric keypad on a mobile phone.
* You can only press the current button or buttons that are directly up,
* left, right, or down from it (for ex if you press 5,
* then pressing 2, 4, 6 & 8 are allowed). Diagonal movements
* and pressing the bottom row corner buttons (* and #) are prohibited.

Key pad :
     1  2  3
     4  5  6
     7  8  9
     *  0  #

Given a number n, find the number of possible unique sequences
* of length n that you can create by pressing buttons.
* You can start from any digit.

Examples

Input: n = 1
Output: 10
Explanation: Number of possible numbers are 10 (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
Input: n = 2
Output: 36

Explanation: Possible numbers: 00, 08, 11, 12, 14, 22, 21, 23, 25 and so on.

* If we start with 0, valid numbers will be 00, 08 (count: 2).
* If we start with 1, valid numbers will be 11, 12, 14 (count: 3).
* If we start with 2, valid numbers  will be 22, 21, 23,25 (count: 4).
* If we start with 3, valid numbers will be 33, 32, 36 (count: 3).
* If we start with 4, valid numbers will be 44,41,45,47 (count: 4).
* If we start with 5, valid numbers will be 55,54,52,56,58 (count: 5) and so on.
*

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

* */

    public static void main(String[] args) {
        System.out.println(getCount(4));
    }

    private static long getCountUtil(char[][] keypad, int n) {
        if (keypad == null || n <= 0) return 0;
        if (n == 1) return 10;

        // left, up, right, down move from current location
        int[] row = {0, 0, -1, 0, 1};
        int[] col = {0, -1, 0, 1, 0};

        // taking n+1 for simplicity - count[i][j] will store
        // number count starting with digit i and length j
        long[][] count = new long[10][n + 1];
        int i = 0, j = 0, k = 0, move = 0, ro = 0, co = 0, num = 0;
        long nextNum = 0, totalCount = 0;

        // count numbers starting with digit i and of lengths 0 and 1
        for (i = 0; i <= 9; i++) {
            count[i][0] = 0;
            count[i][1] = 1;
        }
        // Bottom up - Get number count of length 2, 3, 4, ... , n
        for (k = 2; k <= n; k++) {
            for (i = 0; i < 4; i++) {     // Loop on keypad row
                for (j = 0; j < 3; j++) { // Loop on keypad column
                    // Process for 0 to 9 digits
                    if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                        // Here we are counting the numbers starting with
                        // digit keypad[i][j] and of length k keypad[i][j]
                        // will become 1st digit, and we need to look for
                        // (k-1) more digits
                        num = keypad[i][j] - '0';
                        count[num][k] = 0;

                        // move left, up, right, down from current location
                        // and if new location is valid, then get number
                        // count of length (k-1) from that new digit and
                        // add in count we found so far
                        for (move = 0; move < 5; move++) {
                            ro = i + row[move];
                            co = j + col[move];
                            if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2 &&
                                    keypad[ro][co] != '*' && keypad[ro][co] != '#') {
                                nextNum = keypad[ro][co] - '0';
                                count[num][k] += count[(int)nextNum][k - 1];
                            }
                        }
                    }
                }
            }
        }
        // Get count of all possible numbers of length "n" starting
        // with digit 0, 1, 2, ..., 9
        totalCount = 0;
        for (i = 0; i <= 9; i++) totalCount += count[i][n];
        return totalCount;
    }

    public static long getCount(int n) {
        char[][] keypad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}};

        return getCountUtil(keypad, n);
    }
}

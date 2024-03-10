package in.algo;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
*
* Given a string str which may contain lowercase and uppercase characters.
* The task is to remove all duplicate characters from the string and find the resultant string.
* The order of remaining characters in the output should be same as in the original string.

Example 1:

Input:
str = "geEksforGEeks"
Output:
"geEksforG"
Explanation:
After removing duplicate characters such as E, e, k, s, we have string as "geEksforG".
Example 2:

Input:
str = "HaPpyNewYear"
Output:
"HaPpyNewYr"
Explanation:
After removing duplicate characters such as e, a, we have string as "HaPpyNewYr".
* */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("GeekEsFoF"));
    }

    static String removeDuplicates(String str) {
        StringBuilder x=new StringBuilder();
        str.chars()
                .distinct()
                .forEach(i -> x.append((char) i));
        return x.toString();
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        char a = 'a';
        char z = 'z';
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();
        int[] x = new int[26];

        for(int i =0; i < first.length(); i++){
            x[firstChar[i]-'a'] += 1;
        }

        for(int i =0; i < second.length(); i++){
            x[secondChar[i]-'a'] -= 1;
        }

        int p = 0;
        for (int s =0; s < x.length; s++){
            p += Math.abs(x[s]);
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));

    }

}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        if(expression.length()%2 != 0){
            return false;
        }
        char[] expressionArray = expression.toCharArray();
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (char c : expressionArray) {
            arrayList.add(c);
        }

        int[] cantidad = new int[6];
        for(int i = 0; i< arrayList.size(); i++) {
        	if(arrayList.get(i)=='{') { cantidad[0] ++;}
        	else if(arrayList.get(i)=='}') { cantidad[1] ++;}
        	else if(arrayList.get(i)=='(') { cantidad[2] ++;}
        	else if(arrayList.get(i)==')') { cantidad[3] ++;}
        	else if(arrayList.get(i)=='[') { cantidad[4] ++;}
        	else if(arrayList.get(i)==']') { cantidad[5] ++;}
        }

        if(cantidad[0] != cantidad[1]) {
        	return false;
        }
        if(cantidad[2] != cantidad[3]) {
        	return false;
        }
        if(cantidad[4] != cantidad[5]) {
        	return false;
        }

        //System.out.println(arrayList.size());
        while(arrayList.size()>0){
            for(int i = 0; i<arrayList.size()-1; i++){
                //System.out.println(arrayList.get(i));

                if(arrayList.get(i)==')' || arrayList.get(i)==']' || arrayList.get(i)=='}'){
                    return false;
                }
                else if(arrayList.get(i)=='{' && arrayList.get(i+1)=='}'){
                    arrayList.remove(i+1);
                    arrayList.remove(i);
                     i= ((i==0)? -1 : i-2);
                    continue;
                }
                else if(arrayList.get(i)=='(' && arrayList.get(i+1)==')'){
                    arrayList.remove(i+1);
                    arrayList.remove(i);
                    i= ((i==0)? -1 : i-2);
                    continue;
                }
                else if(arrayList.get(i)=='[' && arrayList.get(i+1)==']'){
                    arrayList.remove(i+1);
                    arrayList.remove(i);
                    i= ((i==0)? -1 : i-2);
                    continue;
                }
            }
            if(arrayList.size()%2 != 0){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}

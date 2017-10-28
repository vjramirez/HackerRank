import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        String salida = "No";

        ArrayList<String> ramsonList = new ArrayList<String>(Arrays.asList(ransom));
        ArrayList<String> magazineList = new ArrayList<String>(Arrays.asList(magazine));


        for(int i = 0; i < ramsonList.size(); i++){
            salida = "No";
            for (int y = 0; y < magazineList.size(); y++){
                if(ramsonList.get(i).equals(magazineList.get(y))){
                    salida="Yes";
                    magazineList.remove(y);
                    break;
                }
            }
            if (salida.equals("No")) break;
        }

        System.out.println(salida);

    }
}

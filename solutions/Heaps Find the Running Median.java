import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(a[0]);
        System.out.println((float) a[0]);
        int cantidad =0;
        for(int i = 1; i < n; i++){
            int z = set.size();

            //Naive Approach
            /*for(int y = 0; y < set.size(); y++){
                cantidad ++;
                if(a[i] <= set.get(y)){
                    z = y;
                    break;
                }
            }*/
            //End Naive Approach

            //Searching Algorithm (Only 5.27% of Naive Approach interactions)
            int min = 0;
            int max = z-1;
            int med = (min+max)/2;

            while(true){
                if(a[i] <= set.get(min)){
                    z = min;
                    break;
                }
                if(a[i] >= set.get(max)){
                    z = max+1;
                    break;
                }
                if(a[i] <= set.get(med)){
                    if(a[i] >= set.get(med-1)){
                        z = med;
                        break;
                    }
                    max = med;
                    med = (min+max)/2;
                }
                else{
                    if(a[i] >= set.get(max-1)){
                        z = max;
                        break;
                    }
                    min = med+1;
                    med = (min+max)/2;
                }

            }
            //End Searching Algorithm

            set.add(z,a[i]);
            int res = set.size() % 2;
            int div = set.size() / 2;
            if(res == 0){
                System.out.println((float)(set.get(div-1)+ set.get(div))/2);
            }
            else{
                System.out.println((float) set.get(div));
            }
        }
    }
}

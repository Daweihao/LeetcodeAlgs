//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int types[] = new int[n];
//        int i =0;
//        while (i < n) {
//            types[i] = sc.nextInt();
//            i++;
//        }
//        Arrays.sort(types);
//
//        int mincounts = 0;
//        for(int k = 1; k <= m; k++){
//            int counts = 0;
//            int number = k;
//            for (int j = n-1; j >=0 ; j--) {
//                while(number >= types[j]){
//                    number -= types[j];
//                    counts++;
//                }
//            }
//            mincounts = mincounts > counts ? mincounts:counts;
//            System.out.println(mincounts);
//        }
//
//
//    }
//}

import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        System.out.println(1/2);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String input = sc.nextLine();
//        char[] chars =  input.toCharArray();
//        int[] arrs = new int[n];
//        for(int i =0; i < n; i++){
//            arrs[i] = chars[i] - '0';
//            System.out.println(arrs[i]);
//        }
//        int j = 0;
//        for (int i = 0; i <n && i >= 0 && j<n ; ) {
//            j = i + 1;
//            if (arrs[i] != arrs[j]) {
//                j++;
//                i--;
//            }
//
//
//        }
    }
}
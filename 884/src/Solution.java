import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Solution{

    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public List<String> missingWords(String s, String t) {
        // Write your code here
        String[] larger = s.split(" ");
        List<String> result = new ArrayList<>();
        if(t.length() == 0 || t == null || t == " "){
            for(String word: larger){
                result.add(word);
            }
            return result;
        }
        // String[] larger = s.split(" ");
        String[] less = t.split(" ");
        // List<String> result = new ArrayList<>();
        // Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(true){
            if(i >= larger.length){
                return result;
            }else if (j >= less.length){
                while(i < larger.length){
                    result.add(larger[i]);
                    i++;
                }
                return result;
            }
            System.out.println(less[j].equals(larger[i]));
            if(!less[j].equals(larger[i])){
                result.add(larger[i]);
                i++;
            }else {
                j++;
                i++;
            }
        }

        // for(String word : larger){
        //     if(map.get(word) == 1){
        //         map.
        //         result.add(word);
        //     }
        // }

        // return result;
    }

}


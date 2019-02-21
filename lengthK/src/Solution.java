import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // Write your code here
        HashMap<Character, Integer> window = new HashMap<>();
        HashSet<String> unique = new HashSet<String>();
        if(stringIn == null || K <=0) return 0;
        int counts = 0;
        int cursor = 0;
        int pioneer = cursor + 1;
        while(true){
            if(cursor >= stringIn.length() - K +1 || pioneer > stringIn.length()){
                return unique.size();
            }
            if (!window.containsKey(stringIn.charAt(cursor))) {
                window.put(stringIn.charAt(cursor),cursor);
            }
            if(pioneer - cursor < K){
                if(window.containsKey(stringIn.charAt(pioneer))){
                    if(cursor < window.get(stringIn.charAt(pioneer))){
                        cursor = window.get(stringIn.charAt(pioneer)) + 1;
                    }else cursor++;
                    window.put(stringIn.charAt(pioneer),pioneer);
                    pioneer++;

                }else{
                    window.put(stringIn.charAt(pioneer),pioneer);
                    pioneer++;
                }
            }else {
                window.remove(stringIn.charAt(cursor));
                unique.add(stringIn.substring(cursor,pioneer));
                cursor++;

            }

        }

    }
}
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    //brute force version
//    public int lengthOfLongestSubstring(String s) {
//
//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                if (allUnique(s,i,j)){
//                    ans = Math.max(j-i,ans);
//                }
//
//            }
//        }
//        return ans;
//    }
//    public boolean allUnique(String s, int i, int j){
//        Set<Character> set = new HashSet<>();
//        for (int k = i; k < j; k++) {
//            Character c = s.charAt(k);
//            if (set.contains(c)) return false;
//            set.add(c);
//        }
//        return true;
//    }
    // slide window optimized version  Hashmap
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int ans = 0;
//        HashMap<Character,Integer> longest = new HashMap();
//        for (int i = 0, j =0; j < n; j++) {
//            if (longest.containsKey(s.charAt(j))){
//                i = Math.max(i,longest.get(s.charAt(j)));
//            }
//            ans = Math.max(ans,j - i + 1);
//            longest.put(s.charAt(j),j+1);
//        }
//
//        return ans;
//    }
    // slide window HashSet version
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < n & i < n;) {
            if (set.contains(s.charAt(j))){
            set.remove(s.charAt(i++));
            }else {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}

public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() ==0)
            return 0;
        String[] stones = S.split("");
        int counts = 0;
        for (int i=0; i < S.length(); i++){
            if (J.contains(stones[i])){
                counts++;
            }
        }
        return counts;
    }
}

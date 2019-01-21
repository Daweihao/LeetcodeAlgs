public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() ==0)
            return 0;
        int counts = 0;
        for (int i = 0; i < S.length(); i++){
            if (J.indexOf(S.charAt(i)) > -1){
                counts++;
            }
        }
        return counts;

    }
}

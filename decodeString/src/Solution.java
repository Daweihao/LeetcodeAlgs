import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        int stack = 0, start = -1, end = -1, num = 0;
        // first rount add annotation for start and end. Solving it in recursive way.
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '['){
                if (start == -1)
                    start = i;
                stack++;
            }else if (c == ']'){
                if (--stack == 0){
                    end = i;
                    break;
                }
            }
        }
        if (start == -1)
            return s;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < start ; i++) {
           char c = s.charAt(i);
           if (c >= '0' && c <= '9'){
               num = num * 10 + c - '0';
           }else res.append(c);
        }
        String str = decodeString(s.substring(start + 1, end));
        for (int i = 0; i < num ; i++) {
            res.append(str);
        }
        res.append(decodeString(s.substring(end + 1)));
        return res.toString();
    }
}
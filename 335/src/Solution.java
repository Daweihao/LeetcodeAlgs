class Solution {
    public int[] lt;
    public int[] rt;
    public int[] lb;
    public int[] rb;


    public boolean isSelfCrossing(int[] x) {
        if(x.length < 4)
            return false;
        boolean result = false;
        rt = new int[]{0,x[0]};
        lt = new int[]{0 - x[1], rt[1]};
        lb = new int[]{lt[0],lt[1] - x[2]};
        rb = new int[]{lb[0] + x[3], lb[1]};
        if(rb[0] >= 0 && rb[1] >=0)
            return true;
        else result = false;
        int[] oldrb = {0,0};
        int[] oldlt = new int[2];
        for (int i = 4; i < x.length  ;i++){
            if(i % 4 == 0){
                if((rb[0] < rt[0] && rb[1] + x[i] >= rt[1])|| (rb[0] == rt[0] && rb[1] + x[i] >= oldrb[1])){
                    return true;
                }
                else{
                    rt[0] = rb[0];
                    rt[1] = rb[0] + x[i];
                }
            }
            if(i % 4 == 1){
                if(rt[1] > lt[1] || rt[1] > oldrb[1] && rt[0] - x[i] > oldrb[0]  ||rt[0] - x[i] > lt[0] ){
                    oldlt = lt.clone();
                    lt[1] = rt[1];
                    lt[0] = rt[0] - x[i];
                }else return true;
            }
            if(i % 4 == 2){
                if(lt[0] < lb[0] || lt[1] - x[i] > lb[1]){
                    lb[0] = lt[0];
                    lb[1] = lt[1] - x[i];
                }else return true;
            }
            if(i % 4 == 3){
                if(lb[1] < rb[1] || lb[0] + x[i] < lt[0]){
                    oldrb = rb.clone();
                    rb[0] = lb[0] + x[i];
                    rb[1] = lb[1];
                }else return true;
            }
        }

        return result;
    }
}


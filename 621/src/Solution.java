import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        Computing idle slots in the previous duration.
         */
        int[] map = new int[26];
        for(char c: tasks)
            map[c-'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1;
        int idle_slots = max_val * n;
        for(int i =24; i >=0 && map[i] >0; i--){
            idle_slots -= Math.min(map[i],max_val);
        }
        return idle_slots > 0? tasks.length + idle_slots : tasks.length;
//        int map[] = new int[26];
//        for (char c : tasks)
//            map[c-'A']++;
//
//        // sort the tasks in the descending order
//        int times = 0;
//        Arrays.sort(map);
//        while(map[25] > 0){
//            int i =0;
//            while (i<=n){
//                if(map[25] == 0)
//                    break;
//                if(i< 26 && map[25-i] > 0){
//                    map[25-i]--;
//                    times++;
//                }
//                i++;
//
//            }
//            Arrays.sort(map);
//        }
//        return times;

        /*
        Another approach using priority queue
         */
//        int[] map = new int[26];
//        for(char c: tasks){
//            map[c-'A']++;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(26,Collections.reverseOrder());
//        for(int f : map){
//            if(f > 0)
//                queue.add(f);
//        }
//        int times = 0;
//        while(!queue.isEmpty()){
//            List<Integer> temp = new ArrayList<>();
//            int i = 0;
//            while(i <=n){
//                if(!queue.isEmpty()){
//                    if(queue.peek() > 1)
//                        temp.add(queue.poll() -1);
//                    else
//                        // 0 doesn't has to be put into temp
//                        queue.poll();
//                }
//                times++;
//                if(queue.isEmpty() && temp.size() ==0)
//                    break;
//                i++;
//            }
//            for(int l : temp)
//                queue.add(l);
//        }
//        return times;

    }
}
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



class Result {

    /*
     * Complete the 'primeQuery' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY first
     *  3. INTEGER_ARRAY second
     *  4. INTEGER_ARRAY valuesprivate static int getPrimes(int node){
        int index = node-1;
        if (results.get(index) != null)
            return results.get(index);
        int primesCount = 0;

        for(int child : childList.get(node)){
            if (checkPrime(values_total.get(child -1)))
                primesCount++;
        }
        if(checkPrime(values_total.get(index)))
            primesCount++;

        results.add(index,primesCount);
        return primesCount;
    }

     *  5. INTEGER_ARRAY queries
     */

    private static List<List<Integer>> childList;
    private static List<List<Integer>> adjList;
    private static Map<Integer,Integer> results;
    private static List<Integer> values_total;

    private static boolean checkPrime (int num){
        if(num == 2 || num ==3 || num == 5 ) return true;
        if(num ==1 || num %2 ==0) return false;
        for(int i = 3; i*i <= num;i += 2){
            if(num % i == 0) return false;
        }
        return true;
    }



    public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        // Write your code here
        int edges = first.size();
        List<Integer> output = new ArrayList<>();
        values_total = new ArrayList<>(values);
        init();
        // initialization
        for(int j = 1; j <= n; j++){
            adjList.add(j,new ArrayList<>());
            childList.add(j,new ArrayList<>());
        }
        // add edges to each node
        for(int i = 0; i< edges; i++){
            int x = first.get(i);
            int y = second.get(i);
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        // setup parameters for childlist
        bfs(n);

        for (int i = 1; i <=n; i++) {
           int count = getPrimes(i);
           results.put(i,count);
        }

        for (Integer query : queries){
            int result = results.get(query);
            output.add(result);

        }

        return output;

    }

    private static int getPrimes(int node){
        if (results.size()!= 0 && results.get(node) != null)
            return results.get(node);
        int primesCount = 0;

        for(int child : childList.get(node)){
//            if (checkPrime(values_total.get(child -1)))
//                primesCount++;
            primesCount += getPrimes(child);
        }

        if(checkPrime(values_total.get(node -1)))
            primesCount++;

        return primesCount;
    }


    private static void init(){
        adjList = new ArrayList<>();
        adjList.add(0,null);
        childList = new ArrayList<>();
        childList.add(0, null);
        results = new HashMap<>();

    }

    private static void bfs(int nodes){
        Map<Integer,Boolean> visited = new HashMap<>();
        for (int i = 1; i <= nodes ; i++) {
            visited.put(i,false);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited.replace(1,true);
        while (queue.size()!=0){
            int u = queue.poll();
            for (int v : adjList.get(u)){
                if (!visited.get(v)){
                    queue.add(v);
                    visited.replace(v,true);
                    childList.get(u).add(v);
                }
            }
        }

    }

}



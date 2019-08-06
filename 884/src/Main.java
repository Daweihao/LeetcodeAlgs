import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<String> result = new Solution().missingWords("I think you think could be ", "I think");
        for (int i = 0; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
//        System.out.println(result);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] input = {"(((())))","[][][][]"};
        String[] result = new Solution().braces(input);

        for (int i = 0; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}

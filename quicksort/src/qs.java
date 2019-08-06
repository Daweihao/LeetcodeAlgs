public class qs {
    public static void main(String[] args) {
        int[] nums = {3,12,0,4,4};
        quicksort(nums, 0, 4);
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void quicksort(int[] nums, int left, int right){
       if (left < right){
           int pos = partition(nums, left, right);
           quicksort(nums, left, pos - 1);
           quicksort(nums, pos + 1, right);
       }
    }

    private static int partition(int[] arrs, int start, int end) {
        int randIndex = start + ((int) (Math.random() * (end - start + 1)));
        swap(arrs, start, randIndex);
       int j = start + 1;
       int pivot = arrs[start];
        for (int i = start + 1; i <= end ; i++) {
           if (arrs[i] < pivot){
               swap(arrs, i, j);
               j++;
           }
        }
        swap(arrs, start, j - 1);
        return j - 1;
    }

    private static void swap(int[] arrs, int a, int b) {
        int temp = arrs[a];
        arrs[a] = arrs[b];
        arrs[b] = temp;
    }
}

class Solution {
    private double ans = 0.0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1)
            findInOdd(nums1,nums2,m,n);
        else
            findInEven(nums1,nums2,m,n);
        return ans;
    }
    private void findInOdd(int[] a1, int[] a2, int m, int n){
        int medianIndex = ((int) Math.ceil((m + n) / 2.0));
        int cursor = 0;
        //extreme cases
        if (m == 0){
            ans = a2[medianIndex - 1];
            return;
        }
        if (n == 0){
            ans = a1[medianIndex - 1];
            return;
        }
//        // no overlapping cases
//        if (m > 0 && a1[m-1] < a2[0])
//            ans = m < medianIndex? a2[medianIndex - m - 1]:a1[medianIndex - 1];
//        if (n > 0 && a2[n-1] < a1[0])
//            ans = n < medianIndex? a1[medianIndex - n - 1]:a2[medianIndex - 1];
        // overlap
        int i = 0,j = 0;
        while (true){
            if (j >= n || i < m && a1[i] <= a2[j]){
                if (cursor++ == medianIndex - 1) {
                    ans = a1[i];
                    return;
                }
                i++;
            }else {
                if (cursor++ == medianIndex - 1){
                    ans = a2[j];
                    return;
                }
                j++;
            }

        }

    }
    private void findInEven(int[] a1, int[] a2, int m, int n){
        int left = (m + n) / 2;
        int right = left + 1;
        double lv = 0.0;
        double rv = 0.0;
        int cursor = 0;
        //extreme cases
        if (m == 0){
            lv = a2[left - 1];
            rv = a2[right - 1];
            ans = (lv + rv)/2.0;
            return;
        }
        if (n == 0){
            lv = a1[left - 1];
            rv = a1[right - 1];
            ans = (lv + rv)/2.0;
            return;
        }
//        if (m > 0 && a1[m-1] < a2[0]){
//            if (right <= m){
//                ans = (a1[left-1] + a1[right-1])/2.0;
//            }else if (left > m){
//                ans = (a2[left - m - 1]+a2[right-m-1])/2.0;
//            }else ans = (a1[m-1] + a2[0])/2.0;
//            return;
//        }
//        if (n >0 && a2[n-1] < a1[0]){
//            if (right <= n){
//                ans = (a2[left-1] + a2[right-1])/2.0;
//            }else if (left > n){
//                ans = (a1[left - n - 1]+a1[right-n-1])/2.0;
//            }else ans = (a2[n-1] + a1[0])/2.0;
//            return;
//        }
        int i = 0, j = 0;
        while (true){
            if (j >= n || i < m && a1[i] <= a2[j]){
                if (++cursor == left){
                    lv = a1[i];
                }else if (cursor == right){
                    rv = a1[i];
                    ans = (lv + rv)/2.0;
                    return;
                }
                i++;
            }else {
                if (++cursor == left){
                    lv = a2[j];
                }else if (cursor == right){
                    rv = a2[j];
                    ans = (lv + rv)/2.0;
                    return;
                }
                j++;
            }
        }
    }
}
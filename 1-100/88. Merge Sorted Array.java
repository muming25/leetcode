class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        if (m == 0) {
            nums1[0] = nums2[0];
            i++;
            m++;
        }
        for (; i<n; i++) {
            int j=m;
            for (; j>0; j--) {
                if (nums2[i] < nums1[j-1]) {
                    nums1[j] = nums1[j-1];
                }
                else {
                    break;
                }
            }
            nums1[j] = nums2[i];
            m++;
        }
    }
}
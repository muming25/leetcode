class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int target = (nums1.length+nums2.length)/2;
        boolean flag = (nums1.length+nums2.length)%2 == 1;
        int index1=0, index2=0;
        int totalindex = 0;
        int first=0;
        
        if(nums1.length==0){
            nums1 = new int[1];
            nums1[0]=Integer.MAX_VALUE;
        }
        if(nums2.length==0){
            nums2 = new int[1];
            nums2[0]=Integer.MAX_VALUE;
        }
        
        while(totalindex < target){
            if(nums1[index1] <= nums2[index2] ){
                if(totalindex + 1 == target){
                    first = nums1[index1];
                }
                if(index1+1 < nums1.length){
                    index1++;
                }else{
                    nums1[index1]=Integer.MAX_VALUE;
                }
            }
            else{
                if(totalindex + 1 == target){
                    first = nums2[index2];
                }
                if(index2+1 < nums2.length){
                    index2++;
                }else{
                    nums2[index2]=Integer.MAX_VALUE;
                }
            }
            totalindex++;
        }
        if(flag){
            if(nums1[index1] <= nums2[index2] ){
                return nums1[index1];
            }else{
                return nums2[index2];
            }
        }else{
            if(nums1[index1] <= nums2[index2] ){
                return (double)((first + nums1[index1])/2.0);
            }else{
                return (double)((first + nums2[index2])/2.0);
            }
        }
    }
}
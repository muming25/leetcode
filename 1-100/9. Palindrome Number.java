class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        char[] input = String.valueOf(x).toCharArray();
        int start=0, end=0;
        if(input.length%2 == 0){
            start = input.length/2-1;
            end = input.length/2;
        }else{
            start = input.length/2;
            end = input.length/2;
        }
        while(true){
            if((start < 0) || 
               (end >= input.length) || 
               (input[start]!=input[end])){
                start++;end--;
                break;
            }
            start--;
            end++;
        }
        return end - start >= input.length - 1;
    }
}
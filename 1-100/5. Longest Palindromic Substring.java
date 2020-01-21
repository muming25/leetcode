class Solution {
    private int top=0, tail=0;
    private int maxlen = 0;
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        char[] input = s.toCharArray();
        for(int i=0;i<s.length();i++){
            maxPalindromic(input, i, i+1);
            maxPalindromic(input, i, i);
        }
        return s.substring(top,tail+1);
    }
    
    public void maxPalindromic(char[] input, int start, int end){
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
        if(end - start > maxlen){
            maxlen = end - start;
            top = start;
            tail = end;
        }
    }
}
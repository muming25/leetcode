class Solution {
    public int lengthOfLongestSubstring(String s) {
        int output = 0;
        int top = 0, tail = 0;
        int offset = 0;
        boolean[] flag = new boolean [500];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index=c;
            if(flag[index]){
                while(s.charAt(top)!=c){
                    int indextop = s.charAt(top);
                    flag[indextop] = false;
                    top++;
                }
                top++;
                offset = 1;
            }else{
                flag[index] = true;
            }
            tail++;
            if(tail - top  > output){
                output = tail - top ;
            }
        }
        return output;
    }
}
class Solution {
    private final static int STATE_UNKNOWN = 0;
    private final static int STATE_VALID = 1;
    private final static int STATE_INVALID = -1;
    public int longestValidParentheses(String s) {
        int[] table = new int[s.length()];
        int leftcount = 0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                leftcount++;
            }else{
                if(leftcount > 0){
                    leftcount--;
                    table[i] = STATE_VALID;
                    for(int j=i;j>=0;j--){
                        if(table[j] == STATE_UNKNOWN){
                            table[j] = STATE_VALID;
                            break;
                        }
                    }
                }else{
                    leftcount = 0;
                    table[i] = STATE_INVALID;
                }
            }
        }
        int max = 0;
        int current = 0;
        for (int i=0;i<s.length();i++){
            if(table[i] == STATE_VALID){
                current++;
            }else{
                if(max < current){
                    max = current;
                }
                current = 0;
            }
        }
        if(max < current){
            max = current;
        }
        return max;
    }
}
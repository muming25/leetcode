class Solution {
    public boolean isValid(String s) {
        boolean ret = true;
        String stack = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack = stack + s.charAt(i);
            }else{
                if(stack.length() == 0){
                    ret = false;
                    break;
                }
                else if((stack.charAt(stack.length()-1) == '(' && s.charAt(i)==')')||
                        (stack.charAt(stack.length()-1) == '{' && s.charAt(i)=='}')||
                        (stack.charAt(stack.length()-1) == '[' && s.charAt(i)==']')){
                    stack = stack.substring(0, stack.length()-1);
                }
                else {
                    ret = false;
                    break;
                }
            }
        }
        return ret && stack.length() == 0;
    }
}
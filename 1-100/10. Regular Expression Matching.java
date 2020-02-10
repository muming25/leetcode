class Solution {
    boolean ret = false;
    public void checkMatch(String s, String p){
        if(ret)return;
        if(s.equals("") && p.equals("")){
            ret = true;
        }
        else if(p.equals("")){
            return;
        }
        else if(p.length() >= 2 && p.charAt(1) == '*'){
            checkMatch(s, p.substring(2));
            if(p.charAt(0) == '.'){
                for(int i=0;i<s.length();i++){
                    checkMatch(s.substring(i+1), p.substring(2));
                }
            }else{
                for(int i=0;i<s.length();i++){
                    if(p.charAt(0) == s.charAt(i)){
                        checkMatch(s.substring(i+1), p.substring(2));
                    }else{
                        break;
                    }
                }
            }
        }
        else if(p.length() >= 1 && p.charAt(0) == '.'){
            if(s.length() >= 1){
                checkMatch(s.substring(1), p.substring(1));
            }
        }
        else{
            if(p.length() >= 1 && s.length() >= 1 && p.charAt(0) == s.charAt(0)){
                checkMatch(s.substring(1), p.substring(1));
            }
        }
    }
    public boolean isMatch(String s, String p) {
        checkMatch(s, p);
        return ret;
    }
}
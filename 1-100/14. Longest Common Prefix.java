class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String output = "";
        for(int i=0;i<strs[0].length();i++){
            char current = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length() <= i ||
                    strs[j].charAt(i) != current){
                    return output;
                }
            }
            output += current;
        }
        return output;
    }
}
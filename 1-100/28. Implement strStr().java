class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] index = new int[needle.length()];
        int count = 0;
        index[0] = -1;
        for(int i=1;i<needle.length();i++){
            index[i] = -1;
            if(needle.charAt(i) == needle.charAt(count)){
                index[i] = count;
                count++;
            }else{
                while(count > 0){
                    count = index[count-1];
                    if(count == -1){
                        count = 0;
                        break;
                    }
                    if(needle.charAt(i) == needle.charAt(count+1)){
                        count++;
                        index[i] = count;
                        break;
                    }
                }
                if(index[i] == -1 && needle.charAt(i) == needle.charAt(0)){
                    index[i] = 0;
                    count = 1;
                }
            }
        }
        count = 0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) != needle.charAt(count)){
                if(count==0){
                    count = -1;
                }
                while(count > 0){
                    count = index[count-1];
                    if(count == -1){
                        if(haystack.charAt(i) == needle.charAt(0)){
                            count++;
                        }
                        break;
                    }
                    if(haystack.charAt(i) == needle.charAt(count+1)){
                        count++;
                        break;
                    }
                }
            }
            count++;
            if(count == needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
}
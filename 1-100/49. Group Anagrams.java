class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sortedStr = new String[strs.length];
        List<List<String>> retList = new ArrayList();
        List<String> newList = new ArrayList();
        // add "";
        for(int i=0; i<strs.length; i++){
            if (strs[i].equals("")) {
                newList.add(strs[i]);
            }
        }
        if (newList.size() > 0){
            retList.add(newList);
        }

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray(); 
            Arrays.sort(arr);
            sortedStr[i] = new String(arr);
        }

        for (int i = 0; i < strs.length; i++) {
            if (!sortedStr[i].equals("")) {
                newList = new ArrayList();
                newList.add(strs[i]);
                for (int j = i+1; j < strs.length; j++) {
                    if(sortedStr[i].equals(sortedStr[j])){
                        newList.add(strs[j]);
                        sortedStr[j] = "";
                    }
                }
                retList.add(newList);
            }
        }
        return retList;
/*
        for(int i=0; i<strs.length; i++){
            if (strs[i].equals("")) {
                newList.add(strs[i]);
            }
        }
        if (newList.size() > 0){
            retList.add(newList);
        }

        int i = 0;
        while (i < strs.length) {
            if (!strs[i].equals("")) {
                String s = strs[i].substring(0,1);
                for (int j = i; j<strs.length; j++) {
                    if (strs[j].contains(s)){
                        int index = strs[j].indexOf(s);
                        strs[j] = strs[j].substring(0,index) + strs[j].substring(index+1);
                        if (strs[j].equals("")){
                            done[j] = true;
                        }
                    }
                }

                
                for (int j = i; j < strs.length; j++) {
                    if (done[j]) {
                        newList = new ArrayList();
                        for (int k = j; k < strs.length; k++) {
                            if (done[k] && answer[j].length() == answer[k].length()) {
                                newList.add(answer[k]);
                                done[k] = false;
                            }
                        }
                        if (newList.size() > 0){
                            retList.add(newList);
                            newList = new ArrayList();
                        }
                    }
                }
            } else {
                i++;
            }
        }
        return retList;
*/







/*//        String[] strss = strs;
        int[] length = new int[strs.length];
        int[] count = new int[strs.length];
        char[] a = {'a','b','c','d','e','f','g','h','i','j',
                    'k','l','m','n','o','p','q','r','s','t',
                    'u','v','w','x','y','z'};
        HashMap<String,List<String>> output=new HashMap<>();
//        List<List<String>> output = new List<List>();
        for(int i=0; i<strs.length; i++){
            length[i] = strs[i].length();
            count[i] = strs[i].length();
        }
        for(int i=0; i<a.length; i++){
            for(int j=0; j<strs.length; j++){
                if(strs[j].contains(a[i])) {
                    count[j]--;
                }
            }
            List<String> thisRound = new ArrayList<String>();
            for(int j=0; j<strs.length; j++){
                if(count[j] == 0) {
                    thisRound.add(strs[j]);
                    count[j] = -1;
                }
            }
            if(thisRound.size() > 0){
                output.add(thisRound);
            }
        }
        return output;*/
    }
}
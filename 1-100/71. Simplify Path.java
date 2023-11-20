class Solution {
    public String simplifyPath(String path) {
        String ret = "";
        String[] pathMap = path.split("/");
        int skip=0;
        for (int i = pathMap.length-1; i >= 0; i--){
            if (pathMap[i].length() > 0 && !pathMap[i].equals(".")) {
                if (pathMap[i].equals("..")) {
                    skip++;
                } else if (skip > 0) {
                    skip--;
                } else {
                    ret = "/" + pathMap[i] + ret;
                }
            }
        }
        if (ret.length() == 0){
            return "/";
        }
        return ret;
    }
}
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] c = s.toCharArray();
        int add = (numRows - 1) * 2 ;
        int count=0;
        for(int i = 0;i < numRows;i++){
            for(int j = i;j < c.length;j += add){
                c[count++]=s.charAt(j);
                if(i != 0 && i != numRows - 1 && j + add - 2*i < c.length){
                    c[count++]=s.charAt(j + add - 2*i);
                }
            }
        }
        s = String.valueOf(c);
        return s;
    }
}
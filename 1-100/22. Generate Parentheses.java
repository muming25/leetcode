class Solution {
    private List<String> retlist = new ArrayList();
    private int targetlenght;
    private void generateParentheses(String current, int count, int length){
        if(length == targetlenght){
            if(count==0){
                retlist.add(current);
            }
            return;
        }
        generateParentheses(current+"(", count+1, length+1);
        if(count>0){
            generateParentheses(current+")", count-1, length+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        targetlenght = n*2;
        generateParentheses("", 0, 0);
        return retlist;
    }
}
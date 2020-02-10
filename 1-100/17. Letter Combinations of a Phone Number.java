class Solution {
    String[] table = {"","","abc","def","ghi","jkl","mno",
                    "pqrs","tuv","wxyz"};
    List<String> retlist;
    String input;
    public List<String> letterCombinations(String digits) {
        retlist = new ArrayList();
        if(digits.length()==0)return retlist;
        input = digits;
        findOutput(0,"");
        return retlist;
    }
    private void findOutput(int index, String current){
        if(index == input.length()){
            retlist.add(current);
            return;
        }
        int num = input.charAt(index) - '0';
        for(int i=0;i<table[num].length();i++){
            findOutput(index+1, current+table[num].charAt(i));
        }
    }
}
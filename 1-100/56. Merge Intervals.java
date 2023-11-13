class Solution {
    public int[][] merge(int[][] intervals) {
        for(int i = 1; i < intervals.length; i++){
            for(int j = i; j > 0; j--){
                if(intervals[j][0] < intervals[j-1][0]){
                    int temp = intervals[j][0];
                    intervals[j][0] = intervals[j-1][0];
                    intervals[j-1][0] = temp;
                    temp = intervals[j][1];
                    intervals[j][1] = intervals[j-1][1];
                    intervals[j-1][1] = temp;

                }
            }
        }
        
        int count = intervals.length;
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i+1][0] > intervals[i][1]){
                continue;
            }else{
                intervals[i+1][0] = min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = max(intervals[i][1], intervals[i+1][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                count--;
            }
        }
        
        int[][] ret = new int[count][2];
        int index = 0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]!=-1){
                ret[index][0] = intervals[i][0];
                ret[index][1] = intervals[i][1];
                index++;
            }
        }
        return ret;
    }
    private int min(int a, int b){
        if(a>b){
            return b;
        }else{
            return a;
        }
    }
    private int max(int a, int b){
        if(a<b){
            return b;
        }else{
            return a;
        }
    }
}
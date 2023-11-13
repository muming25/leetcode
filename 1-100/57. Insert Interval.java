class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int count = intervals.length + 1;
        for(int i=0;i<intervals.length;i++){
            if(newInterval[0] > intervals[i][1]){
                continue;
            }else if(newInterval[1] < intervals[i][0]){
                break;
            }else{
                newInterval[0] = min(newInterval[0], intervals[i][0]);
                newInterval[1] = max(newInterval[1], intervals[i][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                count --;
            }
        }
        int[][] ret = new int[count][2];
        int index = 0;
        boolean found = false;
        for(int i=0;i<intervals.length;i++){
            if(newInterval[1] < intervals[i][0] && !found){
                ret[index][0] = newInterval[0];
                ret[index][1] = newInterval[1];
                index++;
                found = true;
            }
            if(intervals[i][0]==-1){
                if(!found){
                    ret[index][0] = newInterval[0];
                    ret[index][1] = newInterval[1];
                    index++;
                    found = true;
                }
            }else{
                ret[index][0] = intervals[i][0];
                ret[index][1] = intervals[i][1];
                index++;
            }
        }
        if(!found){
            ret[index][0] = newInterval[0];
            ret[index][1] = newInterval[1];
            index++;
            found = true;
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
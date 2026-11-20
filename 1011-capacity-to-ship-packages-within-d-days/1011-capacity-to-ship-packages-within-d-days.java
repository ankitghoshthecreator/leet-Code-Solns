class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w: weights){
            low=Math.max(low, w);
            high+=w;
        }

        while(low<high){
            int mid=low+(high-low)/2;
            if(canGo(weights, days, mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean canGo(int[] weights,int d,int m){
        int daysUsed=1; 
        int currLoad=0;

        for(int w: weights){
            if(currLoad+w> m){
                daysUsed++;
                currLoad=w;

                if(daysUsed>d){
                    return false;
                }
            }else{
                currLoad+=w;
            }

        }return true;
    }


}
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top=check(tops[0], tops, bottoms);
        int bottom=check(bottoms[0], tops, bottoms);

        if(top==-1 && bottom==-1){
            return -1;
        }
        if(top==-1){
            return bottom;
        }
        if(bottom==-1){
            return top;
        }
        return Math.min(top, bottom);
        
    }

    private int check(int target, int[] top, int[] bottom){
        int topC=0;
        int bottomC=0;

        for(int i=0; i<top.length; i++){
            if(top[i]!=target && bottom[i]!=target){
                return -1;
            }
            if(top[i]!=target){
                topC++;
            }
            if(bottom[i]!=target){
                bottomC++;
            }
        }

        return Math.min(bottomC, topC);
    }
}
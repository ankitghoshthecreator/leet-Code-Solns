class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> 
        Integer.compare(a[1], b[1]));
    int cnt=0;
    int end=Integer.MIN_VALUE;

    for(int[] pair:pairs){
        if(pair[0]>end){
            cnt++;
            end=pair[1];
        }
    }return cnt;
    }

}
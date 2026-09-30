class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int ans=0;


        for(int house:houses){
            int left=0;
            int right=heaters.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;

                if(heaters[mid]<house){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }

            int leftD=Integer.MAX_VALUE;
            int rightD=Integer.MAX_VALUE;

            if(left<heaters.length){
                rightD=heaters[left]-house;
            }
            if(right>=0){
                leftD=house-heaters[right];
            }
            int nearD=Math.min(leftD, rightD);
            ans=Math.max(ans, nearD);
        }
        return ans;
    }
}
class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int currE=0;
        int furT=0;

        for(int i=0; i<nums.length-1; i++){
            furT=Math.max(furT, i+nums[i]);

            if(i==currE){
                jump++;
                currE=furT;
            } 
        }
        return jump;

    }
}
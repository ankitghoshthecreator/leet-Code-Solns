class Solution {
    public String largestNumber(int[] nums) {
        String[] arr=new String[nums.length];

        //converted to string
        for(int i=0; i<nums.length; i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a,b)->{
            String ab=a+b;
            String ba=b+a;

            return ba.compareTo(ab);
        }
        );

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder res=new StringBuilder();

        for(String s:arr){
            res.append(s);
        }
        return res.toString();
        
    }
}
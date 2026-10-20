class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> freq=new HashMap<>();
        int n=s.length();
        int maxF=0;

        for(int i=0; i<=n-minSize; i++){
            String sub=s.substring(i, i+minSize);

            Set<Character> uni=new HashSet<>();
            for(char c:sub.toCharArray()){
                uni.add(c);
            }
            if(uni.size()<= maxLetters){
                int count=freq.getOrDefault(sub, 0)+1;
                freq.put(sub, count);
                maxF=Math.max(count, maxF);
            }


        }return maxF;
    }
}
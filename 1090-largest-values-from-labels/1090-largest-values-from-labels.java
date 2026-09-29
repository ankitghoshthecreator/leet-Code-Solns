class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n=values.length;

        int[][] items=new int[n][2];

        for(int i=0; i<n;i++){
            items[i][0]=values[i];
            items[i][1]=labels[i];
        }

        Arrays.sort(items, (a,b) -> b[0]-a[0]);

        HashMap<Integer, Integer> count=new HashMap<>();

        int sum=0, selec=0;

        for(int[] item:items){
            if(selec==numWanted){
                break;
            }

            int val=item[0];
            int lbl=item[1];

            int used=count.getOrDefault(lbl, 0);

            if(used<useLimit){
                sum+=val;
                selec++;

                count.put(lbl, used+1);
            }

        }
        return sum;
    }
}
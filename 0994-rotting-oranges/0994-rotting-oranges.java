class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int mins=0;
        int[][] direction={
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];

                for(int[] dir:direction){
                 int newRow=row+dir[0];
                 int newCol=col+dir[1];

                 if(newRow>=m || newRow<0 || newCol>=n || newCol<0){
                    continue;
                 }

                 if(grid[newRow][newCol]!=1){
                    continue;
                 }
                 grid[newRow][newCol]=2;

                 fresh--;

                 q.offer(new int[] {newRow, newCol});
                }
            }
            mins++;
        }
        if(fresh>0){
            return -1;
        }return mins;

        
    }
}
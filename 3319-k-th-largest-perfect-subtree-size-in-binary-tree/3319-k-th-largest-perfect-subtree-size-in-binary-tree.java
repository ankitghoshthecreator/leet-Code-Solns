/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<Integer> size=new ArrayList<>();
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        dfs(root);


        size.sort(Collections.reverseOrder());

        if(size.size()<k){
            return -1;
        }
        return size.get(k-1);
    }

    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftS=dfs(node.left);
        int rightS=dfs(node.right);

        if(node.left==null && node.right==null){
            size.add(1);
            return 1;
        }



        if(leftS!=-1 &&
        rightS!=-1 &&
        leftS==rightS){
            int s=leftS+rightS+1;
            size.add(s);
            return s;
        }
        return -1;
    }
}
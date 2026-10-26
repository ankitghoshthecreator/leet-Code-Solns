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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> visited=new LinkedList<>();
        visited.offer(root);
        int result=root.val;

        while(!visited.isEmpty()){
            TreeNode node=visited.poll();


            if(node.right!=null){
                visited.offer(node.right);
            }
            
            if(node.left!=null){
                visited.offer(node.left);
            }
            result=node.val;
        }return result;
    }
}
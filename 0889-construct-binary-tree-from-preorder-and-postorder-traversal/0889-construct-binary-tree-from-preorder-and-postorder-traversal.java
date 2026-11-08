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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0,0,preorder.length);
    }
    private TreeNode build(int[] pre,int[] post, int preSt, int postSt, int size){
        if(size==0){
            return null;
        }

        TreeNode root=new TreeNode(pre[preSt]);
        if(size==1){
            return root;
        }

        int leftRoot=pre[preSt+1];

        int i=postSt;

        while(post[i]!=leftRoot){
            i++;
        }

        int leftS=i-postSt+1;

        root.left=build(pre, post, preSt+1, postSt, leftS);
        root.right=build(pre, post, preSt+leftS+1, postSt+leftS, size-1-leftS);

        return root;
    }
}
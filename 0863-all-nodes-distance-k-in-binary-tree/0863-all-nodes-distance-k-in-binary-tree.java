/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> par=new HashMap<>();
        buildP(root, null, par);

        Queue<TreeNode> que=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();

        que.offer(target);
        visited.add(target);

        int distance=0;

        while(!que.isEmpty()){
            if(distance==k){
                break;
            }

            int size=que.size();
            for(int i=0; i<size;i++){
                TreeNode curr=que.poll();

                if(curr.left!=null &&
                   !visited.contains(curr.left)){
                    visited.add(curr.left);
                    que.offer(curr.left);
                }
                if(curr.right!=null &&
                   !visited.contains(curr.right)){
                    visited.add(curr.right);
                    que.offer(curr.right);
                }
                TreeNode p=par.get(curr);

                if(p!=null && !visited.contains(p)){
                    visited.add(p);
                    que.offer(p);
                }
            }
            distance++;
        }
        List<Integer> ans=new ArrayList<>();
        while(!que.isEmpty()){
            ans.add(que.poll().val);
        }
        return ans;
    }

    private void buildP(TreeNode node, TreeNode p, Map<TreeNode, TreeNode> parent){
        if(node==null){
            return;
        }
        parent.put(node, p);

        buildP(node.left, node, parent);
        buildP(node.right, node, parent);
    }
}
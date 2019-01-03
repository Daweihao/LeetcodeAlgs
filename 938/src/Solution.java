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
    private int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        Dfs(root,L,R);
        return ans;
    }
    public void Dfs(TreeNode x, int L, int R){
        if(x != null){
            if (x.val > L){
                Dfs(x.left,L,R);
            }
            if (x.val >= L && x.val <= R){
                ans += x.val;
            }
            if (R > x.val){
                Dfs(x.right,L,R);
            }

        }

    }
}
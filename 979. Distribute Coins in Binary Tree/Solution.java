/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int min_move = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return min_move;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftMove = dfs(root.left);
        int rightMove = dfs(root.right);

        root.val = leftMove + rightMove + (root.val - 1);
        min_move += Math.abs(root.val);

        return root.val;
    }
}

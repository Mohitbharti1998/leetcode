class Solution {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        boolean l = dfs(root.left), r = dfs(root.right);
        if (root.val == 2) {
            return l || r;
        }
        return l && r;
    }
}

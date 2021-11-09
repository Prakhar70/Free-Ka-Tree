
public class DiameterofTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = { 0 };
        height(root, ans);
        return ans[0];
    }

    int height(TreeNode root, int[] ans) {
        if (root == null) {
            return -1;
        }
        int lh = height(root.left, ans);
        int rh = height(root.right, ans);
        if (lh + rh + 2 > ans[0]) {
            ans[0] = lh + rh + 2;
        }
        return Math.max(lh, rh) + 1;
    }
}
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBal(root) != -1;
    }

    private int isBal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lht = isBal(root.left);
        int rht = isBal(root.right);
        if (lht == -1 || rht == -1) {
            return -1;
        }
        if (Math.abs(lht - rht) > 1) {
            return -1;
        }
        return 1 + Math.max(lht, rht);
    }
}
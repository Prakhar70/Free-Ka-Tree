public class isTreeSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSame(root.left,root.right);
    }
    public static boolean isSame(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null){
            return root1==root2;
        }
        return (root1.val==root2.val)&&isSame(root1.left,root2.right)&&isSame(root1.right,root2.left);
        
    }
}

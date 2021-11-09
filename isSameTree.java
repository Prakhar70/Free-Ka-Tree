public class isSameTree {
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            return p==q;
        }
        return (p.val==q.val) && (isSameTree1(p.left,q.left) && isSameTree1(p.right,q.right));
    }
}

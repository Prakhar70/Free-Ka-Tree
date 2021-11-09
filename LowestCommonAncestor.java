
class LowestCommonAncestor {
    static TreeNode LCA=null;
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
         lowestCommonAncestor_(root,p,q);
         return LCA;
     }
     private int lowestCommonAncestor_(TreeNode root,TreeNode p,TreeNode q){
         if(root==null){
             return 0;
         }
         int lt=lowestCommonAncestor_(root.left,p,q);
         int rt=lowestCommonAncestor_(root.right,p,q);
         if(lt==2||rt==2){
             return 2;
         }
         int self=0;
         if(root.val ==p.val || root.val==q.val){
             self=1;
         }
         int ans=(lt+rt+self);
         if(ans==2){
             LCA=root;
         }
         return ans;
     }
 }
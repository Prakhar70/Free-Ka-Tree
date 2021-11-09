import java.util.*;
class rightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        rightSideTraversal(root,ans,0);
        return ans;
    }
    public void rightSideTraversal(TreeNode root,List<Integer> ans,int lvl){
        if(root==null){
            return;
        }
        if(lvl==ans.size()){
            ans.add(root.val);
        }
        rightSideTraversal(root.right,ans,lvl+1);
        rightSideTraversal(root.left,ans,lvl+1);
    }
    
}
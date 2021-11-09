import java.util.*;
class inoderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ansList=new ArrayList<>();
        
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        while(!st.isEmpty() || node!=null){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                TreeNode x=st.pop();
                ansList.add(x.val);
                node=x.right;
            }
            
        }
        return ansList;
    }
}
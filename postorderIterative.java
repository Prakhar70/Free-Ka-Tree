import java.util.*;
public class postorderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> ansList=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        if(root==null){
            return ansList;
        }
        st.push(root);
        while(!st.isEmpty()){
            TreeNode x=st.pop();
            st2.push(x.val);
            if(x.left!=null){
                st.push(x.left);
            }
            if(x.right!=null){
                st.push(x.right);
            }
        }
        while(st2.size()>0){
            ansList.add(st2.pop());
        }
        return ansList;
    }
}

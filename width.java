import java.util.*;
class width {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> ds=new LinkedList<>();
        ds.addFirst(root);
        int max=Integer.MIN_VALUE;
        while(true){
            trim(ds);
            max=Math.max(max,ds.size());
            if(ds.size()==0){
                break;
            }
            TreeNode rnode=ds.removeFirst();
            if(rnode==null){
                ds.add(null);
                ds.add(null);
            }
            else{
                ds.add(rnode.left);
                ds.add(rnode.right);
            }
        }
        return max;
    }
    private void trim(LinkedList<TreeNode> list){
       
        while(list.getFirst()==null){
            list.removeFirst();
        }
        while(list.getLast()==null){
            list.removeLast();
        }
    }
}
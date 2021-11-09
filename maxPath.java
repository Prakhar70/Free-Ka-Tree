public class maxPath {
    public int maxPathSum(TreeNode root) {
        int[] max={Integer.MIN_VALUE};
        maxPath1(root,max);
        return  max[0];
        
    }
    private int maxPath1(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }
        int lans=Math.max(0,maxPath1(root.left,max));
        int rans=Math.max(0,maxPath1(root.right,max));
        max[0]=Math.max(max[0],lans+rans+root.val);
        return root.val+Math.max(lans,rans);
        
    }   
}
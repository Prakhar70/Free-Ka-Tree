import java.util.*;

 

class vPair{
    TreeNode node;
    int lvl;
    int hlvl;
    vPair(TreeNode node,int lvl,int hlvl){
        this.node=node;
        this.lvl=lvl;
        this.hlvl=hlvl;
    }
}

class verticalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        int minlvl=Integer.MAX_VALUE;
        int maxlvl=Integer.MIN_VALUE;
         PriorityQueue<vPair> que = new PriorityQueue<>((a, b) -> {
             if(a.hlvl!=b.hlvl){
                 return a.hlvl-b.hlvl;
             }
            if (a.lvl != b.lvl) {
                return a.lvl - b.lvl;
            }
            return a.node.val - b.node.val;
        });
        vPair vp1=new vPair(root,0,0);
        que.add(vp1);
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                vPair vp=que.remove();
                if(hm.containsKey(vp.lvl)){
                    hm.get(vp.lvl).add(vp.node.val);
                }
                else{
                    ArrayList<Integer> tans=new ArrayList<>();
                    tans.add(vp.node.val);
                    hm.put(vp.lvl,tans);
                }
                minlvl=Math.min(minlvl,vp.lvl);
                maxlvl=Math.max(maxlvl,vp.lvl);
                
                if(vp.node.left!=null){
                    que.add(new vPair(vp.node.left,vp.lvl-1,vp.hlvl+1));
                }
                if(vp.node.right!=null){
                    que.add(new vPair(vp.node.right,vp.lvl+1,vp.hlvl+1));
                }
                
            }
        }
        for(int i=minlvl;i<=maxlvl;i++){
            ans.add(hm.get(i));
        }
        return ans;
    }
}
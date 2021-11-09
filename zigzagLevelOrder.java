import java.util.*;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        if (root == null) {
            return ansList;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        boolean flag = false;
        
        while (!que.isEmpty()) {
            flag = !flag;
            int size = que.size();
            List<Integer> tans = new ArrayList<>();
            while (size-- > 0) {
                TreeNode x = que.removeFirst();
                tans.add(x.val);
                if (x.left != null) {
                    que.addLast(x.left);
                }
                if (x.right != null) {
                    que.addLast(x.right);
                }

            }
            if (flag == true) {
                ansList.add(tans);
            } else {
                Collections.reverse(tans);
                ansList.add(tans);
            }
        }
        return ansList;

    }
}
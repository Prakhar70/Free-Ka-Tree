
import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class vPair_{
    int lvl;
    BinaryTreeNode node;
    vPair_(int lvl,BinaryTreeNode node)
    {
        
        this.lvl=lvl;
        this.node=node;
    }
}
public class TopView {
    public static void width(BinaryTreeNode root, int vl, int[] minmax) {
        if (root == null) {
            return;
        }
        minmax[0] = Math.min(minmax[0], vl);
        minmax[1] = Math.max(minmax[1], vl);
        width(root.left, vl - 1, minmax);
        width(root.right, vl + 1, minmax);
    }

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        int[] minmax = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        width(root, 0, minmax);
        int minwidth = minmax[0];
        int maxwidth = minmax[1];
        int width = maxwidth - minwidth + 1;
        int[] ans = new int[width];
        Queue<vPair_> que = new LinkedList<>();
        que.add(new vPair_(-minwidth, root));
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                vPair_ rpair = que.remove();
                if (ans[rpair.lvl] == 0) {
                    ans[rpair.lvl] = rpair.node.val;
                }

                if (rpair.node.left != null) {
                    que.add(new vPair_(rpair.lvl - 1, rpair.node.left));
                }
                if (rpair.node.right != null) {
                    que.add(new vPair_(rpair.lvl + 1, rpair.node.right));
                }
            }
        }
        ArrayList<Integer> mainans = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            mainans.add(ans[i]);
        }
        return mainans;

    }
}
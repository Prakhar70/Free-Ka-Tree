import java.util.*;
public class nodeToRootPath1 {
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        nodeToRootPath_(node, data, ans);
        return ans;
    }

    private static boolean nodeToRootPath_(TreeNode node, int data, ArrayList<TreeNode> ans) {
        if (node == null) {
            return false;
        }
        if (node.val == data) {
            ans.add(node);
            return true;
        }
        boolean tans = nodeToRootPath_(node.left, data, ans) || nodeToRootPath_(node.right, data, ans);
        if (tans) {
            ans.add(node);
        }
        return tans;
    }
}

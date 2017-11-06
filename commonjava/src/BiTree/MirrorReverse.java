package BiTree;

/**
 * 二叉树镜面反转
 * Created by xkc on 9/17/16.
 */
public class MirrorReverse {
    public static void main(String[] args){
        TreeNode root = new TreeNode("A");

    }

    public static TreeNode reverse(TreeNode root){
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }else if (root.left == null){
            root.left = root.right;
            root.right = null;
        }else if (root.right == null){
            root.right = root.left;
            root.left = null;
        }else {
            root.left = reverse(root.right);
            root.right = reverse(root.left);
        }
        return root;
    }

    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String val){
            this.val = val;
        }
    }
}



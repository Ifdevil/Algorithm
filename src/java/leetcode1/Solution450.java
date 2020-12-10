package leetcode1;

public class Solution450 {

    public static void main(String[] args) {
        Solution450 s = new Solution450();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        s.deleteNode(root,3);
        System.out.println(root);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        int value = root.val;
        if(value == key){
            // 删除
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left,root.val);
            }

        }else if(value > key){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
    
    public int successor(TreeNode root){
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }
}

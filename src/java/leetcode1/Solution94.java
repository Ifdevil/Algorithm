package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class Solution94 {

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(solution94.inorderTraversal2(root).toArray()));
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        digui(root,result);
        return result;
    }
    
    public void digui(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        digui(root.left,result);
        result.add(root.val);
        digui(root.right,result);
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> temp = new Stack<>();
        while (root != null || !temp.isEmpty()){
            while (root != null){
                temp.add(root);
                root = root.left;
            }
            root = temp.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
    
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

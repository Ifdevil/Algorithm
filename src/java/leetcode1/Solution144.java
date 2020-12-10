package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历
 */
public class Solution144 {

    public static void main(String[] args) {
        Solution144 s = new Solution144();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(s.preorderTraversal1(root).toArray()));
    }

    /**
     * 递归 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        digui(root,result);
        return result;
    }
    
    public void digui(TreeNode node,List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        digui(node.left,result);
        digui(node.right,result);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> temp = new Stack<>();
        while (root != null || !temp.isEmpty()){
            while (root != null){
                result.add(root.val);
                temp.add(root);
                root = root.left;
            }
            root = temp.pop();
            root = root.right;
        }
        return result;
    }
}

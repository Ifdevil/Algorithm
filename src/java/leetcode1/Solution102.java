package leetcode1;

import java.util.*;

public class Solution102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution102 s = new Solution102();
        List<List<Integer>> lists = s.levelOrder(root);
        lists.forEach(x -> {
            x.forEach(System.out::println);
            System.out.println();
        });
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> list1 = new ArrayDeque<>();
        Deque<TreeNode> list2 = new ArrayDeque<>();
        list1.add(root);
        while (!list1.isEmpty() || !list2.isEmpty()){
            if (!list1.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                while (!list1.isEmpty()){
                    TreeNode pop = list1.pop();
                    temp.add(pop.val);
                    if(pop.left != null)list2.add(pop.left);
                    if(pop.right != null)list2.add(pop.right);
                }
                ans.add(temp);
            }
            if (!list2.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                while (!list2.isEmpty()){
                    TreeNode pop = list2.pop();
                    temp.add(pop.val);
                    if(pop.left != null)list1.add(pop.left);
                    if(pop.right != null)list1.add(pop.right);
                }
                ans.add(temp);
            }
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


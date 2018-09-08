// solution: https://www.youtube.com/watch?v=9ZNky1wqNUw

public class Leetcode124 {
    
    private int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        int subMax = Math.max(Math.max(left, right), 0);
        
        int curMax = subMax + root.val; // this max must include root & at most 1 subtree is used
        
        res = Math.max(Math.max(res, curMax), left + right + root.val);
        return curMax;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList<>();
        preOrderTraversal (root, queue);
        queue.poll();

        while (!queue.isEmpty()) {
            root.right = queue.poll();
            root.left = null;
            root = root.right;
        }
    }

    public void preOrderTraversal (TreeNode node, Queue <TreeNode> queue) {
        if (node == null)
            return;
        queue.add (node);
        preOrderTraversal (node.left,queue);
        preOrderTraversal (node.right, queue);
    }
}

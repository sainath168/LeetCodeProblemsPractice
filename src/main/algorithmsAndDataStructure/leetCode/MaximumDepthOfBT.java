package main.algorithmsAndDataStructure.leetCode;

public class MaximumDepthOfBT {
    /**
     * TreeNode definition
     */
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        /*
        Approach 1: (Tree traversal using Recursive)
        - traverse the tree left and then right
        - for every forward move keep increment the DEPTH (current) until node == null
        - keep track of MAXDEPTH and assign the value only if previoud MAXDEPTH < DEPTH (current)
        */
        int[] maxDepth = new int[] {0};
        int depth = 0;
        if (root == null) {
            depth--;
            return 0;
        } else {
            depth++;
            maxDepth[0] = Math.max(maxDepth[0], depth);
            System.out.println("increment at node " + root.value + " and depth = "+ maxDepth[0]);
            maxDepth(root.left);
            maxDepth(root.right);
        }

        return maxDepth[0];
    }

    private static void treeTraversal(TreeNode node, int depth, int[] maxDepth) {
        if (node == null) {
            depth--;
            return;
        } else {
            depth++;
            maxDepth[0] = Math.max(maxDepth[0], depth);
            System.out.println("increment at node " + node.value + " and depth = "+ maxDepth[0]);
        }
        treeTraversal(node.left, depth, maxDepth);
        treeTraversal(node.right, depth, maxDepth);
    }

}

package main.algorithmsAndDataStructure.binaryTree;

public class BinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node(3);
        node1.left = new Node(2);
        node1.right = new Node(7);


        Node node2 = new Node(3);
        node2.left = new Node(2);
        node2.right = new Node(4);


        System.out.println(compareTwoTrees(node1, node2));
    }

    static boolean compareTwoTrees(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        } else if (node1.data == node2.data) {
            return compareTwoTrees(node1.left, node2.left) && compareTwoTrees(node1.right, node2.right);
        } else {
            return false;
        }
    }
}

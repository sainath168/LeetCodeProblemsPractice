package algorithmsAndDataStructure.binaryTree;

import java.util.*;

public class Node<T> {
    private T data;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * This will insert the data based on the comparison starting from root node.
     * if input data is < root node's data, then it does recursive call with (root) node's left and the input value
     *      this is repeated until there is no node to check
     * if input data is > root node's data, then it does recursive call with (root) node's right and the input value
     *      this is repeated until there is no node to check
     *
     * In this process it could go to different paths of child nodes.
     *
     * @param node - root node
     * @param data - data that you want to insert into tree
     */
    public void insert(Node<T> node, T data) {

    }

    /**
     * similar to the code below from edureka but need to check the generics support
     *
    public void insert(Node node, int value) {
        if (value < node.data) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        }
        else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of " + node.value);
                node.right = new Node(value);
            }
        }
    }*/


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}

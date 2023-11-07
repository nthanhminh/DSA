import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class HeightOfBinaryTree {

    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node current;
            if (data <= root.data) {
                current = insert(root.left, data);
                root.left = current;
            } else {
                current = insert(root.right, data);
                root.right = current;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        System.out.println(getHeight(root));

        sc.close();
    }
}

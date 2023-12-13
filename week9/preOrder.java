import java.io.*;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class preOrder {

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            root = insert(root, val);
        }
        preOrder(root);
        scanner.close();
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        } else {
            Node tmp;
            if (val <= root.val) {
                tmp = insert(root.left, val);
                root.left = tmp;
            } else {
                tmp = insert(root.right, val);
                root.right = tmp;
            }
            return root;
        }
    }
}

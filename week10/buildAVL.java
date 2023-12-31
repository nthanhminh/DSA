    class Node {
        int data;
        int height;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
    
    public class SelfBalancingTree {
        public Node root;
    
        public Node getRoot(){
            return root;
        }

        int getHeight(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }
    
        int getBalanceFactor(Node node) {
            if (node == null) {
                return 0;
            }
            return getHeight(node.left) - getHeight(node.right);
        }
    
        void updateHeight(Node node) {
            if (node != null) {
                node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
            }
        }
    
        Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;
            x.right = y;
            y.left = T2;
            updateHeight(y);
            updateHeight(x);
            return x;
        }
    
        Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;
            y.left = x;
            x.right = T2;
            updateHeight(x);
            updateHeight(y);
            return y;
        }
    
        Node insert(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }
    
            if (data < root.data) {
                root.left = insert(root.left, data);
            } else if (data > root.data) {
                root.right = insert(root.right, data);
            } else {
                return root;
            }
    
            updateHeight(root);
            int balance = getBalanceFactor(root);
    
            if (balance > 1) {
                if (data < root.left.data) {
                    return rightRotate(root);
                } else {
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }
            }
    
            if (balance < -1) {
                if (data > root.right.data) {
                    return leftRotate(root);
                } else {
                    root.right = rightRotate(root.right);
                    return leftRotate(root);
                }
            }
    
            return root;
        }

       public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
        inorder(root.right);
    }
   
    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
        preorder(root.left);
        preorder(root.right);
    }
    }


public class Solution{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SelfBalancingTree build = new buildAVL();
        for (int i = 0; i < n; i++) {
            build.insert(new Node(scanner.nextInt()));
        }
        build.preorder(build.root);
        System.out.println();
        build.inorder(build.root);
    }
}
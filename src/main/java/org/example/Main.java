package org.example;

// create a class for a AVL tree node
class AvlNode {
    int data;
    AvlNode left;
    AvlNode right;
    int height;

    // create a constructor for the AVL tree node
    public AvlNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class AvlTree {
    AvlNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private AvlNode insert(AvlNode node, int data) {
        if (node == null) return new AvlNode(data);

        if (data < node.data) node.left = insert(node.left, data);
        else if (data > node.data) node.right = insert(node.right, data);
        else return node;

        return rebalance(node);
    }

    // getBalance method for avl tree
    public int getBalance(AvlNode root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // height method for avl tree
    public int height(AvlNode root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // rightRotate method for avl tree
    public AvlNode rightRotate(AvlNode y) {
        AvlNode x = y.left;
        AvlNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // leftRotate method for avl tree
    public AvlNode leftRotate(AvlNode x) {
        AvlNode y = x.right;
        AvlNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // inorder method for avl tree
    public void inorder(AvlNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // preorder method for avl tree
    public void preorder(AvlNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // postorder method for avl tree
    public void postorder(AvlNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // search method for avl tree
    private boolean search(AvlNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    // delete method for avl tree
    public AvlNode delete(AvlNode root, int data) {
        // Caso base: se a árvore (ou subárvore) estiver vazia
        if (root == null) return root;

        // Encontre o nó a ser deletado
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // Caso 1: O nó a ser deletado tem no máximo um filho
            root = deleteNodeWithOneOrNoChild(root);

            // Caso 2: O nó a ser deletado tem dois filhos
            if (root != null && root.left != null && root.right != null) {
                root = deleteNodeWithTwoChildren(root);
            }
        }

        // Se a árvore ficou vazia, retornamos nulo
        if (root == null) return root;

        // Rebalanceia a árvore após a remoção
        return rebalance(root);
    }

    private AvlNode deleteNodeWithOneOrNoChild(AvlNode root) {
        if (root.left == null || root.right == null) {
            AvlNode childNode = (root.left != null) ? root.left : root.right;
            return childNode;  // Substitui o nó por seu filho ou retorna nulo
        }
        return root;
    }

    private AvlNode deleteNodeWithTwoChildren(AvlNode root) {
        AvlNode successor = minValueNode(root.right);
        root.data = successor.data;
        root.right = delete(root.right, successor.data);
        return root;
    }

    // minValueNode method for avl tree
    public AvlNode minValueNode(AvlNode root) {
        AvlNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private AvlNode rebalance(AvlNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) return rightRotate(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) return leftRotate(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public boolean search(int data) {
        return search(root, data);
    }
}

public class Main {
    public static void main(String[] args) {
        // create a binary search tree
        AvlTree tree = new AvlTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        showTree(tree);

        // delete a node
        tree.delete(2);
        tree.delete(3);

        showTree(tree);

        tree.insert(5);
        tree.insert(0);
        tree.insert(-3);

        showTree(tree);
    }

    private static void showTree(AvlTree tree) {
        // inorder traversal
        System.out.println("Inorder: ");
        tree.inorder();
        // preorder traversal
        System.out.println("Preorder: ");
        tree.preorder();
        // postorder traversal
        System.out.println("Posorder: ");
        tree.postorder();

        System.out.println("--------------------");
    }
}
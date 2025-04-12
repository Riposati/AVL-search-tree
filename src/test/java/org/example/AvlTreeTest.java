package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTreeTest {

    // Test for deletion of non-existent node
    @Test
    public void testDeleteNonExistentNode() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        AvlNode root = tree.root;
        AvlNode result = tree.delete(root, 40);

        // The tree structure should remain unchanged
        assertEquals(root, result);
        assertTrue(tree.search(10));
        assertTrue(tree.search(20));
        assertTrue(tree.search(30));
        assertFalse(tree.search(40));
    }

    // Test for height with a null root
    @Test
    public void testHeightWithNullRoot() {
        AvlTree tree = new AvlTree();
        assertEquals(0, tree.height(null));
    }

    // Test inorder traversal on an empty tree
    @Test
    public void testInorderEmptyTree() {
        AvlTree tree = new AvlTree();
        tree.inorder();
    }

    // Test inorder traversal with empty tree and capturing output
    @Test
    public void testInorderWithEmptyTree() {
        AvlTree tree = new AvlTree();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.inorder();

        assertTrue(outContent.toString().trim().isEmpty());
        System.setOut(System.out);
    }

    // Test postorder traversal with an empty tree and capturing output
    @Test
    public void testPostorderWithEmptyTree() {
        AvlTree tree = new AvlTree();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.postorder();

        assertEquals(System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    // Test right rotation with null input node (NullPointerException expected)
    @Test
    public void testRightRotateWithNullNode() {
        try {
            AvlTree tree = new AvlTree();
            tree.rightRotate(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Test passes
        }
    }

    // Test search in an empty tree
    @Test
    public void testSearchEmptyTree() {
        AvlTree tree = new AvlTree();
        assertFalse(tree.search(10));
    }

    // Test case for deleting node less than the root
    @Test
    public void test_delete_1() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        tree.delete(5);

        assertFalse(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(15));
    }

    // Test case for deleting node greater than the root
    @Test
    public void test_delete_2() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        tree.delete(30);

        assertFalse(tree.search(30));
        assertTrue(tree.search(10));
        assertTrue(tree.search(20));
    }

    // Test case for deleting a node with two children
    @Test
    public void test_delete_3() {
        AvlTree tree = new AvlTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.delete(50);

        assertFalse(tree.search(50));
        assertTrue(tree.search(60));
        assertEquals(3, tree.height(tree.root));
    }

    // Test case for deleting a node smaller than the root
    @Test
    public void test_delete_4() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        tree.delete(5);

        assertFalse(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(15));
    }

    // Test case for deleting a node from AVL tree
    @Test
    public void test_delete_node_from_avl_tree() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        tree.delete(20);

        assertFalse(tree.search(20));
        assertTrue(tree.search(10));
        assertTrue(tree.search(30));

        assertEquals(2, tree.root.height);
        assertEquals(1, Math.abs(tree.getBalance(tree.root)));
    }

    // Test the getBalance method for null root
    @Test
    public void test_getBalance_returnsZeroForNullRoot() {
        AvlTree tree = new AvlTree();
        assertEquals(0, tree.getBalance(null));
    }

    // Test getBalance with different height children
    @Test
    public void test_getBalance_whenRootNotNullWithDifferentHeightChildren() {
        AvlTree tree = new AvlTree();
        AvlNode root = new AvlNode(10);
        root.left = new AvlNode(5);
        root.right = new AvlNode(15);
        root.left.left = new AvlNode(3);
        root.height = 3;
        root.left.height = 2;
        root.right.height = 1;
        root.left.left.height = 1;

        int balance = tree.getBalance(root);

        assertEquals(1, balance);
    }

    // Test for inorder traversal with non-null root
    @Test
    public void test_inorder_nonNullRoot() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.inorder();

        System.setOut(System.out);

        assertEquals("5 10 15 \n", outContent.toString());
    }

    // Test inorder traversal with non-empty tree
    @Test
    public void test_inorder_traversal() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.inorder();

        System.setOut(System.out);

        assertEquals("10 20 30 40 \n", outContent.toString());
    }

    // Test for inserting a single element into an empty AVL tree
    @Test
    public void test_insert_singleElementIntoEmptyTree() {
        AvlTree tree = new AvlTree();
        int dataToInsert = 10;

        tree.insert(dataToInsert);

        assertNotNull("Root should not be null after insertion", tree.root);
        assertEquals("Root should contain the inserted value", dataToInsert, tree.root.data);
        assertEquals("Tree height should be 1 for a single node", 1, tree.root.height);
        assertNull("Left child should be null", tree.root.left);
        assertNull("Right child should be null", tree.root.right);
    }

    // Test left rotation of AVL tree
    @Test
    public void test_leftRotate_1() {
        AvlTree tree = new AvlTree();
        AvlNode root = new AvlNode(30);
        root.right = new AvlNode(40);
        root.right.right = new AvlNode(50);

        root.height = 3;
        root.right.height = 2;
        root.right.right.height = 1;

        AvlNode newRoot = tree.leftRotate(root);

        assertEquals(40, newRoot.data);
        assertEquals(30, newRoot.left.data);
        assertEquals(50, newRoot.right.data);

        assertEquals(2, newRoot.height);
        assertEquals(1, newRoot.left.height);
        assertEquals(1, newRoot.right.height);
    }

    // Test for minimum value node in AVL tree
    @Test
    public void test_minValueNode_3() {
        AvlTree tree = new AvlTree();
        AvlNode root = new AvlNode(10);
        AvlNode result = tree.minValueNode(root);
        assertEquals(root, result);
    }

    // Test for searching an existing element in the AVL tree
    @Test
    public void test_search_existing_element() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        assertTrue(tree.search(20));
    }

    @Test
    public void test_delete_and_balance() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.delete(5);

        assertTrue(tree.search(10));
        assertTrue(tree.search(20));
        assertFalse(tree.search(5));

        // Verificar o balanceamento da árvore após a deleção
        assertTrue(Math.abs(tree.getBalance(tree.root)) <= 1);
    }

    @Test
    public void test_insert_decreasingOrder() {
        AvlTree tree = new AvlTree();
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);

        assertTrue(Math.abs(tree.getBalance(tree.root)) <= 1); // Garantir que a árvore está balanceada
        assertTrue(tree.search(10));
        assertTrue(tree.search(20));
        assertTrue(tree.search(30));
    }

    @Test
    public void test_delete_with_heavy_subtree() {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        tree.delete(40); // A deleção de 40 deve desencadear uma rotação.

        assertTrue(Math.abs(tree.getBalance(tree.root)) <= 1); // Verificar balanceamento
        assertTrue(tree.search(10));
        assertTrue(tree.search(30));
        assertTrue(tree.search(50));
    }
}

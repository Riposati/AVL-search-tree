# AVL Tree in Java

> **Project created by me with the assistance of generative AI (ChatGPT and Amazon Q).**

This project implements an **AVL tree** — a self-balancing binary search tree — using the Java programming language. The tree supports insertions, deletions, searches, and traversals in in-order, pre-order, and post-order.

---

## 📁 Project Structure

```
org.example
├── AvlNode.java      // AVL tree node class
├── AvlTree.java      // Core logic for AVL tree (insert, delete, balance, etc.)
└── Main.java         // Main class with usage examples
```

---

## ✅ Features

- Node insertion with automatic balancing  
- Node deletion (supports cases with 0, 1, or 2 children)  
- Value search  
- Tree traversals:
  - **In-order** (left → root → right)
  - **Pre-order** (root → left → right)
  - **Post-order** (left → right → root)  
- Tree balancing using single and double rotations (left/right)

---

## 🔧 How to Use

### Compile the project:

```bash
javac Main.java
```

### Run the project:

```bash
java org.example.Main
```

### Sample Output:

```
Inorder: 
1 2 3 4 
Preorder: 
2 1 3 4 
Posorder: 
1 4 3 2 
--------------------
Inorder: 
1 4 
Preorder: 
4 1 
Posorder: 
1 4 
--------------------
Inorder: 
-3 0 1 4 5 
Preorder: 
4 1 0 -3 5 
Posorder: 
-3 0 1 5 4 
--------------------
```

---

## 📘 Main Classes

### `AvlNode`

Represents a node in the AVL tree with:
- `int data`: value stored
- `AvlNode left, right`: left and right children
- `int height`: height of the node for balance calculations

### `AvlTree`

Contains the main methods:
- `insert(int data)`
- `delete(int data)`
- `search(int data)`
- `inorder()`, `preorder()`, `postorder()`

Internally, it uses private methods for rebalancing and restructuring the tree, such as `leftRotate`, `rightRotate`, and `rebalance`.

### `Main`

A sample class that demonstrates how to use the AVL tree with insertions, deletions, and traversal outputs.

---

## 🧠 About AVL Trees

An **AVL tree** (Adelson-Velsky and Landis) is a self-balancing binary search tree. After every insertion or deletion, it checks the balance factor of each node and performs rotations when necessary to ensure the height remains O(log n), keeping operations efficient.

---

## 📜 License

This project is available under the **MIT License**.

package com.morsu.datastructures;


class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        insertNodeValue(this.root,value);
    }

    private void insertNodeValue(Node node, int value) {


        if (value <= node.data) {
            if (node.left == null) {
                System.out.println("Data: " + node.data);
                System.out.println("Inserting to Left");
                node.left = new Node(value);
            } else {
                System.out.println("Traversing to Left");
                insertNodeValue(node.left,value);
            }
        } else {
            if (node.right == null) {
                System.out.println("Data: " + node.data);
                System.out.println("Inserting to Right");
                node.right = new Node(value);
            } else {
                System.out.println("Traversing to Right");
                insertNodeValue(node.right, value);
            }
        }
    }

    public void inOrderTraversal() {
        System.out.println(" --------START IN ORDER------------- ");
        printInOrder(this.root);
        System.out.println(" --------END IN ORDER------------- ");
    }

    public void preOrderTraversal() {
        System.out.println(" --------START PRE ORDER------------- ");
        printPreOrder(this.root);
        System.out.println(" --------END PRE ORDER------------- ");
    }

    public void postOrderTraversal() {
        System.out.println(" --------START POST ORDER------------- ");
        printPostOrder(this.root);
        System.out.println(" --------END POST ORDER------------- ");
    }

    private void printPostOrder(Node node) {
        if (node.left != null) {
            System.out.println("Traversing Left to Node: " + node.data);
            printPostOrder(node.left);
        }

        if (node.right != null) {
            System.out.println("Traversing Right to Node: " + node.data);
            printPostOrder(node.right);
        }

        System.out.println(node.data + " ");
    }


    public void printInOrder(Node node) {
        if (node.left != null) {
            printInOrder(node.left);
        }
        System.out.println(node.data + " ");
        if (node.right != null) {
            printInOrder(node.right);
        }
    }

    public void printPreOrder(Node node) {
        System.out.println(node.data + " ");
        if (node.left != null) {
            System.out.println("Traversing Left to Node: " + node.data);
            printPreOrder(node.left);
        }

        if (node.right != null) {
            System.out.println("Traversing Right to Node: " + node.data);
            printPreOrder(node.right);
        }
    }

    public Node delete(int value) {
        return deleteNode(this.root,value);
    }

    public Node deleteNode(Node root, int value) {
        if (root == null)
            return root;

        // Traverse left if data is less than root data
        if (value < root.data) root.left = deleteNode(root.left,value);
        // Traverse right if data is greater than root data
        else if (value > root.data) root.right = deleteNode(root.right,value);
        // Now we found the spot!!
        else {
            // Case 1 -> No Child
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2 -> One child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // Case 3 -> 2 Child
            else {
                // Get the minimum of right sub-tree as that is the possible value for right node
                // Or we can do maximum of left sub-tree and process the left node
                Node temp = findMin(root.right);
                System.out.println("MIN NODE:  " + temp.data);
                root.data = temp.data;
                root.right = deleteNode(root.right,temp.data);
            }
        }

        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String args[]) {

        BinaryTree bTree = new BinaryTree();
        bTree.insert(12);
        bTree.insert(5);
        bTree.insert(3);
        bTree.insert(1);
        bTree.insert(7);
        bTree.insert(9);
        bTree.insert(8);
        bTree.insert(11);
        bTree.insert(15);
        bTree.insert(13);
        bTree.insert(14);
        bTree.insert(16);
        bTree.insert(17);
        bTree.insert(20);
        bTree.insert(18);
        bTree.preOrderTraversal();
        bTree.delete(15);
        bTree.preOrderTraversal();
        bTree.postOrderTraversal();

    }
}
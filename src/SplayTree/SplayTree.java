package SplayTree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    @Override
    public void insert(T data) {
        //there are already items in BST
        if(root == null) {
            //empty BST
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.getData().compareTo(data) > 0) {
            //data is smaller than the value in the node -> go to the left
            if(node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<T>(data, node);
                node.setLeftChild(newNode);
                splay(newNode);
            }
        } else {
            //data is greater than the value in the node -> go to the right
            if(node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                Node<T> newNode = new Node<T>(data, node);
                node.setRightChild(newNode);
                splay(newNode);
            }
        }
    }

    public T getRoot() {
        if(root == null) {
            return null;
        }

        return root.getData();
    }

    //making rotations on the new node to become the root node
    private void splay(Node<T> node) {
        while( node.getParentNode() != null ) {
            //if the grandparent is null, simple rotation
            //ZIG CASE
            Node<T> parentNode = node.getParentNode();
            Node<T> grandParentNode = node.getParentNode().getParentNode();

            if(grandParentNode == null) {
                if(node.getParentNode().getLeftChild() == node) {
                    rightRotation(node.getParentNode());
                } else {
                    leftRotation(node.getParentNode());
                }
            }
            //ZIG-ZIG CASE
            else if (node.getParentNode().getLeftChild() == node && node.getParentNode().getParentNode().getLeftChild() == node.getParentNode()) {
                rightRotation(node.getParentNode().getParentNode());
                rightRotation(node.getParentNode());
            }
            else if (node.getParentNode().getRightChild() == node && node.getParentNode().getParentNode().getRightChild() == node.getParentNode()) {
                leftRotation(node.getParentNode().getParentNode());
                leftRotation(node.getParentNode());
            }
            //ZIG-ZAG CASE
            else if (node.getParentNode().getLeftChild() == node && node.getParentNode().getParentNode().getRightChild() == node.getParentNode()) {
                rightRotation(node.getParentNode());
                leftRotation(node.getParentNode());
            }
            else if (node.getParentNode().getRightChild() == node && node.getParentNode().getParentNode().getLeftChild() == node.getParentNode()) {
                leftRotation(node.getParentNode());
                rightRotation(node.getParentNode());
            }

        }
    }

    private void rightRotation(Node<T> node){
        System.out.println("Doing right rotation on node " + node);
        //this is the new root node after rotation
        Node<T> tempLeftChild = node.getLeftChild();
        Node<T> grandChild = tempLeftChild.getRightChild();

        //make the rotation . the new root node will be the tempLeftChild
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        //handle the parents
        if(grandChild != null) {
            grandChild.setParentNode(node);
        }

        //hande the parent for the node
        Node<T> tempParentNode = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParentNode);

        //we have to handle the parent node
        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }

        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }

        //if there is no parent node after the rotation
        if(root == node) { //root = node
            root = tempLeftChild;
        }

    }

    //it can be done in O(1)
    private void leftRotation(Node<T> node){
        System.out.println("Doing left rotation on node " + node);
        //this is the new root node after rotation
        Node<T> tempRightChild = node.getRightChild();
        Node<T> grandChild = tempRightChild.getLeftChild();

        //make the rotation . the new root node will be the tempLeftChild
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);

        //handle the parents
        if(grandChild != null) {
            grandChild.setParentNode(node);
        }

        //hande the parent for the node
        Node<T> tempParentNode = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParentNode);

        //we have to handle the parent node
        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }

        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }

        //if there is no parent node after the rotation
        if(root == node) { //root = node
            root = tempRightChild;
        }

    }


    private T find(T data, Node<T> node) {
        //this is when we look for a given item in the tree
        if(data.compareTo(node.getData()) < 0) {
            find(data, node.getLeftChild());
        } else if(data.compareTo(node.getData()) > 0) {
            find(data, node.getRightChild());
        } else {
            //ITEM FOUND
            splay(node);
            return data;
        }
        return null;
    }

    @Override
    public T find(T data) {
        if (root == null) return null;

        return find(data, root);
    }

    @Override
    public void traverse() {
        if (root != null) {
            traverse(root);
        }
    }

    private void traverse(Node<T> node) {
        if(node.getLeftChild() != null) {
            traverse(node.getLeftChild());
        }
        System.out.println(node.getData() + " - ");
        if (node.getRightChild() != null) {
            traverse(node.getRightChild());
        }
    }
}

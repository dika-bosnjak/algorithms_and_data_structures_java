package BinarySearchTrees;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> rootNode;

    private int sumValue;

    @Override
    public Node<T> getRoot() {
        return rootNode;
    }

    @Override
    public void insert(T data) {
        //there are already items in BST
        if(rootNode == null) {
            //empty BST
            rootNode = new Node<>(data, null);
        } else {
            insert(data, rootNode);
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.getData().compareTo(data) > 0) {
            //data is smaller than the value in the node -> go to the left
            if(node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                node.setLeftChild(new Node<>(data, node));
            }
        } else {
            //data is greater than the value in the node -> go to the right
            if(node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                node.setRightChild(new Node<>(data, node));
            }
        }
    }

    @Override
    public void remove(T data) {
        if (rootNode != null)
            remove(data, rootNode);
    }

    private void remove(T data, Node<T> node) {
        if (node == null) return;

        //search for the item we want remove
        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if(data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            //element founded

            //check if it is a leaf
            if(node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node...");
                //whether the node is a left child or right child
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(null);
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(null);
                }

                node = null;

            } else if (node.getLeftChild() == null && node.getRightChild() != null) {
                System.out.println("Removing a node with a left child...");
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }

                if (parent == null) {
                    rootNode = node.getRightChild();
                }

                node.getRightChild().setParentNode(parent);


            } else if (node.getLeftChild() != null && node.getRightChild() == null) {
                System.out.println("Removing a node with a right child...");
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }

                if (parent == null) {
                    rootNode = node.getLeftChild();
                }

                node.getLeftChild().setParentNode(parent);
                node = null;

            } else {
                System.out.println("Removing a node with two children...");
                //find the predecessor (max item on the left side)
                Node<T> predecessor = getPredecessor(node.getLeftChild());
                //swap the values
                T temp = node.getData();
                node.setData(predecessor.getData());
                predecessor.setData(temp);

                //recursive remove method on the predecessor
                remove(data, predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        return node;

    }

    @Override
    public void traversal() {

        if (rootNode == null) return;

        inOrderTraversal(rootNode);

    }

    //O(N)
    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node + " - ");

        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    public int getSumOfNodeValues (Node<T> node) {
        sumValue += node.toInt();

        if (node == null) {
            return 0;
        }
        if (node.getLeftChild() != null) {
            getSumOfNodeValues(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            getSumOfNodeValues(node.getRightChild());
        }
        return sumValue;
    }

    public Node<T> getKSmallest(Node<T> node, int k) {

        int mainTreeSize = treeSize(getRoot());

        if (k > mainTreeSize) return null;
        //number of nodes in the left subtree + root node
        int n = treeSize(node.getLeftChild()) + 1;

        //base case - kth the smallest element is found
        if (n == k) {
            return node;
        }

        //kth element is in the left subtree
        if (n > k) {
            return getKSmallest(node.getLeftChild(), k);
        }

        //kth element is in the right subtree
        if (n < k) {
            return getKSmallest(node.getRightChild(), k-n);
        }

        return null;
    }

    //size of the subtree (node is the "root")
    private int treeSize(Node<T> node) {
        //base case
        if (node == null) return 0;
        //size of tree = size of left subtree + size of right subtree + 1
        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
    }

    @Override
    public T getMin() {
        //leftmost child in the tree
        if (rootNode == null) { return null; }

        return getMin(rootNode);
    }

    @Override
    public T getMax() {
        //rightmost child in the tree
        if (rootNode == null) { return null; }

        return getMax(rootNode);
    }

    private T getMax(Node<T> node) {
        if(node.getRightChild() != null)
            return getMax(node.getRightChild());
        else {
            return node.getData();
        }
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild() != null)
            return getMin(node.getLeftChild());
        else {
            return node.getData();
        }
    }
}

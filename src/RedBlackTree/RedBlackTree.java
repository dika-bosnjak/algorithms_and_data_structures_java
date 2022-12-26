package RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        //there are already items in BST
        if(root == null) {
            //empty BST
            root = new Node<>(data, null);
            settleViolations(root);
        } else {
            insert(data, root);
        }
    }

   // O(logN)
    private void insert(T data, Node<T> node) {
        if (node.getData().compareTo(data) > 0) {
            //data is smaller than the value in the node -> go to the left
            if(node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<T>(data, node);
                node.setLeftChild(newNode);
                //WE HAVE TO CHECK whether the red black properties are violated or not
                settleViolations(newNode);
            }
        } else {
            //data is greater than the value in the node -> go to the right
            if(node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                Node<T> newNode = new Node<T>(data, node);
                node.setRightChild(newNode);
                //WE HAVE TO CHECK whether the red black properties are violated or not
                settleViolations(newNode);
            }
        }


    }

    @Override
    public void traverse() {

        if (root == null) return;

        traversal(root);

    }

    //O(N)
    private void traversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            traversal(node.getLeftChild());
        }
        System.out.print(node + " - ");

        if (node.getRightChild() != null) {
            traversal(node.getRightChild());
        }
    }

    //it can be done in O(1)
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

    @Override
    public void remove(T data) {
        if (root != null)
            remove(data, root);
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
                    root = node.getRightChild();
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
                    root = node.getLeftChild();
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

    //takes at most O(logN)
    private void settleViolations(Node<T> node) {

        Node<T> parentNode = null;
        Node<T> grandParentNode = null;

        //we have to check the violations up to the root node
        while(node != root && isRed(node) && isRed(node.getParentNode())) {

            parentNode = node.getParentNode();
            grandParentNode = node.getParentNode().getParentNode();

            //parent is a left child of it's parent (so the grandparent)
            if (parentNode == grandParentNode.getLeftChild()) {
                Node<T> uncle = grandParentNode.getRightChild();

                //case 1.) and case 4.) RECOLORING
                if (uncle != null && isRed(uncle)) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    if (node == parentNode.getRightChild()) {
                        //case 2. (uncle is null or black)
                        leftRotation(parentNode);
                        //update the references we keep going up to the root node
                        node = parentNode;
                        parentNode = grandParentNode;
                    }
                    //case 3.) rotation on the grandparent + parent and grandparent switch color
                    rightRotation(grandParentNode);
                    System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
                    //swap the color of the parent and the grandpa
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    //update the references because we keep going to the root node
                    node = parentNode;


                }
            } else {
                //parent is a right child of it's parent
                Node<T> uncle = grandParentNode.getLeftChild();
                //case 1.) and case 4.) symmetric partner
                if(uncle != null && isRed(uncle)) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    //case 2.) symmetric partner
                    if (node == parentNode.getLeftChild()) {
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = grandParentNode;
                    }

                    //case 3.) symmetric partner
                    leftRotation(grandParentNode);
                    System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            }
        }

        //root node must be BLACK
        if (isRed(root)) {
            System.out.println("Recoloring the root node");
            root.setColor(NodeColor.BLACK);
        }

    }

    private boolean isRed(Node<T> node) {
        if (node == null) {
            return false;
        }
        return node.getColor() == NodeColor.RED;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());

        }
        return node;

    }
}

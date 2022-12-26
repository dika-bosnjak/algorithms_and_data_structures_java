package AVLTree;

public class AVL<T extends Comparable<T>> implements Tree<T>{

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
        //settle violations
        updateHeight(node);
        settleViolations(node);
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
                //settle violations
                updateHeight(parent);
                settleViolations(parent);

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
                node = null;
                //settle the violations
                updateHeight(parent);
                settleViolations(parent);


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
                //settle the violations
                updateHeight(parent);
                settleViolations(parent);

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
    public void traverse() {

        if (root == null) return;

        traversal(root);

    }

    //O(N)
    private void traversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            traversal(node.getLeftChild());
        }
        System.out.println(node + " - " + node.getHeight() );

        if (node.getRightChild() != null) {
            traversal(node.getRightChild());
        }
    }

    private void settleViolations(Node<T> node) {

        //we have to check up to the root node
        while(node != null) {
            updateHeight(node);
            settleViolationsHelper(node);
            node = node.getParentNode();
        }
    }

    private void settleViolationsHelper(Node<T> node) {
        int balance = getBalance(node);

        //left heavy situation
        if(balance > 1) {
            //check whether it is left-right or left-left heavy situation

            //left right heavy situation
            if(getBalance(node.getLeftChild()) < 0) {
                leftRotation(node.getLeftChild());
            }

            //doubly left heavy situation then just a single right rotation is needed
            rightRotation(node);
        }

        if (balance < -1) {
            //check whether it is right-right or right-left heavy situation

            //right left heavy situation
            if(getBalance(node.getRightChild()) > 0) {
                rightRotation(node.getRightChild());
            }

            //doubly right heavy situation then just a single left rotation is needed
            leftRotation(node);
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

        updateHeight(node);
        updateHeight(tempLeftChild);

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

        updateHeight(node);
        updateHeight(tempRightChild);

    }

    //update the height of a given node
    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1 );
    }

    //returns the height parameter for a given node
    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    //balance factor to decide the left heavy or right heavy cases
    private int getBalance(Node<T> node) {
        if(node == null) return 0;

        return height(node.getLeftChild()) - height(node.getRightChild());
    }


}

package LinkedLists;

public class LinkedList<T extends Comparable<T>> implements  List<T>{

    private Node<T> root;
    private int numOfItems;

    public Node<T> getMiddleNode() {
        Node<T> slow = this.root;
        Node<T> fast = this.root;

        //O(N/2) = O(N)
        while(fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        return slow;
    }

    public void reverse() {
        Node<T> currentNode = root;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while(currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        root = previousNode;
    }

    @Override
    public void insert(T data) {

        if (root == null) {
            //this is the first item in the linked list
            root = new Node<>(data);
            numOfItems++;
        } else {
            //we know that this is not the first item in the linked list
            insertEnd(data, root);
            numOfItems++;

        }
    }

    //we just have to update the references O(1)
    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    //find the last node O(N)
    private void insertEnd(T data, Node<T> node) {
        //keep looking for the last node O(N)
        if (node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);

        }

    }

    @Override
    public void remove(T data) {

        if (root == null) return;

        //remove the root node
        if(root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            //this is the
            if(actualNode.getData().compareTo(data) == 0) {
                numOfItems--;
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        if (root == null) return;
        Node<T> actualNode = root;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }

    }

    @Override
    public int size() {
        System.out.println(numOfItems);
        return numOfItems;
    }
}

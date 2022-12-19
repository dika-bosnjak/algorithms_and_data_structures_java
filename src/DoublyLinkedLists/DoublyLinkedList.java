package DoublyLinkedLists;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        //first item in the linked lists
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            //insert the element at the end of the list
            //manipulate the tail node and its references in O(1)
            newNode.setPreviousNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    public void traverseForward() {
        Node<T> actualNode = head;

        while(actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    public void traverseBackward() {
        Node<T> actualNode = tail;

        while(actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getPreviousNode();
        }
    }
}

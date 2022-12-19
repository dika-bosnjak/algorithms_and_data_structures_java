package DoublyLinkedLists;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> previousNode;
    private Node<T> nextNode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + "}";
    }
}

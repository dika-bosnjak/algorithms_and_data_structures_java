package BinarySearchTrees;

public interface Tree<T> {

    public Node<T> getRoot();

    public Node<T> getKSmallest(Node<T> node, int k);

    public void insert(T data);
    public void remove(T data);
    public void traversal(); //in-order traversal yields the natural ordering

    public T getMin();
    public T getMax();
}

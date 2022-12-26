package RedBlackTree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> rbt = new RedBlackTree<Integer>();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(30);
        rbt.insert(40);

        rbt.traverse();
    }

}

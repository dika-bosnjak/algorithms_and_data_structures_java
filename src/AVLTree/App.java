package AVLTree;

public class App {
    public static void main(String[] args) {

        Tree<Integer> avl = new AVL<>();

        avl.insert(12);
        avl.insert(4);
        avl.insert(20);
        avl.insert(1);
        avl.insert(5);
        avl.insert(23);

        avl.remove(23);
        avl.remove(20);

        avl.traverse();

        System.out.println("----------------");

        Tree<Integer> avl2 = new AVL<>();

        avl2.insert(1);
        avl2.insert(2);
        avl2.insert(3);
        avl2.traverse();

        System.out.println("----------------");

        Tree<Integer> avl3 = new AVL<>();

        avl3.insert(3);
        avl3.insert(2);
        avl3.insert(1);
        avl3.traverse();

        System.out.println("----------------");

        Tree<Integer> avl4 = new AVL<>();

        avl4.insert(3);
        avl4.insert(1);
        avl4.insert(2);
        avl4.traverse();
    }
}

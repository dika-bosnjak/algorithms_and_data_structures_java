package SplayTree;

public class App {
    public static void main(String[] args) {

        Tree<Integer> splayTree = new SplayTree<Integer>();

        splayTree.insert(1);
        System.out.println(splayTree.getRoot());
        splayTree.insert(10);
        System.out.println(splayTree.getRoot());
        splayTree.insert(4);
        System.out.println(splayTree.getRoot());
        splayTree.insert(5);
        System.out.println(splayTree.getRoot());
        splayTree.insert(-2);
        System.out.println(splayTree.getRoot());

        splayTree.find(1);
        System.out.println(splayTree.getRoot());
    }
}

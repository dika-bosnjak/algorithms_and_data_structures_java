package BinarySearchTrees;

public class App {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();

        bst1.insert(12);
        bst1.insert(4);
        bst1.insert(20);
        bst1.insert(1);
        bst1.insert(8);
        bst1.insert(16);
        bst1.insert(27);
/*
        System.out.println(bst1.getMin());

        bst1.traversal();
        System.out.println();

        bst1.remove(16);
        bst1.traversal();
        System.out.println();
        bst1.remove(20);
        bst1.traversal();
        System.out.println();
        bst1.remove(12);
        bst1.traversal();
        System.out.println();
 */

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();

        bst2.insert(12);
        bst2.insert(4);
        bst2.insert(20);
        bst2.insert(1);
        bst2.insert(8);
        bst2.insert(16);
        bst2.insert(27);

        TreeCompareProblem<Integer> helper = new TreeCompareProblem<>();
        System.out.println(helper.compareTrees(bst1.getRoot(), bst2.getRoot()));

        System.out.println(bst1.getKSmallest(bst1.getRoot(),  5));

        System.out.println(bst1.getSumOfNodeValues(bst1.getRoot()));
    }

}

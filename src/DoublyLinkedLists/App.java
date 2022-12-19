package DoublyLinkedLists;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();

        names.insert("Adam");
        names.insert("John");
        names.insert("Jane");

        names.traverseForward();
        names.traverseBackward();

        //built in LinkedList
        LinkedList<String> dll = new LinkedList<>();
        dll.addFirst("Kevin");
        dll.add("John");
        dll.add("Jane");
        dll.removeFirst();
        dll.removeLast();

        //dll.clear();

        for(String name: dll) {
            System.out.println("DLL: " + name);
        }
    }
}

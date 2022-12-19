package LinkedLists;

public class App {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>();

        Person john = new Person(22, "John");


        people.insert(new Person(23, "Jane"));
        people.insert(john);
        people.insert(new Person(22, "Adam"));

        people.insert(new Person(22, "Kevin"));
        System.out.println("--------------------");

        System.out.println("Middle node is: " + people.getMiddleNode());

        people.traverse();
        people.remove(john);
        System.out.println("--------------------");
        people.traverse();
        System.out.println("--------------------");
        people.reverse();
        people.traverse();
    }
}

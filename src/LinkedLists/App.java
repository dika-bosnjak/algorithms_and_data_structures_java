package LinkedLists;

public class App {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>();

        Person john = new Person(22, "John");
        people.insert(new Person(23, "Jane"));
        people.insert(john);
        people.insert(new Person(22, "Adam"));

        people.traverse();
        people.remove(john);
        System.out.println("--------------------");
        people.traverse();
    }
}

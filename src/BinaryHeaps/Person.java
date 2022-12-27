package BinaryHeaps;

public class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(age, otherPerson.age);
    }
}

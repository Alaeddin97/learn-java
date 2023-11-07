package patterns;

import java.util.Objects;

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person=new Person("Peter",25);
        Person clonedPeter = (Person)person.clone();
        System.out.println("clonedPeter = " + clonedPeter.getName());
    }
}

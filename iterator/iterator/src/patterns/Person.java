package patterns;

public class Person implements Cloneable{
    public String name;
    public Integer age;

    public Person(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

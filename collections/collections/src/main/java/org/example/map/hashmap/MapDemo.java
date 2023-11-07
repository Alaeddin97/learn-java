package org.example.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapDemo {
    public static void main(String[] args) {

        Map<Integer, String> mapStr = new HashMap<>();
        mapStr.put(1, "Uno");
        mapStr.put(1, "One");
        mapStr.put(2, "Two");
        mapStr.put(3, "Three");

        displayMap(mapStr);

        mapStr.putIfAbsent(4, "Four");
        mapStr.computeIfPresent(2, (key, value) -> key + ":" + value);

        System.out.println();
        displayMap(mapStr);

        System.out.println("============================================================");

        Map<UserWithoutHashcode, Product> userWithoutHashcodeProductMap = new HashMap<>();
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(1, "Grigori", "Perlman", "grigori@gmail.com", "grigo123"),
                new Product(1, "Topology"));
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(2, "Marie", "Curie", "marie@gmail.com", "marie123"),
                new Product(2, "polonium"));
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(3, "Euler", "Euler", "euler@gmail.com", "euler123"),
                new Product(3, "Euler formula"));
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(4, "Maxwell", "Maxwell", "maxwell@gmail.com", "maxwell123"),
                new Product(4, "Maxwell Equations"));
        //displayMap(mapProduct);


        System.out.println("=======================================================================");
        System.out.println("Test without hashCode() overridden========================================");
        UserWithoutHashcode userCopy = new UserWithoutHashcode(2, "Marie", "Curie", "marie@gmail.com", "marie123");
        Product product = userWithoutHashcodeProductMap.get(userCopy); // Test before override hashCode()
        System.out.println("product = " + product); // null


        System.out.println("=======================================================================================================");
        System.out.println("Test with hashCode() overridden========================================");

        Map<UserWithHashCode, Product> userWithHashCodeProductMap = new HashMap<>();
        userWithHashCodeProductMap.put(
                new UserWithHashCode(1, "Grigori", "Perlman", "grigori@gmail.com", "grigo123"),
                new Product(1, "Topology"));
        userWithHashCodeProductMap.put(
                new UserWithHashCode(2, "Marie", "Curie", "marie@gmail.com", "marie123"),
                new Product(2, "polonium"));
        Product product1 = userWithHashCodeProductMap.get(new UserWithHashCode(2, "Marie", "Curie", "marie@gmail.com", "marie123"));
        System.out.println("product1 = " + product1);

    }

    private static <K, V> void displayMap(Map<K, V> mapStr) {
        for (K key : mapStr.keySet()) {
            System.out.println("key= " + key + ", value=" + mapStr.get(key));
        }
    }
}


class UserWithoutHashcode implements Comparable<UserWithoutHashcode> {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserWithoutHashcode() {
    }

    public UserWithoutHashcode(Integer id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public int compareTo(UserWithoutHashcode o) {
        return this.id-o.id;
    }
}

class Product {
    private Integer id;
    private String name;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class UserWithHashCode {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserWithHashCode() {
    }

    public UserWithHashCode(Integer id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        UserWithHashCode user = (UserWithHashCode) obj;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);

    }

}



















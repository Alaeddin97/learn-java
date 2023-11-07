package org.example.serialization;

import java.io.*;

public class Employee implements Serializable, Externalizable,Cloneable {
    private int id;
    private String firstName;
    private String lastName;
    private Product product;

    public Employee(){}
    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(int id, String firstName, String lastName, Product product) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", product=" + product +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(this.id);
        out.writeObject(this.firstName);
        out.writeObject("The best");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id=in.read();
        this.firstName=(String) in.readObject();
        this.lastName=(String) in.readObject();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Employee employee=(Employee) super.clone();
        employee.setProduct(new Product(this.product.getName(),this.product.getBrand()));
        return employee;
    }
}

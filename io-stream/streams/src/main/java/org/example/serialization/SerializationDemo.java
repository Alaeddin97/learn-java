package org.example.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        Employee employee=new Employee(1,"Grigori","Perlman");
        ByteArrayOutputStream serializedEmployee = serialize(employee);
        System.out.println("serializedEmployee = " + serializedEmployee);
        Employee deserializedEmployee = deserialize(serializedEmployee);
        System.out.println("deserializedEmployee = " + deserializedEmployee);

        System.out.println();
        System.out.println();

        Product product=new Product("V0.0","Tesla");
        Employee employee1=new Employee(2,"Cedric","Villani",product);
        Employee copyEmployee = (Employee)employee1.clone();
        System.out.println("copyEmployee = " + copyEmployee);
        copyEmployee.getProduct().setBrand("Toyota");
        System.out.println("Product: " + product);
    }

    private static ByteArrayOutputStream serialize(Employee employee) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try (var oos = new ObjectOutputStream(byteArrayOutputStream)) {
            oos.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
    private static Employee deserialize(ByteArrayOutputStream baos) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream objectInputStream=new ObjectInputStream(bais);
        Object o = objectInputStream.readObject();
        return (Employee) o;
    }
}

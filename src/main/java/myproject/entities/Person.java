package myproject.entities;

import java.util.Objects;


public class Person {
    private String name;
    private String lastname;
    private int age;
    private String phoneNumber;


    public Person(String name, String lastname, int age, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(name, lastname, age, phoneNumber);
        System.out.println("Hash code of a User: " + hash);
        return hash;
    }

    public static String toString(Person person) {
        return "User\n" +
                "Name: " + person.getName() + "\n" +
                "Last Name: " + person.getLastname() + "\n" +
                "Age: " + person.getAge() + "\n" +
                "Phone number: " + person.getPhoneNumber();
    }

}

package org.example;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(@JsonProperty("lastName") String lastName,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("age") int age){

        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(firstName, person.firstName);

    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

package org.example;

import com.fasterxml.jackson.databind.ObjectMapper; // Імпорт бібліотеки для роботи з JSON

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Jack","Jac",20);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(person);

            System.out.println(("JSON рядок: " + json));

            Person convertedPerson = objectMapper.readValue(json, Person.class);

            boolean areEqual = person.equals(convertedPerson);
            System.out.println("Equals: " + areEqual);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
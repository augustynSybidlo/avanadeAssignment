package service;

import model.Person;

import java.util.*;

public class Transform {

    private List<Person> input;

    public Transform(List<Person> input) {
        this.input = input;
    }

    public List<Person> getOutput() {
        return this.transform();
    }

    private List<Person> transform() {
        Map<String, Integer> map = mapPerson();
        List<Person> output = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int age = entry.getValue();
            Person person = new Person(name, age);
            output.add(person);
        }

        return this.sortByName(output);
    }

    private Map<String, Integer> mapPerson() {
        Map<String, Integer> map = new HashMap<>();
        for(Person person : input) {
            String name = person.getName();
            if(map.containsKey(name)) {
                int age = map.get(name);
                int newAge = age + person.getAge();
                map.put(name, newAge);
            } else {
                int age = person.getAge();
                map.put(name, age);
            }
        }
        return map;
    }


    private List<Person> sortByName(List<Person> input) {
        Collections.sort(input,
                (person1, person2) -> person1.getName().compareTo(person2.getName()));
        return input;
    }
}

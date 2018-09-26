package service;

import model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transform {

    private List<Person> input;

    public Transform(List<Person> input) {
        this.input = input;
    }

    public List<Person> transform() {
        Map<String, Integer> map = mapPerson();
        List<Person> output = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int age = entry.getValue();
            Person person = new Person(name, age);
            output.add(person);
        }
        return output;
    }

    private Map<String, Integer> mapPerson() {
        Map<String, Integer> map = new HashMap<>();
        for(Person person : input) {
            String name = person.getName();
            int age = map.get(name);
            if(map.containsKey(name)) {
                int newAge = age + person.getAge();
                map.put(name, newAge);
            } else {
                map.put(name, age);
            }
        }
        return map;
    }
}

package view;

import model.Person;

import java.util.List;

public class PersonView {

    public PersonView() {}

    public void displayPersons(List<Person> input) {
        for(Person person : input) {
            System.out.println(person.toString());
        }
    }
}

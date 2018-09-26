package controller;

import model.Person;
import service.Transform;
import view.PersonView;

import java.util.List;

public class TransformController {

    private Transform transform;
    private PersonView view;

    public TransformController(Transform transform, PersonView view) {
        this.transform = transform;
        this.view = view;
    }

    public void run() {
        List<Person> output = transform.getOutput();
        view.displayPersons(output);
    }
}

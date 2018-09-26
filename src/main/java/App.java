import controller.TransformController;
import model.Person;
import service.Transform;
import view.PersonView;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<Person> setup() {
        List<Person> input = new ArrayList<>();
        input.add(new Person("Adam", 12));
        input.add(new Person("Arek", 44));
        input.add(new Person("Adam", 24));
        input.add(new Person("Zosia", 9));
        input.add(new Person("Wiola", 7));
        input.add(new Person("Arek", 20));

        return input;
    }

    public static void main(String[] args) {
        Transform transform = new Transform(App.setup());
        TransformController controller = new TransformController(transform, new PersonView());
        controller.run();
    }
}

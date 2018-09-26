import controller.TransformController;
import dao.PersonDAO;
import dao.PersonFromCVS;
import model.Person;
import service.CSValidator;
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

    private static List<Person> setup(String path, int numberOfColumns) {
        PersonDAO dao = new PersonFromCVS(path, new CSValidator(), numberOfColumns);
        return dao.read();
    }

    public static void main(String[] args) {
//        Transform transform = new Transform(setup());
//        TransformController controller = new TransformController(transform, new PersonView());
//        controller.run();
//        Transform transform = new Transform(setup(args[0], 2));
//        TransformController controller = new TransformController(transform, new PersonView());
//        controller.run();

        Transform transform = new Transform(setup("/Users/augustyn/Documents/GitHub/" +
                "assignment-augustynSybidlo/src/main/resources/test.csv", 2));
        TransformController controller = new TransformController(transform, new PersonView());
        controller.run();
    }
}

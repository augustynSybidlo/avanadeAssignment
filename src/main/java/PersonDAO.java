import model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> read();
    List<Person> write();
}

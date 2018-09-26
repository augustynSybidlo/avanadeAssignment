package dao;

import model.Person;
import service.CSValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFromCVS implements PersonDAO {

    private String path;
    private CSValidator validator;
    private int numberOfColumns;

    public PersonFromCVS(String path, CSValidator validator, int numberOfColumns) {
        this.path = path;
        this.validator = validator;
        this.numberOfColumns = numberOfColumns;
    }

    @Override
    public List<Person> read() {
        List<Person> input = new ArrayList<>();
        File fileToRead = new File(path);
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        int nameIndex = 0;
        int ageIndex = 1;
        Person person = null;

        try {
            br = new BufferedReader(new FileReader(fileToRead));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                String name = data[nameIndex];
                String age = data[ageIndex];
                if(validator.validateArray(data, numberOfColumns)
                        && validator.validateName(name)
                        && validator.validateAge(age)) {
                    int ageAsInt = Integer.parseInt(age);
                    person = new Person(name, ageAsInt);
                    input.add(person);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return input;
    }

    @Override
    public List<Person> write() {
        return null;
    }


}

package ssf.day18_am.services;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.day18_am.model.Person;
import ssf.day18_am.repositories.ListRepo;

@Service
public class PersonService {

    @Autowired
    private ListRepo listRepo;

    public String generateId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void insertPerson(Person person) {
        listRepo.leftPush("person", person.toString());
    }

    public List<Person> getPersons() {
        List<Person> personList = new LinkedList<>();
        for(String person : listRepo.getList("person")) {
            String[] details = person.split("\\,");
            Person p = new Person(details[0], details[1], details[2], details[3], details[4]);
            personList.add(p);
        }
        return personList;
    }

    
}

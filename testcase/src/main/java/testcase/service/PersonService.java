package testcase.service;




import java.util.ArrayList;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import testcase.model.Person;
import testcase.model.PersonDao;
@Service
public class PersonService {

/*
Hashtable <String,Person> persons=new Hashtable<String,Person>();
public PersonService(){
	Person p=new Person();
	p.setId("1");
    p.setName("supriya");
    p.setAge(21);
    persons.put("1", p);
    
    p=new Person();
	p.setId("2");
    p.setName("suvarna");
    p.setAge(18);
    persons.put("2", p);
}

*/
	@Autowired
private PersonDao persondao;
	
	

	public Person getUser(long id)
	{
		return persondao.findOne(id);
	}


public void save(Person person) {
	persondao.save(person);
	
}

public void updatePerson(long id, Person person) {
	person.setId(id);
	persondao.save(person);
	
}
public List<Person> getAllUser()
{
	List<Person> person=new ArrayList<>();
	persondao.findAll().forEach(person::add);
	return person;
}
public void delete(long id) {
		persondao.delete(id)	;
}
/*
public Hashtable<String,Person>getAll(){
	return persons;
}
*/
}

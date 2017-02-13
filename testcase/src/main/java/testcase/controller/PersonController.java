package testcase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testcase.model.Person;

import testcase.service.PersonService;
@CrossOrigin
@RestController
public class PersonController {
	Person Person;
	@Autowired
	private PersonService ps;
	
	
	//GET METHOD
	@RequestMapping("/user")
	public List<Person> getAllUser()
	{
		List<Person> person= ps.getAllUser();
		System.out.println("persons in database are as ");
		return person;
	}
	
	//POST METHOD
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String create(@RequestBody Person person){
		try{
			ps.save(person);
			System.out.println("inside creation");
			
		}
		catch(Exception ex){
			return "error creating user:"+ex.toString();
			}
		return "person is  created successfully....";
		
	}
	
	
	
	//DELETE METHOD
	@RequestMapping(method=RequestMethod.DELETE,value="/person/{id}")
	public String delete(@PathVariable long id){
		try{
			
				ps.delete(id);
				System.out.println("inside deletion");
				
			}
			catch(Exception ex){
				return "error deleting user:"+ex.toString();
			}
			return "person is successfully deleted....";
	}
	
	
	
//PUT METHOD
	@RequestMapping(method=RequestMethod.PUT,value="/person/{id}")
	public String updateperson(@RequestBody Person person,@PathVariable long id){
		
		try{
			person.setId(id);
			ps.save(person);
			System.out.println("inside updation");
		}
		catch(Exception ex){
			return "error oudating user:"+ex.toString();
			}
		return "person is updated successfully.....";
	}
	
}


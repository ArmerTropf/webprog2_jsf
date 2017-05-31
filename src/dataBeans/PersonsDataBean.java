package dataBeans;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonsDataBean  {

	private List<PersonDataBean> persons = new ArrayList<PersonDataBean>();
	
	public PersonsDataBean(List<Person> persons){ 
		
		for (Person person : persons) {
			this.persons.add(new PersonDataBean(person));
		}
		
	}
	
	public List<PersonDataBean> getPersons() {
		return this.persons;
	}
}

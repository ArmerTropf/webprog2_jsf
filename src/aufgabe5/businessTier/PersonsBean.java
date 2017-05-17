package aufgabe5.businessTier;

import java.util.List;

import aufgabe5.dataTier.IDataTier;
import aufgabe5.model.Person;

public class PersonsBean {

	private IDataTier<Person> dt;

	public PersonsBean(IDataTier<Person> dt) {
		this.dt = dt;
	}
	
	public Person getPerson(int id){
		return dt.get(id);
	}
	
	public Person getPersonByName(String name){
		List<Person> allPersons = dt.getAllItems();
		
		return dt.get(name);
	}
	
	public List<Person> getAllPersons(){
		return dt.getAllItems();
	}

}

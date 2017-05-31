package businessTier;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dataTier.IDataTier;
import model.Person;

@ManagedBean(name="personsBean")
@SessionScoped
public class PersonsBean {

	//hier kann die DataTier gewechselt werden(Dummy oder XML)
	@ManagedProperty(value = "#{personXMLDataTier}")

	private IDataTier<Person> dataTier;

//	public PersonsBean(IDataTier<Person> dataTier) {
//		this.dataTier = dataTier;
//	} 
	
	public Person getPerson(int id){
		return dataTier.get(id);
	}
	
	//NICHT FERTIG
	public void addPerson(String vorname, String nachname, String wohnort) {
		Person newPerson = new Person();
		newPerson.setVorname(vorname);
		newPerson.setNachname(nachname);
		newPerson.setWohnort(wohnort);
					
	}
	
	public Person getPersonByName(String name){
		List<Person> allPersons = dataTier.getAllItems();
		Person pers =  null;
		
		for (Person person : allPersons) {
			if (person.getVorname().equals(name))
			{
				pers = person;
				return pers;
			}
				
		}
		
		return pers;
		
	}
	
	public List<Person> getAllPersons(){
		return dataTier.getAllItems();
	}

	
	public void setDataTier(IDataTier<Person> dataTier) {
		this.dataTier = dataTier;
	}

}

package aufgabe5.businessTier;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import aufgabe5.dataTier.IDataTier;
import aufgabe5.model.Person;

@ManagedBean(name="personsBean")
@SessionScoped
public class PersonsBean {

	//hier kann die DataTier gewchselt werden(Dummy oder XML)
	@ManagedProperty(value = "#{personDataTier}")
	private IDataTier<Person> dataTier;

//	public PersonsBean(IDataTier<Person> dataTier) {
//		this.dataTier = dataTier;
//	} 
	
	public Person getPerson(int id){
		return dataTier.get(id);
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

package dataTier;

import javax.faces.bean.ManagedBean;

import model.Person;
@ManagedBean(name="personDummyDataTier")
public class PersonDummyDataTier extends CacheDataTier<Person> {
	
	public PersonDummyDataTier(){
		Person person = new Person();
		
		person.setVorname("hans");
		person.setNachname("wurst");
		person.setWohnort("milchsstra�e");
		add(person);
	}
}

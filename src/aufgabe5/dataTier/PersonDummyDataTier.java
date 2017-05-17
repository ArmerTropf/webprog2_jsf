package aufgabe5.dataTier;

import aufgabe5.model.Person;

public class PersonDummyDataTier extends CacheDataTier<Person> {
	
	public PersonDummyDataTier(){
		Person person = new Person();
		
		person.setVorname("hans");
		person.setNachname("wurst");
		person.setWohnort("milchsstraﬂe");
		add(person);
	}
}

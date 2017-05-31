package dataBeans;

import model.Person;

public class PersonDataBean extends DataBean<Person> {
	
	public PersonDataBean(Person person){
		model = person;
	}
	
	public String getVorname(){
		return model.getVorname();
	}
	
	public String getNachname(){
		return model.getNachname();
	}
	
	public String getWohnort(){
		return model.getWohnort();
	}
}

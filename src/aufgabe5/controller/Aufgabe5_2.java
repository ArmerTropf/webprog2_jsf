package aufgabe5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import aufgabe5.businessTier.PersonsBean;
import aufgabe5.businessTier.PersonsFactory;
import aufgabe5.dataBeans.PersonDataBean;
import aufgabe5.dataBeans.PersonsDataBean;
import aufgabe5.model.Person;

/**
 * Servlet implementation class Aufgabe5_2
 */
// @WebServlet("/Aufgabe5_2")

@ManagedBean(name = "Aufgabe5_2")
@SessionScoped
public class Aufgabe5_2 {
	
	private String name = "";
	
	public void setName(String name) { this.name = name;}
	public String getName() { return this.name;}
	
	
	
	@ManagedProperty(value="#{personsBean}")
	private PersonsBean persons;

	public void setPersons(PersonsBean persons) {
		this.persons = persons;
	}

	String jsp;
	private List<PersonDataBean> user = new ArrayList<PersonDataBean>();

	public Aufgabe5_2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		// persons = new PersonsBean(new PersonDummyDataTier());
		// persons = PersonsFactory.getNewDummyPersonsBean();
//		persons = PersonsFactory.getNewXMLPersonsBean();

	}

	
	public List<PersonDataBean> getList() {

//		 String action =
//		 FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("action");

		PersonsDataBean personsData = new PersonsDataBean(persons.getAllPersons());
		user.clear();
		for (PersonDataBean personDataBean : personsData.getPersons()) {
			
			user.add(personDataBean);
		}

		jsp = "Listenausgabe";
		return user;

	}

	public List<PersonDataBean> getDetail(int userID) {

		
		String action =
				 FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("vorname");
		Person person = persons.getPerson(userID);
		user.clear();
		
		if (person == null)
			System.out.println("keine person");
	
		PersonDataBean personData = new PersonDataBean(person);
		user.add(personData);

		jsp = "Detailausgabe";
		return user;
	}

	public String getSearch() {

//		String vorname = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("vorname");
//		System.out.println(vorname);

		user.clear();
		Person person = persons.getPersonByName(this.name);
		if (person == null)
			return "index";
		PersonDataBean personData = new PersonDataBean(person);
		user.add(personData);

		jsp = "Detailausgabe.xhtml";
		return jsp;
	}

	public List<PersonDataBean> getUser() {
		return this.user;
	}

}

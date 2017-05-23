package aufgabe5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import aufgabe5.businessTier.PersonsBean;
import aufgabe5.businessTier.PersonsFactory;
import aufgabe5.dataBeans.PersonDataBean;
import aufgabe5.dataBeans.PersonsDataBean;
import aufgabe5.dataTier.PersonDummyDataTier;
import aufgabe5.model.Person;

/**
 * Servlet implementation class Aufgabe5_2
 */
// @WebServlet("/Aufgabe5_2")

@ManagedBean(name = "Aufgabe5_2")
@SessionScoped
public class Aufgabe5_2 {
	private PersonsBean persons;

	String jsp;
	private List<PersonDataBean> user = new ArrayList<PersonDataBean>();

	public Aufgabe5_2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

//		 persons = new PersonsBean(new PersonDummyDataTier());
//		 persons = PersonsFactory.getNewDummyPersonsBean();
		persons = PersonsFactory.getNewXMLPersonsBean();

	}

	public List<PersonDataBean> getList() {

		// String action =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("action");

		PersonsDataBean personsData = new PersonsDataBean(persons.getAllPersons());
		user.clear();
		for (PersonDataBean personDataBean : personsData.getPersons()) {
			System.out.println(personDataBean.getVorname());
			user.add(personDataBean);
		}

		return user;

	}

	public String getDetail(int userID) {

		Person person = persons.getPerson(userID);
//		user.clear();
		
		if (person == null)
			return "index";
		PersonDataBean personData = new PersonDataBean(person);
		user.add(personData);

		jsp = "Detailausgabe";
		return jsp;
	}

	public String getSearch(int action) {

		//String action = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("gogo");

		
		Person person = persons.getPerson(action);
		if (person == null)
			return "index";
		PersonDataBean personData = new PersonDataBean(person);
		user.add(personData);

		jsp = "Detailausgabe";
		return jsp;
	}

	public List<PersonDataBean> getUser() {
		return this.user;
	}

}

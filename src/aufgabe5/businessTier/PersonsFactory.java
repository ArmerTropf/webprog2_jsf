package aufgabe5.businessTier;

import aufgabe5.dataTier.PersonDummyDataTier;
import aufgabe5.dataTier.PersonXMLDataTier;

public class PersonsFactory {

	
	private PersonsFactory() {
		
	}
	
	public static PersonsBean getNewDummyPersonsBean() {
				
		return new PersonsBean(new PersonDummyDataTier());
		
	}
	
	public static PersonsBean getNewXMLPersonsBean() {
		return new PersonsBean(new PersonXMLDataTier());	
	}
	
	
}

package aufgabe5.dataBeans;

import aufgabe5.model.Model;

public abstract class DataBean<T extends Model> {
	
	protected T model;
	
	public int getId() {
		return model.getId();
	}
}


package dataBeans;

import model.Model;

public abstract class DataBean<T extends Model> {
	
	protected T model;
	
	public int getId() {
		return model.getId();
	}
}


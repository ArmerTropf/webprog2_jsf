package dataTier;

import java.util.List;

import model.Model;

public interface IDataTier<T extends Model> {
	
	public List<T> getAllItems();
	
	public T get(int id);
	
//	public T getByName(String name);
	
	public void add(T obj);
	
	public void remove(T obj);
	
}

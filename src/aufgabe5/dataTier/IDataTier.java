package aufgabe5.dataTier;

import java.util.List;

import aufgabe5.model.Model;

public interface IDataTier<T extends Model> {
	
	public List<T> getAllItems();
	
	public T get(int id);
	
	public void add(T obj);
	
	public void remove(T obj);
	
}

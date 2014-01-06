package data;

import java.util.List;

import model.Child;
import model.Present;

public interface IDAOChild {

	public Child addChild(Child child, Present present);
	
	public Child getChild(long id);
	
	public Child updateChildNaughty(long idChild, boolean isNaughty);
	
	public Child approveChildPresent(long idChild, long idPresent);
	
	public List<Child> queryChild(String query);
	
	public List<Child> getStock();

	public void makePresent(long id);
	
	public Present getChildCriteria(String c1, String c2);
}

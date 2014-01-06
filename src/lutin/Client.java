package lutin;

import java.util.List;

import model.Child;

import data.DAOChild;
import data.IDAOChild;

public class Client {

	public static void listChildren() {
		IDAOChild dao = new DAOChild();
		
		String query1 = "from Child";
		List<Child> queryChild = dao.queryChild(query1);
System.out.println(queryChild.size());
		for(Child child : queryChild) {
			System.out.println(child.getId() + " " + child.getName() + " " 
					+ child.getIsNaughty() + " " + child.getPresent().getName() + " "
					+ child.getPresent().getIsValid() + " " + child.getPresent().getIsValid());
		}

		
	}

	
	public static void goodChildren(){
		IDAOChild dao = new DAOChild();
		String query2 = "select c from Children c where c.isNaughty=no";
		List<Child> goodChildren = dao.queryChild(query2);
		
		for(Child child : goodChildren) {
			System.out.println(child.getId() + child.getCity() + child.getName());
		}
	}
	
	public static void made(int id){
		IDAOChild dao = new DAOChild();
		dao.makePresent(id);
		
	}
	
	
	
/*
	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	URI uri = UriBuilder.fromUri("http://localhost:8080/AARProject2/Enfant/MyWish").build();
	WebResource service = client.resource(uri);
	System.out.println(service.path("aaa").path("zzz").path("sss").get(ClientResponse.class));
*/
}
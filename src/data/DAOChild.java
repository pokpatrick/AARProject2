package data;

import java.util.ArrayList;
import java.util.List;

import model.Child;
import model.Children;
import model.Present;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DAOChild implements IDAOChild {

	public Present getPresent(long childId) {
		Session session = null;
		
		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Child child = (Child)session.get(Child.class, childId);
			Present present = child.getPresent();
			tx.commit();
			
			return present;
		} catch( Exception e ) {
			e.printStackTrace();
		}	
			
		return null;
	}
	
	public Present getChildCriteria(String c1, String c2) {
		Session session = null;
		ArrayList<Child> myArray = new ArrayList<Child>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
		
			for(Object o : session.createCriteria(Child.class).
					add(Restrictions.like("name", c1)).
					add(Restrictions.like("city", c2)).list()) {
				myArray.add((Child) o);
			}
				
			tx.commit();
			return myArray.get(0).getPresent();
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Child addChild(Child child, Present present) {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			
			child.setPresent(present);
			session.save(present);
			session.save(child);
			tx.commit();
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
		return child;
	}

	@Override
	public Child getChild(long id) {
		Session session = null;
		
		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Child child = (Child)session.get(Child.class, id);
			tx.commit();
			
			return child;
		} catch( Exception e ) {
			e.printStackTrace();
		}	
			
		return null;
	}

	@Override
	public List<Child> getStock() {
		Session session = null;
		List<Child> a = new Children();
		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Query queryResult = session.createQuery("from Child");
			
			for(Object o : queryResult.list()) {
				a.add((Child) o);
			}
			tx.commit();
			
			return a;
		} catch( Exception e ) {
			e.printStackTrace();
		}	
			
		return null;
	}

	@Override
	public Child updateChildNaughty(long id, boolean isNaughty) {
		Session session = null;
		
		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Child child = (Child)session.get(Child.class, id);
			
			if(child == null) {
				return null;
			}
			
			child.setIsNaughty(isNaughty);
			session.save(child);
			tx.commit();
			
			return child;
		} catch( Exception e ) {
			e.printStackTrace();
		}	
			
		return null;
	}
	
	@Override
	public Child approveChildPresent(long id, long idPresent) {
		Session session = null;
		
		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Child child = (Child)session.get(Child.class, id);
			if(child.getIsNaughty()) {
				return child;
			} else {
				child.getPresent().setIsValid(true);
			}
			session.save(child);
			tx.commit();
			
			return child;
		} catch( Exception e ) {
			e.printStackTrace();
		}	
			
		return null;
	}

	@Override
	public List<Child> queryChild(String query) {
		Session session = null;
		List<Child> a = new ArrayList<Child>();
		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Query queryResult = session.createQuery(query);
			
			for(Object o : queryResult.list()) {
				a.add((Child) o);
			}
			tx.commit();
			
			return a;
		} catch( Exception e ) {
			e.printStackTrace();
		}	
			
		return null;
	}

	@Override
	public void makePresent(long id) {
		Session session = null;

		try {		
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			// recupere l'id du cadeau de l'enfant
			Query queryResult = session.createQuery(
					"select c.present.id from Children c where c.isNaughty = no and c.id = " + id);

			if (queryResult.list()!=null){
				int idP = (int) queryResult.list().get(0);
				// recupere le cadeau
				Present present = (Present)session.get(Present.class, idP);

				present.setIsMade(true);
				tx.commit();
				session.update(present);
				System.out.println("Present Made !");
			}
			else{
				System.out.println("Present not made, child is naughty or present not found!");

				tx.commit();
			}

		} catch( Exception e ) {
			e.printStackTrace();
		}	


	}

}

package solution;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Test {
	private static final String PERSISTENCE_UNIT_NAME = "my_oshop";
	private static EntityManagerFactory emf;	
	

	public static void main(String[] args){
				//connection to the database
				emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = emf.createEntityManager();
				
				
				
				TypedQuery<Customer> tq1 = em.createNamedQuery("Customer.loadCustomerByName", Customer.class);
				tq1.setParameter("name", "Anton Designs, Ltd.");
				Customer cus = tq1.getSingleResult();
				System.out.println(cus.getcFirstName() +", " + cus.getcLastName() + ", " + cus.getCountry());
				
				
				
				//an error happens because of this block of code
				TypedQuery<Product> tq2 = em.createNamedQuery("Product.loadProductByName", Product.class);
				tq1.setParameter("name", "1969 Harley Davidson Ultimate Chopper");
				Product prod = tq2.getSingleResult();
				System.out.println(prod.getProductNumber() +", " + prod.getQty());
				
				
				
			    
			    
				//check if Customer entity works
				Customer newCustomer = new Customer();
				newCustomer.setName("The");
				newCustomer.setcFirstName("Donald");
				newCustomer.setcLastName("Duck");
				newCustomer.setPhoneNumber("004915151515");
				newCustomer.setAddress1("Gutenbergstr.");
				newCustomer.setCity("Ulm");
				newCustomer.setCountry("Germany");
				
				
				//check if Product entity works
			    Order newOrder = new Order();
			    String str="2015-03-31";  
			    Date date = Date.valueOf(str);
			    newOrder.setoDate(date);
			    newOrder.setrDate(date);
			    newOrder.setoStatus("Shipped");
	
			    
			    
				newCustomer.addOrder(newOrder);
				em.persist(newCustomer);
				em.persist(newOrder);
			    em.getTransaction().begin();
				em.getTransaction().commit();	
				
				
	}
	
}

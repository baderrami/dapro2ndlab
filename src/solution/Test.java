package solution;

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
				tq1.setParameter("customerName", "Anton Designs, Ltd.");
				Customer cus = tq1.getSingleResult();
				System.out.println(cus.getcFirstName() +", " + cus.getcLastName());
				
				TypedQuery<Product> tq2 = em.createNamedQuery("Product.loadProductByName", Product.class);
				tq1.setParameter("productName", "1969 Harley Davidson Ultimate Chopper");
				Product prod = tq2.getSingleResult();
				System.out.println(prod.getProductNumber() +", " + prod.getQty());
				
				
				
			    
			    
				//check if Customer entity works
				Customer newCustomer = new Customer();
				newCustomer.setName("Donald");
				
				
				//check if Product entity works
			    Order newOrder = new Order();
			    newOrder.setoStatus("Shipped");
	
			    
			    
				newCustomer.addOrder(newOrder);
				em.persist(newCustomer);
				em.persist(newOrder);
			    em.getTransaction().begin();
				em.getTransaction().commit();	
				
				
	}
	
}

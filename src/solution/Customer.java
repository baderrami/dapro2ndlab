package solution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@NamedQuery(
			name="Customer.loadCustomerByName",
			query="SELECT c FROM Customer c " +
			"WHERE c.name =:name")


@Entity
@Table(name= "customer")
public class Customer {
	
	@Id 
	@Column(name= "customerNumber", nullable = false, length = 11)
	private int customerNumber;
	
	@Column(name= "customerNAME", nullable = false, length = 50)
	private String name;
	
	@Column(name= "contactLastName", nullable = false, length = 50)
	private String cLastName;
	
	@Column(name= "contactFirstName", nullable = false, length = 50)
	private String cFirstName;
	
	@Column(name= "phone", nullable = false, length = 50)
	private String phoneNumber;
	
	@Column(name= "addressLine1", nullable = false, length = 50)
	private String address1;
	
	@Column(name= "addressLine2", nullable = false, length = 50)
	private String address2;
	
	private String city;
	
	private String state;
	
	private int postalCode;
	
	private String country;
	
	private BigDecimal creditLimit;
		
	// 1:N Relationship Bidirectional with Order
	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<Order>();
	
	//Entity Link 1:N -- Create link and Delete link
	//a hand shake between the customer and orders 
	public void addOrder(Order order) {
		order.setCustomer(this);
		orders.add(order);
	}
	public void deleteOrder(Order order) {
		orders.remove(order);
	}
	
	//auto generated getters and setters. 
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcLastName() {
		return cLastName;
	}
	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}
	public String getcFirstName() {
		return cFirstName;
	}
	public void setcFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
}

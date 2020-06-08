package solution;

import java.sql.Date;

import java.util.List;

import javax.persistence.*;



@NamedQuery(
	      name="`order`.getOrderDateByCustomerNumber",
	      query = "SELECT o FROM `order` o JOIN o.customer c WHERE c.customerNumber=:customernumber"
	)


@Entity
@Table(name= "order")
public class Order {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name= "orderNumber")
	private int orderNumber;
	
	@Column(name= "orderDate")
	@Temporal(TemporalType.DATE)
	private Date oDate;
	
	@Column(name= "requiredDate")
	@Temporal(TemporalType.DATE)
	private Date rDate;
	
	@Column(name= "shippedDate")
	@Temporal(TemporalType.DATE)
	private Date sDate;
	
	@Column(name= "status")
	private String oStatus;
	
	@Column(name= "status")
	private String comments;
	
	// N:1 Relationship Bidirectional with Customer
	@ManyToOne
	@JoinColumn(name ="CUSTOMERNUMBER", nullable=false)
	private Customer customer;
	
	// 1:N Relationship Bidirectional with OrderDetail
	@OneToMany(mappedBy= "order")
	private List<OrderDetail> orderDetails;
	
	//Entity Link 1:N -- Create link and Delete link
	//a hand shake between the Order and OrderDetail 
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetail.setOrder(this);
		orderDetails.add(orderDetail);
	}
	public void deleteOrder(OrderDetail orderDetail) {
		orderDetails.remove(orderDetail);
	}
	
	
	//auto generated getters and setters. 
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public String getoStatus() {
		return oStatus;
	}
	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	

}

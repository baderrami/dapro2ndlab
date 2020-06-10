package solution;

import java.math.BigDecimal;

import javax.persistence.*;



//I have no idea how to create this name query, the question interface is confusing. 

@Entity
@Table(name= "orderdetail")
public class OrderDetail {
	
	@Id 
	private int orderDetailNumber;
	
	@Column(name= "quantityOrdered")
	private int qtyOrdered;
	
	@Column(name= "priceEach")
	private BigDecimal price;
	
	@Column(name= "orderLineNumber")
	private int lineNumber;
	
	// N:1 Relationship Bidirectional with Order
	@ManyToOne 
	@JoinColumn(name="ORDERNUMBER", nullable=false)
	private Order order;
	
	
	//auto generated getters and setters. 
	public int getOrderDetailNumber() {
		return orderDetailNumber;
	}
	public void setOrderDetailNumber(int orderDetailNumber) {
		this.orderDetailNumber = orderDetailNumber;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}

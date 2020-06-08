package solution;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;



@NamedQuery(
			name="Product.loadProductByName",
			query="SELECT p FROM Product p" +
			"WHERE p.product =:name")


@Entity
@Table(name= "product")
public class Product {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name= "productCode", nullable = false, length = 11)
	private int productNumber;
	
	@Column(name= "productName", nullable = false, length = 70)
	private String name;
	
	@Column(name= "productScale", nullable = false, length = 10)
	private String scale;
	
	@Column(name= "productDescription")
	private String description;
	
	@Column(name= "quantityInStock", nullable = false, length = 6)
	private int qty;
	
	@Column(name= "buyPrice")
	private BigDecimal price;
	
	@Column(name= "MSRP")
	private double MSRP;
	
	// 1:N Relationship Unidirectional with OrderDetail
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetail> orderdetails;
	
	//auto generated getters and setters. 
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getMSRP() {
		return MSRP;
	}
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}
	public List<OrderDetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<OrderDetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	
	
	

}

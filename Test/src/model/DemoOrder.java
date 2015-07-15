package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DEMO_ORDERS database table.
 * 
 */
@Entity
@Table(name="DEMO_ORDERS")
@NamedQuery(name="DemoOrder.findAll", query="SELECT d FROM DemoOrder d")
public class DemoOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ORDER_ID")
	private long orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_TIMESTAMP")
	private Date orderTimestamp;

	@Column(name="ORDER_TOTAL")
	private BigDecimal orderTotal;

	//bi-directional many-to-one association to DemoCustomer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private DemoCustomer demoCustomer;

	//bi-directional many-to-one association to DemoUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private DemoUser demoUser;

	//bi-directional many-to-one association to DemoOrderItem
	@OneToMany(mappedBy="demoOrder")
	private List<DemoOrderItem> demoOrderItems;

	public DemoOrder() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTimestamp() {
		return this.orderTimestamp;
	}

	public void setOrderTimestamp(Date orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public BigDecimal getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public DemoCustomer getDemoCustomer() {
		return this.demoCustomer;
	}

	public void setDemoCustomer(DemoCustomer demoCustomer) {
		this.demoCustomer = demoCustomer;
	}

	public DemoUser getDemoUser() {
		return this.demoUser;
	}

	public void setDemoUser(DemoUser demoUser) {
		this.demoUser = demoUser;
	}

	public List<DemoOrderItem> getDemoOrderItems() {
		return this.demoOrderItems;
	}

	public void setDemoOrderItems(List<DemoOrderItem> demoOrderItems) {
		this.demoOrderItems = demoOrderItems;
	}

	public DemoOrderItem addDemoOrderItem(DemoOrderItem demoOrderItem) {
		getDemoOrderItems().add(demoOrderItem);
		demoOrderItem.setDemoOrder(this);

		return demoOrderItem;
	}

	public DemoOrderItem removeDemoOrderItem(DemoOrderItem demoOrderItem) {
		getDemoOrderItems().remove(demoOrderItem);
		demoOrderItem.setDemoOrder(null);

		return demoOrderItem;
	}

}
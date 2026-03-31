package e_commerce;

public class Order_detail {
	int orderid;
	String customerName;
	String ProductName;
	int qty;
	int price;
	
	Order_detail(int id,String cname,String pname,int qty,int price){
		this.orderid=id;
		this.customerName=cname;
		this.ProductName=pname;
		this.qty=qty;
		this.price=price;
	}
	
	

}

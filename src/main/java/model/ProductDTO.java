package model;

public class ProductDTO {
	private String productName;
	private int count;
	
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCount() {
		return count;
	}
	/*
	public void setCount() { // 매개변수가 없는 setter는 제대로된 setter가 아니다 
		count++;
	}
	*/
	public void plusCount() {
		count++;
	}
	
	
}

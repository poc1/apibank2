package com.redhat.devopers.model;

public class CustomerData {
	
	private String customerId;
    private String originChannel;
    private String fullName;
    private String condition;
    private String segment;
    private String address;
    private String customerCategory;
    
    
    public CustomerData() {}
       
    
	public CustomerData(String customerId, String originChannel, String fullName, String condition, String segment,
			String address, String customerCategory) {
		super();
		this.customerId = customerId;
		this.originChannel = originChannel;
		this.fullName = fullName;
		this.condition = condition;
		this.segment = segment;
		this.address = address;
		this.customerCategory = customerCategory;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOriginChannel() {
		return originChannel;
	}
	public void setOriginChannel(String originChannel) {
		this.originChannel = originChannel;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
    
    


}

package com.revature.reimbursements.models;

import java.util.List;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private String employeeLocale;
	private int phoneNumber;
	private boolean isManager;
	private List<RefundTicket> tickets;
	
	
	public Employee() {
		
	}
	
	
	
	public Employee(int employeeId, String employeeName, String employeeLocale, int phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeLocale = employeeLocale;
		this.phoneNumber = phoneNumber;
	}



	public Employee(String employeeName, String employeeLocale, int phoneNumber,boolean isManager) {
		this.employeeName=employeeName;
		this.employeeLocale=employeeLocale;
		this.phoneNumber=phoneNumber;
		this.isManager=isManager;
	}

	
	
	public Employee(String employeeName, String employeeLocale, int phoneNumber,boolean isManager,int employeeId,List<RefundTicket> tickets) {
		this(employeeName,employeeLocale,phoneNumber,isManager,employeeId);
		this.tickets=tickets;
	}
	
	
	public Employee(String employeeName, String employeeLocale, int phoneNumber,boolean isManager,int employeeId) {
		this(employeeName,employeeLocale,phoneNumber,isManager);
		this.employeeId=employeeId;
	}
	
	
	public Employee(String employeeName, String employeeLocale, int phoneNumber) {
		this.employeeName=employeeName;
		this.employeeLocale=employeeLocale;
		this.phoneNumber=phoneNumber;
	}


	
//	public Employee(String employeeName,String employeeLocale, int phoneNumber, ) {
//		this(employeeName,employeeLocale,phoneNumber);
//		this.tickets=tickets;
//	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<RefundTicket> getTickets() {
		return tickets;
	}

	public void setTickets(List<RefundTicket> tickets) {
		this.tickets = tickets;
	}

	
	
	public String getEmployeeLocale() {
		return employeeLocale;
	}

	public void setEmployeeLocale(String employeeLocale) {
		this.employeeLocale = employeeLocale;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeLocale="
				+ employeeLocale + ", phoneNumber=" + phoneNumber + ", isManager=" + isManager + ", tickets=" + tickets
				+ "]";
	}




	
	
	
	
	
	
	

}

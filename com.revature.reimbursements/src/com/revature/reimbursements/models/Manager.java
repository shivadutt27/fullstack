package com.revature.reimbursements.models;

public class Manager {
	private int managerId;
	private String managerName;
	private String managerDept;

	
	public Manager() {
		
	}
	
	public Manager(String managerName, String managerDept) {
		this.managerName=managerName;
		this.managerDept=managerDept;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerDept() {
		return managerDept;
	}

	public void setManagerDept(String managerDept) {
		this.managerDept = managerDept;
	}
	
	
	
	
}

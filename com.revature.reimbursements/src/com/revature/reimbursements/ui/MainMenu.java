package com.revature.reimbursements.ui;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.revature.reimbursement.bl.IEmployeeBL;
import com.revature.reimbursement.bl.ITicketBL;
import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

public class MainMenu {
	
	private Scanner myScanner;
	private ITicketBL ticketBL;
	private IEmployeeBL employeeBL;
//	private final Logger myLogger = LogManager.getLogger(this.getClass());


	public MainMenu(Scanner myScanner,ITicketBL ticketBL,IEmployeeBL employeeBL) {
		this.myScanner=myScanner;
		this.ticketBL = ticketBL;
		this.employeeBL=employeeBL;
	}
	
	
	public void start() throws Exception {		
		boolean isDone = true;
		while(isDone) { 
			Employee empObj = new Employee();
			System.out.println("Please introduce yourself: \n"
							  + "[E] Employee: \n"
							  + "[M] Manager: \n");
			String getInput = myScanner.nextLine().toLowerCase();
			switch(getInput){
				case"e":
					System.out.println("You introduced as an Employee: ");
					empObj.setManager(false);
					employeTab();
					break;
				case"m":
					System.out.println("You introduced as an Manager");
					empObj.setManager(true);
					managerTab();
					break;
				default:
					System.out.println("Please provide an appropriate response");
					break;
			}
		}
			/*
			System.out.println("How would you like to interact with the reimburse tickets \n "
							   + "[E] Create Employee \n"
					           + "[1] Create ticket \n "
					           + "[2] View Specific ticket \n "
					           + "[3] View all Employee tickets \n "
					           + "[4] Update ticket status"
					           + "[x] Exit");
			String myOption = myScanner.nextLine();
			
			switch(myOption) {
				case "E":
					System.out.println("Create Employee");
					createEmployee();
					break;
				case "1":
					System.out.println("Creating ticket....");
					createTicket();
					break;
				case "2":
					System.out.println("View specific ticket.....");
					viewTicketById();
					break;
				case "3":
					System.out.println("Viewing all Employee tickets");
					viewAllEmpTicket();
					break;
				case "4":
					System.out.println("Updating ticket ....");
					viewTickets();
					break;
				case "x":
					System.out.println("exit");
					break;
					
					default:
						break;
						
			}
		}*/
			
		}
	
	
//	============================================Employee Tab=========================================================
	
private void employeTab() throws Exception {
	System.out.println("Please choose the appropriate option: \n"
					   + "[C] Create an account: \n"
					   + "[T] Create Reimbursement Ticket \n"
					   + "[V] View all your tickets \n"
					   + "[X] Exit");
	String getEmpInput=myScanner.nextLine().toLowerCase();
	switch(getEmpInput) {
	case"c":
		System.out.println("You chosse to create your emp account : \n");
		createEmployee();
		break;
	case"t":
		System.out.println("You choose to raise Reimbursement Ticket : \n");
		createTicket();
		break;
	case"v":
		System.out.println("Viewing all tickets");
		viewTicketById();
		break;
	case"x":
		System.out.println("Exiting");
		start();
		break;
	default:
		System.out.println("Please Enter valid input");
		break;
	}
}
	

//======================================================Manager Tab=====================================================================

private void managerTab() throws Exception {
	System.out.println("Please Choos ethe appropriate option: \n"
					   + "[V] View all employee tickets \n"
					   + "[U] Update Ticket \n"
					   + "[X] Exit \n");
	String getManInput = myScanner.nextLine().toLowerCase();
	switch(getManInput) {
	case"v":
		System.out.println("Viewing Employee Tickets: \n");
		viewAllEmpTicket();
		break;
	case"u":
		System.out.println("Update the ticket: \n");
		updateTicket();
		break;
	case"x":
		System.out.println("Exiting: \n");
		start();
		break;
	default:
		System.out.println("Please Enter valid option: ");
		break;
	}
}
	
	
	
		

// --------------------------------------------------------------------Creating Ticket ------------------------------------------------------------------------------------------>>
private void createTicket() throws Exception {


//	2. Reimbursement Type -->
	
	List<Employee> allEmployees = employeeBL.getEmployees();
	for(Employee oneEmployee:allEmployees) {
		oneEmployee.getEmployeeId();
		System.out.println(oneEmployee);
		
	}
	
	System.out.println("Enter the id of Employee who wants to create ticket");
	
	int employeeId = Integer.parseInt(myScanner.nextLine());
	Employee employee = null;
	try {
		if(employeeBL.getEmployeeById(employeeId)==null) {
			System.out.println("Create your account first: \n");
			createEmployee();
		}else {
			System.out.println("What type: [L] LODGING \n" + "[T] TRAVEL  \n" + "[F] FOOD     \n" + "[M] MEDICAL  \n"
					+ "[O] OTHER    \n");
			String userInput = myScanner.nextLine(); // ---> Getting the userInput
			Reimbursement type = null;
			switch (userInput) {
			case "L":
				type = Reimbursement.valueOf("LODGING");
				break;

			case "T":
				type = Reimbursement.valueOf("TRAVEL");
				break;

			case "F":
				type = Reimbursement.valueOf("FOOD");
				break;

			case "M":
				type = Reimbursement.valueOf("MEDICAL");
				break;

			case "O":
				type = Reimbursement.valueOf("OTHER");
				break;

			default:
				System.out.println("Sorry Wrong Input Please try Again");
				break;
			}
	//3. Transaction amount --->
			System.out.println("Please Enter the Transaction Amount");
			String userAmount = myScanner.nextLine();
			int transAmount = Integer.valueOf(userAmount);
			LocalDateTime timeNow = LocalDateTime.now();
			RefundTicket myTicket = new RefundTicket(transAmount, type,Status.PENDING,timeNow,employee.getEmployeeId());
			myTicket.setEmployeeId(employeeId);
			ticketBL.addTicket(myTicket);

			System.out.println(myTicket);
		}
	}catch(Exception e) {
		e.printStackTrace();	
	}
		
	}	
			
			
	
		


private void createEmployee() {
	System.out.println("Enter your name? ");
	String empName = myScanner.nextLine();
	
	System.out.println("Enter your locale? ");
	String empLocale = myScanner.nextLine();
	
	System.out.println("Enter your phone");
	int employeePhone = Integer.parseInt(myScanner.nextLine());
	
	Employee myEmployee = new Employee(empName,empLocale,employeePhone);
	employeeBL.addEmployee(myEmployee);	
	
	System.out.println(myEmployee);
	
}

		

//------------------------------------------------------------View Tickets--------------------------------------------------------------->>

private void viewTicketById() throws Exception {
	System.out.println("Select ticket By ID:");
	
	for(RefundTicket oneTicket:ticketBL.getTickets()) {
		System.out.println(oneTicket);
	}
	int select = Integer.parseInt(myScanner.nextLine());
	RefundTicket selectedTicket;
	try {
		selectedTicket = ticketBL.getTicketById(select);
		System.out.println(selectedTicket);
	}catch(Exception e) {
		e.printStackTrace();
	}
}



//------------------------------------------------------------View Specific Ticket ------------------------------------------------------->>

private void viewAllEmpTicket() throws Exception{
	
	
	List<Employee> allEmployees = employeeBL.getEmployees();
	for(Employee oneEmployee:allEmployees) {
		System.out.println(oneEmployee);
	}
	System.out.println("Enter employee ID");
	int select = Integer.parseInt(myScanner.nextLine());
	try {
//			Employee emply = employeeBL.getEmployeeById(select);
//			int emplId = emply.getEmployeeId();
			for(RefundTicket oneTicket:ticketBL.getTickets()) {
				if(oneTicket.getEmployeeId()==select) {
					System.out.println(oneTicket);
				}
			}
	}catch(Exception e) {
		e.printStackTrace();
	}

	
	
//	System.out.println("Enter the id of the Employee you'd like to view the ticket for: ");
//	int myEmpID = Integer.parseInt(myScanner.nextLine());
//	Employee foundEmployee = employeeBL.getEmployeeById(myEmpID);
//	System.out.println(foundEmployee);
//	for(RefundTicket oneTicket:foundEmployee.getTickets()) {
//		System.out.println(oneTicket);
//	}
//	RefundTicket myTicket = ticketBL.getTicketById(myTicketId);
//	System.out.println(myTicket);
}


	
	

//-----------------------------------------------------------Updating the ticket------------------------------------------------------------
private void updateTicket() throws Exception {
//	// TODO Auto-generated method stub
	List<RefundTicket> getAllTickets=ticketBL.getTickets();
	for(RefundTicket oneTicket: getAllTickets) {
		System.out.println(oneTicket);
	}
	System.out.println("Please Enter ticketId: ");
	int getTicketId = Integer.parseInt(myScanner.nextLine());
	
	RefundTicket selectedTicket;
	try {
		selectedTicket = ticketBL.getTicketById(getTicketId);
		System.out.println("Update Status: "
						+ "[A] Accept"
						+ "[R] Rejected"
						+ "[X] Exit");
		String userInput = myScanner.nextLine().toLowerCase();
		switch(userInput) {
		case "a":
			selectedTicket.setRefundStatus(Status.APPROVED);
			ticketBL.updateTicket(selectedTicket);
			System.out.println("Ticket Approved");
			break;
			
		case "r":
			selectedTicket.setRefundStatus(Status.REJECTED);
			ticketBL.updateTicket(selectedTicket);
			System.out.println("Ticket Rejected");
			break;
			
		case "x":
			System.out.println("Main Menu");
			
		default:
			break;
		}
	}catch(NumberFormatException ex) {
		System.out.println("Numerics only");
		
	}
}

private void viewTickets() throws Exception {
	for(RefundTicket oneTicket:ticketBL.getTickets()) {
		System.out.println(oneTicket);
	}
	System.out.println("Filter Tickets by status: "
					  + "\n[A] Approved"
					  + "\n[P] Pending"
					  + "\n[R] Rejected"
					  + "\n[E] Exit");
	
	String select = myScanner.nextLine().toLowerCase();
	switch(select) {
	case "a":
		for(RefundTicket ticket:ticketBL.filterStatus(Status.APPROVED)) {
			System.out.println(ticket);
		}
		updateTicket();
		break;
	case "p":
		for(RefundTicket ticket:ticketBL.filterStatus(Status.PENDING)) {
			System.out.println(ticket);
		}
		updateTicket();
		break;
	case "r":
		for(RefundTicket ticket:ticketBL.filterStatus(Status.REJECTED)) {
			System.out.println(ticket);
		}
		updateTicket();
		break;
	case"x":
		System.out.println("Main menu");
		start();
		break;
	default:
		System.out.println("OOPS try again");
		break;
		
	}
}

private void toggleManager(Employee employee) {
	try {
		employee.setManager(!employee.isManager());
		employeeBL.updateEmployee(employee);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}


		
		

	
	


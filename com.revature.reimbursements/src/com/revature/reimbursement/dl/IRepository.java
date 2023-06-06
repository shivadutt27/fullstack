package com.revature.reimbursement.dl;


import java.util.List;

import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

/**
 * @author dutTech
 * This interface for the data layer 
 * 1.) This class wont be instantiated 
 * 2.) Write the Abstract method --- Just the body of the method  
 */

public interface IRepository {
	void addTicket(RefundTicket newTicket); 
	List<RefundTicket>getTickets() throws Exception;
	RefundTicket getTicketById(int id);
	List<RefundTicket> filterStatus(Status status);
	void  ticket2Update(RefundTicket ticket);
	void addEmployee(Employee newEmployee);
	Employee getEmployeeById(int id) throws Exception;
	List<Employee>getEmployees() throws Exception;
	void updateEmployee(Employee newEmployee);
	List<RefundTicket>getTicketsByEmployeeId(int id);

}

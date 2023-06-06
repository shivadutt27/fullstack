package com.revature.reimbursement.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

public class DBRepository implements IRepository{
	private DAO<RefundTicket,Integer> ticketDAO;
	private DAO<Employee,Integer> employeeDAO;
	
	public DBRepository(DAO<RefundTicket,Integer> ticketDAO,
						DAO<Employee,Integer> employeeDAO) {
		this.ticketDAO=ticketDAO;
		this.employeeDAO=employeeDAO;
	}

	@Override
	public void addTicket(RefundTicket newTicket) {
		// TODO Auto-generated method stub
		ticketDAO.add(newTicket);
		
	}

	@Override
	public List<RefundTicket> getTickets() throws Exception {
		// TODO Auto-generated method stub
		
		return ticketDAO.findAll();
	}

	@Override
	public RefundTicket getTicketById(int id) {
		// TODO Auto-generated method stub
		return ticketDAO.findById(id);
	}

	@Override
	public void ticket2Update(RefundTicket ticket) {
		// TODO Auto-generated method stub
		ticketDAO.update(ticket);
	}

	@Override
	public void addEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
			employeeDAO.add(newEmployee);

	}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		// TODO Auto-generated method stub
		
		Employee empWanted = employeeDAO.findById(id);
		List<RefundTicket> allTickets = ticketDAO.findAll();
		
		ArrayList<RefundTicket> ticket4Employee = new ArrayList<RefundTicket>();
		for(RefundTicket oneTicket:allTickets) {
			if(oneTicket.getEmployeeId()==id) {
				ticket4Employee.add(oneTicket);
			}
				
		}
		empWanted.setTickets(ticket4Employee);
		return empWanted;
	}

	@Override
	public List<RefundTicket> filterStatus(Status status) {
		// TODO Auto-generated method stub
		return ticketDAO.filterStatus(status);
	}

	@Override
	public List<Employee> getEmployees() throws Exception {
		// TODO Auto-generated method stub
		
		return employeeDAO.findAll();
	}

	@Override
	public void updateEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.update(newEmployee);
		
	}

	@Override
	public List<RefundTicket> getTicketsByEmployeeId(int id) {
		// TODO Auto-generated method stub
		
		return ticketDAO.getTicketByEmployeeId(id);
	}




}

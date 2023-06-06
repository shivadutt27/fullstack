package com.revature.reimbursement.bl;

import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.dl.DBRepository;
import com.revature.reimbursement.dl.IRepository;
import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.RefundTicket;


public class TicketBL implements ITicketBL {
	
	private DBRepository dbRepo;
	
	public TicketBL(DBRepository dbRepo) {
		this.dbRepo = dbRepo;
	}

	@Override
	public void addTicket(RefundTicket ticket) {
		// TODO Auto-generated method stub
		dbRepo.addTicket(ticket);
		
	}

	@Override
	public List<RefundTicket> getTickets() throws Exception {
		// TODO Auto-generated method stub
		return dbRepo.getTickets();
	}

	@Override
	public RefundTicket getTicketById(int id){
		// TODO Auto-generated method stub
		return dbRepo.getTicketById(id);
	}

	@Override
	public void updateTicket(RefundTicket ticket) {
		// TODO Auto-generated method stub
		dbRepo.ticket2Update(ticket);
	}

	@Override
	public List<RefundTicket> filterStatus(Status status) {
		// TODO Auto-generated method stub
		return dbRepo.filterStatus(status);
	}

	@Override
	public List<RefundTicket> getTicketByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return dbRepo.getTicketsByEmployeeId(id);
	}

	

}



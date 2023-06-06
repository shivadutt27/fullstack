package com.revature.reimbursement.dl;

import java.util.ArrayList;

import com.revature.reimbursements.models.RefundTicket;

public interface IRefundTicket {
	
	void addTicket(RefundTicket newTicket);
	ArrayList<RefundTicket>getAllTickets();
	RefundTicket getTicketById(int id);

}

package com.revature.reimbursements.controllers;




import com.revature.reimbursement.bl.ITicketBL;
import com.revature.reimbursements.enums.Status;

import com.revature.reimbursements.models.RefundTicket;

import io.javalin.http.Handler;

public class TicketController implements EController{
	private ITicketBL ticketBL;
	public TicketController(ITicketBL ticketBL) {
		this.ticketBL=ticketBL;
		
	}
	@Override
	public Handler getAll() {
		// TODO Auto-generated method stub
		return ctx -> {
			ctx.jsonStream(ticketBL.getTickets());

		};
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return ctx -> {
			String id = ctx.pathParam("ticket_id");
			Integer actualId = Integer.parseInt(id);
			try {
				
				ctx.jsonStream(ticketBL.getTicketById(actualId));
			}catch(NullPointerException ex) {
				ctx.res.setStatus(204);
			}
		};
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			ticketBL.addTicket(ctx.bodyStreamAsClass(RefundTicket.class));
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return ctx -> {
				ticketBL.updateTicket(ctx.bodyStreamAsClass(RefundTicket.class));
		};
	}
				
			
	@Override
	public Handler getFilteredTickets() {
		// TODO Auto-generated method stub
		return ctx ->{
			String queryInput = ctx.pathParam("ticket_status");
			Status qStatus = Status.valueOf(queryInput);
			ctx.jsonStream(ticketBL.filterStatus(qStatus));
		};
	}
	
	@Override
	public Handler getTicketIfManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

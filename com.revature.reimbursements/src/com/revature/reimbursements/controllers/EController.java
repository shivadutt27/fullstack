package com.revature.reimbursements.controllers;

import io.javalin.http.Handler;

/**
 * @author dutTech
 * Contain methods that when implemented would define
 * controller handling http request
 *
 */
public interface EController {
	Handler getAll();
	Handler getById();
	Handler add();
	Handler update();
	Handler getFilteredTickets();
	Handler getTicketIfManager();
}

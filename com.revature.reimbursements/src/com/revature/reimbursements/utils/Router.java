package com.revature.reimbursements.utils;

import com.revature.reimbursements.controllers.EController;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

import io.javalin.Javalin;

public class Router {
	private Javalin app;
	private EController employeeController;
	private EController ticketController;
	
	public Router(Javalin app, EController employeeController,EController ticketController) {
		this.app = app;
		this.employeeController = employeeController;
		this.ticketController=ticketController;
	}
	
	public void setUpEndPoints() {
		
//===============================Employee Routes====================================================================================		
		
		app.get("/Employees", OpenApiBuilder.documented(DocumentationFactory.getDoc("getEmployees"),employeeController.getAll()));
		app.get("/Employees/{Employee_id}/tickets",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getEmployeeById"),employeeController.getById()));
		app.put("/Employees/{Employee_id}",OpenApiBuilder.documented(DocumentationFactory.getDoc("updateEmployee"), employeeController.update()));
		app.post("/Employees",OpenApiBuilder.documented(DocumentationFactory.getDoc("addEmployee"), employeeController.add()));
		
//================================Tickets Route ==============================================================================		
		
		app.get("/tickets/{ticket_id}",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getTicketById"),ticketController.getById()));
		
		app.post("/tickets",OpenApiBuilder.documented(DocumentationFactory.getDoc("addTicket"), ticketController.add()));
		app.put("/updatetickets/{ticketId}",OpenApiBuilder.documented(DocumentationFactory.getDoc("updateTicket"), ticketController.update()));
		
//==================================Manager Routes ===================================================================================	
		
		app.get("/gettickets", OpenApiBuilder.documented(DocumentationFactory.getDoc("getTickets"),ticketController.getAll()));
		app.get("/filtertickets/{ticket_status}",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getFilteredTickets"),ticketController.getFilteredTickets()));
//		app.get("/tickets/{Employee_id}", OpenApiBuilder.documented(DocumentationFactory.getDoc("getTicketsIfManager"),employeeController.getTicketIfManager()));
	}

}

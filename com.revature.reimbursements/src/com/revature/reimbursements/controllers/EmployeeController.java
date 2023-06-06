package com.revature.reimbursements.controllers;

import com.revature.reimbursement.bl.IEmployeeBL;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

import io.javalin.http.Handler;

public class EmployeeController implements EController{
	private IEmployeeBL employeeBL;
	
	public EmployeeController(IEmployeeBL employeeBL) {
		this.employeeBL=employeeBL;
	}
	@Override
	public Handler getAll() {
		// Handler is a functional interface
		// A means to pass function as parameters
		//	we'll be returning a lambda function	
		return ctx -> {
			ctx.jsonStream(employeeBL.getEmployees());
		};
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return ctx -> {
			String id = ctx.pathParam("Employee_id");
			int actualId = Integer.parseInt(id);
			try {
				
				ctx.jsonStream(employeeBL.getEmployeeById(actualId));
			}catch(NullPointerException ex) {
				ctx.res.setStatus(204);
				ex.printStackTrace();
			}
		};
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			employeeBL.addEmployee(ctx.bodyStreamAsClass(Employee.class));
				
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return ctx -> {
//			employeeBL.updateEmployee(ctx.bodyStreamAsClass(Employee.class));
			int empId = Integer.parseInt(ctx.pathParam("Employee_id"));
			boolean getMan = Boolean.valueOf(ctx.queryParam("is_Manager"));
			Employee empObj = new Employee();
			empObj.setManager(getMan);
			employeeBL.updateEmployee(ctx.bodyStreamAsClass(Employee.class));
		};
	}
	@Override
	public Handler getFilteredTickets() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Handler getTicketIfManager() {
		// TODO Auto-generated method stub
		return ctx->{
				int empId =Integer.parseInt(ctx.queryParam("Employee_id"));
				
				try {
				ctx.jsonStream(employeeBL.getTicketsIfManager(empId));
			}catch(NullPointerException e) {
				e.printStackTrace();
				ctx.res.setStatus(204);
			}
		
		};
	}

}

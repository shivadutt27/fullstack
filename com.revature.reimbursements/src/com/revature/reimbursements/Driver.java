package com.revature.reimbursements;

import java.util.Scanner;

import com.revature.reimbursement.bl.EmployeeBL;
import com.revature.reimbursement.bl.TicketBL;
import com.revature.reimbursement.dl.DBRepository;
import com.revature.reimbursement.dl.EmployeeDAO;
import com.revature.reimbursement.dl.TicketDAO;

import com.revature.reimbursements.ui.MainMenu;

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		MainMenu myMenu = new MainMenu(new Scanner(System.in),new TicketBL(new DBRepository(new TicketDAO(),
						  new EmployeeDAO())),new EmployeeBL(new DBRepository(new TicketDAO(),new EmployeeDAO())));
		myMenu.start();
		

	

	}
}
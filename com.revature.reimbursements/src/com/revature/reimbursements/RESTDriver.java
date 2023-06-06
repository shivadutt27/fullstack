package com.revature.reimbursements;

import java.util.Scanner;

import com.revature.reimbursement.bl.EmployeeBL;
import com.revature.reimbursement.bl.TicketBL;
import com.revature.reimbursement.dl.DBRepository;
import com.revature.reimbursement.dl.EmployeeDAO;
import com.revature.reimbursement.dl.TicketDAO;
import com.revature.reimbursements.controllers.EController;
import com.revature.reimbursements.controllers.EmployeeController;
import com.revature.reimbursements.controllers.TicketController;
import com.revature.reimbursements.ui.MainMenu;
import com.revature.reimbursements.utils.DocumentationFactory;
import com.revature.reimbursements.utils.Router;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

public class RESTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	Create Controller
		EController eController = new EmployeeController(new EmployeeBL(new DBRepository(new TicketDAO(),new EmployeeDAO())));
		EController tController = new TicketController(new TicketBL(new DBRepository(new TicketDAO(),new EmployeeDAO())));
		
		/*
		Javalin app = Javalin.create(config -> {
			config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
		}).start(7000);
		*/
		//To enable cors
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins()).start(7000);
		
		Router router = new Router(app,eController,tController);
		router.setUpEndPoints();
	}
		
	private static OpenApiOptions getOpenApiOptions() {
		Info applicationInfo = new Info().version("1.0").description("Reimbursement REST");
		return new OpenApiOptions(applicationInfo).path("/swagger-docs")
				.swagger(new SwaggerOptions("/swagger").title("Reimbursement API Docs"));
	}

}

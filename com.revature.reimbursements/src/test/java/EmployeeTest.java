package test.java;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.revature.reimbursements.models.Employee;

class EmployeeTest {
	@Test
	void IsEmployeeNameIsSet() {
		// Arrange ======>
		String empName = "Shivam";
		Employee myEmp = new Employee();
		
		// Act =====>
		myEmp.setEmployeeName(empName);
		
		// Assert =====>
		Assert.assertEquals(empName, myEmp.getEmployeeName());
		
//		Assert.fail("Not yet implemented");
	}

}

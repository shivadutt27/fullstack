package com.revature.reimbursements.models;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;

public class RefundTicket {

	private int ticketId;
	private int refundAmount;
	private Reimbursement refundType;
	private Status refundStatus;
//	private Timestamp timeStamp;
//	private Date timeStamp;
	private LocalDateTime timeStamp;
	private int employeeId;
	
	
	public RefundTicket() {
		
	}
	
	public RefundTicket(Status refundStatus) {
		this.refundStatus=refundStatus;
	}
	
	public RefundTicket(int refundAmount,Reimbursement refundType,Status refundStatus,LocalDateTime timeStamp,int employeeId) {
		this.refundAmount=refundAmount;
		this.refundType=refundType;
		this.refundStatus=refundStatus;
		this.timeStamp = timeStamp;
		this.employeeId=employeeId;
	}
	
	public RefundTicket(int refundAmount,Reimbursement refundType,Status refundStatus,LocalDateTime timeStamp,int employeeId,int ticketId) {
		this(refundAmount,refundType,refundStatus,timeStamp,employeeId);
		this.ticketId=ticketId;
	}





	public int getRefundAmount() {
		return refundAmount;
	}
	
	

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Reimbursement getRefundType() {
		return refundType;
	}

	public void setRefundType(Reimbursement refundType) {
		this.refundType = refundType;
	}

	public Status getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Status refundStatus) {
		this.refundStatus = refundStatus;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getTicketId() {
		return ticketId;
	}

//	public void setTicketId(int ticketId) {
//		this.ticketId = ticketId;
//	}
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "RefundTicket [ticketId=" + getTicketId() + ", refundAmount=" + refundAmount + ", refundType=" + refundType
				+ ", refundStatus=" + refundStatus + ", timeStamp=" + timeStamp + ", employeeId=" + employeeId + "]";
	}

	

}

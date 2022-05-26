package com.cts.bank.restController;

public class UserErrorResponse {
	
	private String message;
	
	private int status;
	
	private long timestamp;

	public UserErrorResponse(String message, int status, long timestamp) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	public UserErrorResponse() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}



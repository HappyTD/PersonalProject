package entity;

import java.io.Serializable;

public class ReturnResult implements Serializable{
	
	private boolean success;
	private String message;
	public ReturnResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getmessage() {
		return message;
	}
	public void setmessage(String message) {
		this.message = message;
	}
	
	

}

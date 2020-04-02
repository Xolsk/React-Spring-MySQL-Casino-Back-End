package com.casino.casino.helpers;



public class Response {
	
	
	Object object;
	String message;
	
	public Response(Object object, String string) {
		this.object=object;
		this.message=string;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package com.epam.order.model.response;

public class ResponseDTO<T> {
	
	//@JsonInclude(Include.NON_NULL)
	private T body;
	private Meta meta;
	
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	
	

}

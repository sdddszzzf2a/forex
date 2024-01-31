package com.wu.forexapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject {

	@JsonProperty("error")
	private ErrorStatus errorStatus;
	
	@JsonProperty("currency")
	private Forex[] forexs;

	public ResponseObject() {
		super();
	}
	
	public ResponseObject(ErrorStatus errorStatus, Forex[] forexs) {
		super();
		this.errorStatus = errorStatus;
		this.forexs = forexs;
	}

	public ErrorStatus getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(ErrorStatus errorStatus) {
		this.errorStatus = errorStatus;
	}

	public Forex[] getForexs() {
		return forexs;
	}

	public void setForexs(Forex[] forexs) {
		this.forexs = forexs;
	}
}

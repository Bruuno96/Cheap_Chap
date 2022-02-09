package com.project.cheapchap.controller.api.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	LocalDateTime lt = LocalDateTime.now();
	
	
	public StandardError(Integer status, String msg, LocalDateTime lt) {
		super();
		this.status = status;
		this.msg = msg;
		this.lt = lt;
	}
	
	
	public StandardError() {
		super();
	}


	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getTimeStamp() {
		return lt;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.lt = timeStamp;
	}
	
	

}

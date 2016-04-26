package com.fjsaas.web.utils.excel;

public class OptRowResutl {

	public static final String SUCCESS_FLAG = "success";
	public static final String FAIL_FLAG = "fail";
	
	private String result;
	private Object target;

	
	public OptRowResutl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptRowResutl(String result, Object target) {
		super();
		this.result = result;
		this.target = target;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	
}

package com.StudentCurd.StudentApplication_CurdBase.responseDTO;

public class ResponseDTO {
	 private boolean isSuccess;
	 private Object obj;
	 private String msg;
	public ResponseDTO(boolean isSuccess, Object obj, String msg) {
		super();
		this.isSuccess = isSuccess;
		this.obj = obj;
		this.msg = msg;
	}
	public ResponseDTO() {
		super();
		
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	 
	 
	 

}

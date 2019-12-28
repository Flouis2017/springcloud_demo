package com.flouis.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {

	public final static String SUCCESS_MSG = "Your request has been handled successfully.";
	public final static String FAIL_MSG = "Your request occurs error!";

	private Boolean flag;
	private String msg;
	private Object data;

	public static JsonResult success(){
		return new JsonResult(true, SUCCESS_MSG, null);
	}

	public static JsonResult success(String msg){
		return new JsonResult(true, msg, null);
	}

	public static JsonResult success(Object data){
		return new JsonResult(true, SUCCESS_MSG, data);
	}

	public static JsonResult fail(){
		return new JsonResult(false, FAIL_MSG, null);
	}

}

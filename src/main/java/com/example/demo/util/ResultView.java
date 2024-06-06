package com.example.demo.util;



/**
 * 响应结构
 * 
 * @author Mr.ma
 */
public class ResultView {
	
	private Integer code;  
    private String msg;
	private Integer count; //总条数
    private Object data; //结果集  
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public ResultView setBackMsg(String msg) {
		this.setMsg(msg);
		return this;
	}
	
	public ResultView setBackCount(Integer count) {
		this.setCount(count);
		return this;
	}
    
    public static ResultView success() {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.SUCCESS.getCode();
    	result.msg = ResultEnum.SUCCESS.getMsg();
    	return result;
    }
    
    public static ResultView success(String msg) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.SUCCESS.getCode();
    	result.msg = msg;
    	return result;
    }
    
    public static ResultView success(Object data) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.SUCCESS.getCode();
    	result.msg = ResultEnum.SUCCESS.getMsg();
    	result.data = data;
    	return result;
    }
    
    public static ResultView success(Object data, String msg) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.SUCCESS.getCode();
    	result.msg = msg;
    	result.data = data;
    	return result;
    }
    
    public static ResultView success(Object data, Integer count) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.SUCCESS.getCode();
    	result.msg = ResultEnum.SUCCESS.getMsg();
    	result.data = data;
    	result.count = count;
    	return result;
    }
    
    public static ResultView success(ResultEnum e, Object data, Integer count) {
    	ResultView result = new ResultView();
    	result.code = e.getCode();
    	result.msg = e.getMsg();
    	result.data = data;
    	result.count = count;
    	return result;
    }
    
    public static ResultView success(Object data, Integer count, Object obj) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.SUCCESS.getCode();
    	result.msg = ResultEnum.SUCCESS.getMsg();
    	result.data = data;
    	result.count = count;
    	return result;
    }
    
    public static ResultView success(ResultEnum e, Object data, Integer count, Object obj) {
    	ResultView result = new ResultView();
    	result.code = e.getCode();
    	result.msg = e.getMsg();
    	result.data = data;
    	result.count = count;
    	return result;
    }
    
    public static ResultView error() {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.ERROR.getCode();
    	result.msg = ResultEnum.ERROR.getMsg();
    	return result;
    }
    
    public static ResultView error(String msg) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.ERROR.getCode();
    	result.msg = msg;
    	return result;
    }
    
    public static ResultView error(String msg, Object data) {
    	ResultView result = new ResultView();
    	result.code = ResultEnum.ERROR.getCode();
    	result.msg = msg;
    	result.data = data;
    	return result;
    }
    
    public static ResultView error(ResultEnum e) {
    	ResultView result = new ResultView();
    	result.code = e.getCode();
    	result.msg = e.getMsg();
    	return result;
    }
    
    public static ResultView error(ResultEnum e, String msg) {
    	ResultView result = new ResultView();
    	result.code = e.getCode();
    	result.msg = msg;
    	return result;
    }
    
    public static ResultView result(Integer code, String msg) {
    	ResultView result = new ResultView();
    	result.code = code;
    	result.msg = msg;
    	return result;
    }
    
    public static ResultView error(ResultEnum e, Object obj) {
    	ResultView result = new ResultView();
    	result.code = e.getCode();
    	result.msg = e.getMsg();
    	result.data = obj;
    	return result;
    }
}

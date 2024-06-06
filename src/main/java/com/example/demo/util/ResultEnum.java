package com.example.demo.util;

/**
 * Ajax 请求时的自定义查询状态码，主要参考HTTP状态码
 *
 * @author Mr.ma
 */
public enum ResultEnum {

	/**************************服务器相关 */

	SUCCESS(200, "请求成功"),

	ERROR(100, "请求失败"),

	MULTI_STATUS(207, "频繁操作"),

	LOGIN_FAIL(303, "登录失败"),

	LOCKED(423, "已被锁定"),

	GONE(410, "已被删除"),

	BAD_REQUEST(400, "请求参数出错"),

	REQUEST_TIMEOUT(408, "请求超时"),

	UNAUTHORIZED(401, "请重新登录"),

	FORBIDDEN(403, "没有权限"),

	NOT_FOUND(404, "找不到页面 "),

	CONFLICT(409, "发生冲突"),

	INTERNAL_SERVER_ERROR(500, "服务器出错"),

	INTERNAL_SERVER_LOG_ERROR(501, "日志写入出错"),

	SYS_USER_NOT_FOUND(1001, "找不到用户"),

	NETWORK_ERROR(502, "网络出了问题"),

	NETWORK_OFF(503, "网络已经断开"),
	CODE_OFF(503, "验证码错误"),
	CODE_FILE(503, "上传图片出错"),
	CODE_ERROE(503, "当前用户未经过验证，拒绝访问"),
	CODE_AUDIO(504, "语音合成失败"),

	DATA_ERROR(500,"数据查询为空"),
	AI_ERROR(500,"新增AI识面图片错误"),
	ERROR_EXPORT(500,"获取预约人详细错误"),

	;

	private Integer code;
    private String msg;

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private ResultEnum(Integer code) {
		this.code = code;
	}

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}

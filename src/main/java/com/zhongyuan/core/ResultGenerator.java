package com.zhongyuan.core;

import com.zhongyuan.exception.ResultCodes;

/**
 * @description 响应结果生成工具
 * @author
 * @date 2017年11月29日下午8:09:41
 */
public class ResultGenerator {

	private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

	public static Result<Object> genSuccessResult() {
		Result<Object> result = new Result<Object>();
		return result.setHead(result.new Head().setCode(ResultCodes.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE));
	}

	public static <T> Result<T> genSuccessResult(T data) {
		Result<T> result = new Result<T>();
		return result.setHead(result.new Head().setCode(ResultCodes.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE)).setBody(data);
	}

	public static Result<Object> genFailResult(String message) {
		Result<Object> result = new Result<Object>();
		return result.setHead(result.new Head().setCode(ResultCodes.SERVICE_ERROR).setMessage(message));
	}

	public static Result<Object> genFailResult(ResultCodes errCode) {
		Result<Object> result = new Result<Object>();
		return result.setHead(result.new Head().setCode(errCode).setMessage(errCode.msg));
	}

}

package com.zhongyuan.core;

import cn.hutool.json.JSONUtil;
import com.zhongyuan.exception.ResultCodes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  统一API响应结果封装
 * @author 敢敢
 */
@ApiModel("统一API响应结果封装")
public class Result<T> {

	@ApiModelProperty(value = "统一API响应报文头")
	private Head head;
	@ApiModelProperty(value = "统一API响应报文体")
	private T body;

	public Head getHead() {
		return head;
	}

	public Result<T> setHead(Head head) {
		this.head = head;
		return this;
	}

	public T getBody() {
		return body;
	}

	public Result<T> setBody(T body) {
		this.body = body;
		return this;
	}

	@ApiModel("统一API响应报文头对象")
	public class Head {
		@ApiModelProperty(value = "状态码")
		private String code;

		@ApiModelProperty(value = "消息提示")
		private String message;

		public Head setCode(ResultCodes resultCode) {
			this.code = resultCode.code;
			return this;
		}

		public String getCode() {
			return code;
		}

		public Head setMessage(String message) {
			this.message = message;
			return this;
		}

		public String getMessage() {
			return message;
		}

	}

	@Override
	public String toString() {
		return JSONUtil.toJsonStr(this);
	}

}

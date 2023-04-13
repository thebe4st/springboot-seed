package com.zhongyuan.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private ResultCodes resultCodes;
    public ServiceException(ResultCodes resultCodes) {
        super(resultCodes.msg);
        this.resultCodes = resultCodes;
    }
    public ServiceException(ResultCodes resultCodes, Throwable throwable) {
        super(resultCodes.msg,throwable);
        this.resultCodes = resultCodes;
    }
}

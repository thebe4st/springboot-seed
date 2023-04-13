package com.zhongyuan.configurer;

import cn.hutool.core.util.StrUtil;
import com.zhongyuan.commons.UUIDGenerator;
import com.zhongyuan.core.Result;
import com.zhongyuan.core.ResultGenerator;
import com.zhongyuan.exception.ResultCodes;
import com.zhongyuan.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandlerConfigurer {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleBindingResultException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String msg = bindingResult.getFieldError().getDefaultMessage();
        return ResultGenerator.genFailResult(msg);
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Result<Object> handleServiceException(ServiceException e) {
        return ResultGenerator.genFailResult(e.getResultCodes());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        String errCode = UUIDGenerator.generate();
        log.error("server error, error code is [{}]",errCode, e);
        return ResultGenerator.genFailResult(StrUtil.format("服务器出了一个问题，而我们正在紧张的书写答案~ [{}]",errCode));
    }
}

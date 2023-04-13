package com.zhongyuan.configurer;

import cn.hutool.json.JSONUtil;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Slf4j
@Aspect
@Component
@Order(1)
public class ControllerAspectLog {

    @Pointcut("@annotation(com.zhongyuan.configurer.HttpLog)")
    public void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object resultObj = null;
        try {
            resultObj = joinPoint.proceed();
        } finally {
            // add logs
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

            // 记录下请求内容
            log.info("\n\nURL : {}\nMethod : {} \nParam : {}\nResult : {}\n",
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    JSONUtil.toJsonStr(joinPoint.getArgs()),
                    JSONUtil.toJsonStr(resultObj)
            );
        }
        return resultObj;
    }
}

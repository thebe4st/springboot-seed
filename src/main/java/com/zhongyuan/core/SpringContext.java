package com.zhongyuan.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring 上下文
 * @author 敢敢
 */
@Component
public final class SpringContext implements ApplicationContextAware {

	public static ApplicationContext APPLICATION_CONTEXT = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContext.APPLICATION_CONTEXT = applicationContext;
	}

	public static <T> T getBean(Class<T> requiredType) {
		return APPLICATION_CONTEXT.getBean(requiredType);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return APPLICATION_CONTEXT.getBean(name, requiredType);
	}

	public static Object getBean(String name) {
		return APPLICATION_CONTEXT.getBean(name);
	}

}

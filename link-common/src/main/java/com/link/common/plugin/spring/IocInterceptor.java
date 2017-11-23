package com.link.common.plugin.spring;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;

/**
 * Spring IOC 拦截器
 * @author linkzz
 * @date 2017-05-17
 */
public class IocInterceptor implements Interceptor {
    static ApplicationContext ctx;
    @Override
    public void intercept(Invocation invocation) {
        Field[] fields = invocation.getMethod().getDeclaringClass().getDeclaredFields();
        for (Field field : fields){
            Object bean;
            if (field.isAnnotationPresent(Inject.BY_NAME.class)){
                bean = ctx.getBean(field.getName());
            } else if (field.isAnnotationPresent(Inject.BY_TYPE.class)){
                bean = ctx.getBean(field.getType());
            }else {
                continue;
            }
            try {
                if (bean != null){
                    field.setAccessible(true);
                    field.set(invocation.getTarget(),bean);
                }
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
    }
}

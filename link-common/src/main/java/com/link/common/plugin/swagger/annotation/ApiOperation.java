package com.link.common.plugin.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * [description]
 *
 * @author lee
 * @version V1.0.0
 * @date 2017/7/7
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiOperation {
    String url() default "";

    String tag() default "";

    Class<?> response() default Void.class;

    String httpMethod() default "";

    String description() default "";
}

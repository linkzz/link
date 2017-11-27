package com.link.common.plugin.spring;

import java.lang.annotation.*;

/**
  * spring 依赖注入注解
  * @author linkzz
  * @create 2017-11-27 10:36
  */
public class Inject {
    private Inject() {
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public @interface BY_NAME {
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public @interface BY_TYPE {
    }
}

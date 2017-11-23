package com.link.common.plugin.spring;

import java.lang.annotation.*;

/**
 * Created by linkzz on 2017-05-17.
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

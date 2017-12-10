package com.link.common.plugin.swagger.utils;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.link.common.plugin.swagger.annotation.Api;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 类操作
 *
 * @author lee
 * @date 16/6/2
 */
public final class ClassHelper {
    private static final Logger logger = Logger.getLogger("logger");

    /**
     * 定义类集合(用于存放所加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;

    private static final Prop PROP = PropKit.use("config.properties");

    static {
        String basePackage = PROP.get("swagger.base_package");
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下所有的类
     *
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有的Service类
     *
     * @return
     */
    public static Set<Class<?>> getApiSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Api.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有 Bean 类(包括: API 等)
     *
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getApiSet());
        return beanClassSet;
    }

    /**
     * 获取应用包名下某父类(或接口)的所有子类(或实现类)
     *
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (superClass.isAssignableFrom(cls)
                    && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某注解的所有类
     *
     * @param annotationClass
     * @return
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}

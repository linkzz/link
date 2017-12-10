package com.link.api.server.controller;

import com.google.common.collect.Maps;
import com.jfinal.core.Controller;
import com.link.common.plugin.swagger.annotation.Api;
import com.link.common.plugin.swagger.annotation.ApiOperation;
import com.link.common.plugin.swagger.annotation.Param;
import com.link.common.plugin.swagger.annotation.Params;
import com.link.common.plugin.swagger.model.SwaggerDoc;
import com.link.common.plugin.swagger.model.SwaggerPath;
import com.link.common.plugin.swagger.utils.ClassHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author linkzz
 * @create 2017-12-08 15:19
 */
public class ApiController extends Controller {

    public void index(){
        render("index.html");
    }

    public void api(){
        SwaggerDoc swaggerDoc = new SwaggerDoc();
        swaggerDoc.setSwagger("2.0");
        swaggerDoc.setHost("www.link.com");
        swaggerDoc.setBasePath("/v1");
        SwaggerDoc.InfoBean info = new SwaggerDoc.InfoBean("接口文档测试","v1.0","测试接口文档","www.link.com/terms");
        swaggerDoc.setInfo(info);
        List<String> schemes = new ArrayList<>();
        schemes.add("http");
        swaggerDoc.setSchemes(schemes);
        Map<String,Map<String,SwaggerPath.ApiMethod>> paths = new HashMap<>();
        Map<String,String> classMap = Maps.newHashMap();
        Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
        for (Class<?> cls : classSet){
            if (cls.isAnnotationPresent(Api.class)){
                Api api = cls.getAnnotation(Api.class);
                if (!classMap.containsKey(api.tag())){
                    classMap.put(api.tag(),api.description());
                }
                Method[] methods = cls.getMethods();
                for (Method method : methods){
                    Annotation[] annotations = method.getAnnotations();
                    SwaggerPath.ApiMethod apiMethod = new SwaggerPath.ApiMethod();
                    apiMethod.setOperationId("");
                    apiMethod.addProduce("application/json");
                    for (Annotation annotation : annotations){
                        Class<? extends Annotation> annotationType = annotation.annotationType();
                        if (ApiOperation.class == annotationType){
                            ApiOperation apiOperation = (ApiOperation) annotation;
                            Map<String, SwaggerPath.ApiMethod> methodMap = new HashMap<>();
                            apiMethod.setSummary(apiOperation.description());
                            apiMethod.setDescription(apiOperation.description());
                            apiMethod.addTag(apiOperation.tag());
                            methodMap.put(apiOperation.httpMethod(), apiMethod);
                            paths.put(apiOperation.url(),methodMap);
                        }else if (Params.class == annotationType){
                            Params paramsOperation = (Params) annotation;
                            Param[] params = paramsOperation.value();
                            for (Param param : params){
                                apiMethod.addParameter(new SwaggerPath.Parameter(param.name(), param.description(), param.required(), param.dataType(), param.format(), param.defaultValue()));
                            }
                        }else if (Param.class == annotationType){
                            Param param = (Param) annotation;
                            apiMethod.addParameter(new SwaggerPath.Parameter(param.name(), param.description(), param.required(), param.dataType(), param.format(), param.defaultValue()));
                        }
                    }

                }
            }
        }

        if (!classMap.isEmpty()){
            for (String key : classMap.keySet()){
                swaggerDoc.addTags(new SwaggerDoc.TagBean(key, classMap.get(key)));
            }
        }

        swaggerDoc.setPaths(paths);
        // swaggerUI 使用Java的关键字default作为默认值,此处将生成的JSON替换
        //renderText(JSON.toJSONString(doc).replaceAll("\"defaultValue\"", "\"default\""));
        renderJson(swaggerDoc);
    }
}
